package com.lj.blog.common.utils;

import io.minio.*;
import io.minio.http.Method;
import io.minio.messages.Bucket;
import io.minio.messages.DeleteObject;
import io.minio.messages.Item;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.*;

/**
 * @ClassName MinioUtils
 * @Description 上传、下载文件的minio工具类
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/1/22 20:53
 * @Version JDK 17
 */
@Slf4j
@Component
public class MinioUtils {

    private final MinioClient minioClient;

    @Autowired
    public MinioUtils(MinioClient minioClient){
        this.minioClient = minioClient;
    }

    /**
     * 启动SpringBoot容器的时候初始化Bucket
     * 如果没有Bucket则创建
     *
     * @param bucketName 桶名
     */
    @SneakyThrows(Exception.class)
    private void createBucket(String bucketName) {
        if (!bucketExists(bucketName)) {
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
        }
    }

    /**
     * 判断Bucket是否存在，true：存在，false：不存在
     *
     * @param bucketName 桶名
     * @return 布尔
     */
    @SneakyThrows(Exception.class)
    public boolean bucketExists(String bucketName) {
        return minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
    }

    /**
     * 获得Bucket的策略模式
     *
     * @param bucketName 桶名
     * @return 该桶的策略
     */
    @SneakyThrows(Exception.class)
    public String getBucketPolicy(String bucketName) {
        return minioClient.getBucketPolicy(GetBucketPolicyArgs
                .builder()
                .bucket(bucketName)
                .build());
    }

    /**
     * 获得所有Bucket列表
     *
     * @return 所有的桶
     */
    @SneakyThrows(Exception.class)
    public List<Bucket> getAllBuckets() {
        return minioClient.listBuckets();
    }

    /**
     * 根据bucketName获取其相关信息
     *
     * @param bucketName 桶名
     * @return 获取桶的相关信息
     */
    @SneakyThrows(Exception.class)
    public Optional<Bucket> getBucket(String bucketName) {
        return getAllBuckets().stream().filter(b -> b.name().equals(bucketName)).findFirst();
    }

    /**
     * 根据bucketName删除Bucket，true：删除成功； false：删除失败，文件或已不存在
     *
     * @param bucketName 桶名
     */
    @SneakyThrows(Exception.class)
    public void removeBucket(String bucketName) {
        minioClient.removeBucket(RemoveBucketArgs.builder().bucket(bucketName).build());
    }

    /******************************  Operate Bucket End  ******************************/


    /******************************  Operate Files Start  ******************************/

    /**
     * 判断文件是否存在
     *
     * @param bucketName 桶名
     * @param objectName 文件名
     * @return 布尔
     */
    public boolean isObjectExist(String bucketName, String objectName) {
        boolean exist = true;
        try {
            minioClient.statObject(StatObjectArgs.builder().bucket(bucketName).object(objectName).build());
        } catch (Exception e) {
            log.error("[Minio工具类]>>>> 判断文件是否存在, 异常：", e);
            exist = false;
        }
        return exist;
    }

    /**
     * 判断文件夹是否存在
     *
     * @param bucketName 桶名
     * @param objectName 文件夹名
     * @return 布尔
     */
    public boolean isFolderExist(String bucketName, String objectName) {
        boolean exist = false;
        try {
            Iterable<Result<Item>> results = minioClient.listObjects(
                    ListObjectsArgs.builder().bucket(bucketName).prefix(objectName).recursive(false).build());
            for (Result<Item> result : results) {
                Item item = result.get();
                if (item.isDir() && objectName.equals(item.objectName())) {
                    exist = true;
                }
            }
        } catch (Exception e) {
            log.error("[Minio工具类]>>>> 判断文件夹是否存在，异常：", e);
            exist = false;
        }
        return exist;
    }

    /**
     * 根据文件前置查询文件
     *
     * @param bucketName 存储桶
     * @param prefix     前缀
     * @param recursive  是否使用递归查询
     * @return MinioItem 列表
     */
    @SneakyThrows(Exception.class)
    public List<Item> getAllObjectsByPrefix(String bucketName,
                                            String prefix,
                                            boolean recursive) {
        List<Item> list = new ArrayList<>();
        Iterable<Result<Item>> objectsIterator = minioClient.listObjects(
                ListObjectsArgs.builder().bucket(bucketName).prefix(prefix).recursive(recursive).build());
        if (objectsIterator != null) {
            for (Result<Item> o : objectsIterator) {
                Item item = o.get();
                list.add(item);
            }
        }
        return list;
    }

