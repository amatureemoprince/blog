package com.lj.blog.infra.main;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @ClassName FileMain
 * @Description
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2024/12/24 10:09
 * @Version JDK 17
 */
public class FileMain {
    public static void main(String[] args) throws IOException {
        File file = new File("G:\\NotesOfAll\\github仓库（考研心得）\\-408\\数据结构\\基础数据结构代码实现\\队列.md");
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getCanonicalFile());
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.length());
        System.out.println(file.isDirectory());
        System.out.println(file.canExecute());
        System.out.println(file.isHidden());
        //获取当前根目录
        String currentDir = System.getProperty("user.dir");
        System.out.println("当前根目录：" + currentDir);
        try (// 最基础的字节流，直接从文件读取原始字节
             FileInputStream fis = new FileInputStream(file);
             // 将字节流转换为字符流，处理字符编码
             Reader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
             // 添加缓冲功能，提供按行读取的能力
             BufferedReader reader = new BufferedReader(isr);
             Reader reader1 = new FileReader(file)) {
            // 这里可以添加对文件的操作逻辑
//            for (; ; ) {
//                int read = fileInputStream.read();
//                if (read == -1) {
//                    break;
//                }
//                //这里可以验证输出的就是对应字符的ascii编码
//                System.out.print((char) read);
//            }
            while (true){
                String string = reader.readLine();
                if (string == null) {
                    break;
                }
                System.out.println(string);
            }
            System.out.println("文件的分隔符："+File.separator);
        } catch (IOException e) {
            throw new IOException(e.getCause());
        }

    }
}
