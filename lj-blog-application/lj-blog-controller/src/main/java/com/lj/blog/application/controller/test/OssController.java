package com.lj.blog.application.controller.test;

import com.lj.blog.common.conf.MinioConfig;
import com.lj.blog.common.satoken.StpKit;
import com.lj.blog.common.utils.LogUtils;
import com.lj.blog.common.utils.MinioUtils;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.InputStream;

/**
 * @ClassName OssController
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/1/22 21:57
 * @Version JDK 17
 */
@Slf4j
@RestController
@RequestMapping("/oss")
public class OssController {

    @Autowired
    private MinioUtils minioUtils;

    @Autowired
    private MinioConfig minioConfig;

    /**
     * 文件上传
     *
     * @param file
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        try {
            //文件名
            String fileName = file.getOriginalFilename();
            String newFileName = System.currentTimeMillis() + "." + StringUtils.substringAfterLast(fileName, ".");
            //类型
            String contentType = file.getContentType();
            minioUtils.uploadFile(minioConfig.getBucketName(), file, newFileName, contentType);
            return "上传成功";
        } catch (Exception e) {
            log.error("上传失败.{} {}", e, e.getMessage());
            return "上传失败";
        }
    }

    /**
     * 用户上传头像
     */
    @PostMapping("/avatar")
    public String uploadAvatar(@RequestParam("avatar") MultipartFile avatar){
        try {
            //文件名
            String fileName = avatar.getOriginalFilename();
            String newFileName = "user/" + StpKit.USER.getLoginId() + "/avatar/" + System.currentTimeMillis() + "." + StringUtils.substringAfterLast(fileName, ".");
            //类型
            String contentType = avatar.getContentType();
            LogUtils.blue("contentType:" + contentType);
            minioUtils.uploadFile(minioConfig.getBucketName(), avatar, newFileName, contentType);
            return "上传成功";
        } catch (Exception e) {
            log.error("上传失败.{} {}", e, e.getMessage());
            return "上传失败";
        }
    }

    /**
     * 删除
     *
     * @param fileName
     */
    @DeleteMapping("/")
    public void delete(@RequestParam("fileName") String fileName) {
        minioUtils.removeFile(minioConfig.getBucketName(), fileName);
    }

    /**
     * 获取文件信息
     *
     * @param fileName
     * @return
     */
    @GetMapping("/info")
    public String getFileStatusInfo(@RequestParam("fileName") String fileName) {
        return minioUtils.getFileStatusInfo(minioConfig.getBucketName(), fileName);
    }

    /**
     * 获取文件外链
     *
     * @param fileName
     * @return
     */
    @GetMapping("/url")
    public String getPresignedObjectUrl(@RequestParam("fileName") String fileName) {
        return minioUtils.getPresignedObjectUrl(minioConfig.getBucketName(), fileName);
    }

    /**
     * 文件下载
     *
     * @param fileName
     * @param response
     */
    @GetMapping("/download")
    public void download(@RequestParam("fileName") String fileName, HttpServletResponse response) {
        try {
            InputStream fileInputStream = minioUtils.getObject(minioConfig.getBucketName(), fileName);
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.setContentType("application/force-download");
            response.setCharacterEncoding("UTF-8");
            IOUtils.copy(fileInputStream, response.getOutputStream());
        } catch (Exception e) {
            log.error("下载失败");
        }
    }

}