    /**
     * 获取文件流
     *
     * @param bucketName 存储桶
     * @param objectName 文件名
     * @return 二进制流
     */
    @SneakyThrows(Exception.class)
    public InputStream getObject(String bucketName, String objectName) {
        return minioClient.getObject(
                GetObjectArgs.builder()
                        .bucket(bucketName)
                        .object(objectName)
                        .build());
    }

    /**
     * 断点下载
     *
     * @param bucketName 存储桶
     * @param objectName 文件名称
     * @param offset     起始字节的位置
     * @param length     要读取的长度
     * @return 二进制流
     */
    @SneakyThrows(Exception.class)
    public InputStream getObject(String bucketName, String objectName, long offset, long length) {
        return minioClient.getObject(
                GetObjectArgs.builder()
                        .bucket(bucketName)
                        .object(objectName)
                        .offset(offset)
                        .length(length)
                        .build());
    }

    /**
     * 获取路径下文件列表
     *
     * @param bucketName 存储桶
     * @param prefix     文件名称
     * @param recursive  是否递归查找，false：模拟文件夹结构查找
     * @return 二进制流
     */
    public Iterable<Result<Item>> listObjects(String bucketName, String prefix, boolean recursive) {
        return minioClient.listObjects(
                ListObjectsArgs.builder()
                        .bucket(bucketName)
                        .prefix(prefix)
                        .recursive(recursive)
                        .build());
    }

    /**
     * 使用MultipartFile进行文件上传
     *
     * @param bucketName  存储桶
     * @param file        文件名
     * @param objectName  对象名
     * @param contentType 类型
     * @return ObjectWriteResponse
     */
    @SneakyThrows(Exception.class)
    public ObjectWriteResponse uploadFile(String bucketName, MultipartFile file, String objectName, String contentType) {
        InputStream inputStream = file.getInputStream();
        return minioClient.putObject(
                PutObjectArgs.builder()
                        .bucket(bucketName)
                        .object(objectName)
                        .contentType(contentType)
                        .stream(inputStream, inputStream.available(), -1)
                        .build());
    }

    /**
     * 图片上传
     * @param bucketName 桶名
     * @param imageBase64 编码
     * @param imageName 图片名称
     * @return 图片地址
     */
    public ObjectWriteResponse uploadImage(String bucketName, String imageBase64, String imageName) {
        if (!StringUtils.hasText(imageBase64)) {
            InputStream in = base64ToInputStream(imageBase64);
            String newName = System.currentTimeMillis() + "_" + imageName + ".jpg";
            String year = String.valueOf(LocalDate.now().getYear());
            String month = String.valueOf(LocalDate.now().getMonth());
            return uploadFile(bucketName, year + "/" + month + "/" + newName, in);

        }
        return null;
    }

    public static InputStream base64ToInputStream(String base64) {
        InputStream stream = null;
        try {
            byte[] bytes = Base64.getDecoder().decode(base64.trim());
            stream = new ByteArrayInputStream(bytes);
        } catch (Exception e) {
            log.error("{}, {}", e, e.getMessage());
        }
        return stream;
    }


    /**
     * 上传本地文件
     *
     * @param bucketName 存储桶
     * @param objectName 对象名称
     * @param fileName   本地文件路径
     * @return ObjectWriteResponse
     */
    @SneakyThrows(Exception.class)
    public ObjectWriteResponse uploadFile(String bucketName, String objectName, String fileName) {
        return minioClient.uploadObject(
                UploadObjectArgs.builder()
                        .bucket(bucketName)
                        .object(objectName)
                        .filename(fileName)
                        .build());
    }

    /**
     * 通过流上传文件
     *
     * @param bucketName  存储桶
     * @param objectName  文件对象
     * @param inputStream 文件流
     * @return ObjectWriteResponse
     */
    @SneakyThrows(Exception.class)
    public ObjectWriteResponse uploadFile(String bucketName, String objectName, InputStream inputStream) {
        return minioClient.putObject(
                PutObjectArgs.builder()
                        .bucket(bucketName)
                        .object(objectName)
                        .stream(inputStream, inputStream.available(), -1)
                        .build());
    }

    /**
     * 创建文件夹或目录
     *
     * @param bucketName 存储桶
     * @param objectName 目录路径
     * @return ObjectWriteResponse
     */
    @SneakyThrows(Exception.class)
    public ObjectWriteResponse createDir(String bucketName, String objectName) {
        return minioClient.putObject(
                PutObjectArgs.builder()
                        .bucket(bucketName)
                        .object(objectName)
                        .stream(new ByteArrayInputStream(new byte[]{}), 0, -1)
                        .build());
    }

    /**
     * 获取文件信息, 如果抛出异常则说明文件不存在
     *
     * @param bucketName 存储桶
     * @param objectName 文件名称
     * @return 文件信息
     */
    @SneakyThrows(Exception.class)
    public String getFileStatusInfo(String bucketName, String objectName) {
        return minioClient.statObject(
                StatObjectArgs.builder()
                        .bucket(bucketName)
                        .object(objectName)
                        .build()).toString();
    }

    /**
     * 拷贝文件
     *
     * @param bucketName    存储桶
     * @param objectName    文件名
     * @param srcBucketName 目标存储桶
     * @param srcObjectName 目标文件名
     */
    @SneakyThrows(Exception.class)
    public ObjectWriteResponse copyFile(String bucketName, String objectName, String srcBucketName, String srcObjectName) {
        return minioClient.copyObject(
                CopyObjectArgs.builder()
                        .source(CopySource.builder().bucket(bucketName).object(objectName).build())
                        .bucket(srcBucketName)
                        .object(srcObjectName)
                        .build());
    }

    /**
     * 删除文件
     *
     * @param bucketName 存储桶
     * @param objectName 文件名称
     */
    @SneakyThrows(Exception.class)
    public void removeFile(String bucketName, String objectName) {
        minioClient.removeObject(
                RemoveObjectArgs.builder()
                        .bucket(bucketName)
                        .object(objectName)
                        .build());
    }

    /**
     * 批量删除文件
     *
     * @param bucketName 存储桶
     * @param keys       需要删除的文件列表
     */
    public void removeFiles(String bucketName, List<String> keys) {
        List<DeleteObject> objects = new LinkedList<>();
        keys.forEach(s -> {
            objects.add(new DeleteObject(s));
            try {
                removeFile(bucketName, s);
            } catch (Exception e) {
                log.error("[Minio工具类]>>>> 批量删除文件，异常：", e);
            }
        });
    }

    /**
     * 获取文件外链
     *
     * @param bucketName 存储桶
     * @param objectName 文件名
     * @param expires    过期时间 <=7 秒 （外链有效时间（单位：秒））
     * @return url
     */
    @SneakyThrows(Exception.class)
    public String getPresignedObjectUrl(String bucketName, String objectName, Integer expires) {
        GetPresignedObjectUrlArgs args = GetPresignedObjectUrlArgs.builder().expiry(expires).bucket(bucketName).object(objectName).build();
        return minioClient.getPresignedObjectUrl(args);
    }

    /**
     * 获得文件外链
     *
     * @param bucketName 桶名
     * @param objectName 文件名
     * @return url
     */
    @SneakyThrows(Exception.class)
    public String getPresignedObjectUrl(String bucketName, String objectName) {
        GetPresignedObjectUrlArgs args = GetPresignedObjectUrlArgs.builder()
                .bucket(bucketName)
                .object(objectName)
                .method(Method.GET).build();
        return minioClient.getPresignedObjectUrl(args);
    }

    /**
     * 将URLDecoder编码转成UTF8
     *
     * @param str 需要解码的字符串，该字符串应为URL编码格式
     * @return 解码后的UTF-8字符串
     */
    public String getUtf8ByURLDecoder(String str) {
        String url = str.replaceAll("%(?![0-9a-fA-F]{2})", "%25");
        return URLDecoder.decode(url, StandardCharsets.UTF_8);
    }

}
