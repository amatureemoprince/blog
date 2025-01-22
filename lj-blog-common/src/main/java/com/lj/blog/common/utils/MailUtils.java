package com.lj.blog.common.utils;

import com.lj.blog.common.enums.EmailEnum;
import com.lj.blog.common.exception.exceptions.BusinessException;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.UnsupportedEncodingException;

/**
 * @ClassName MailUtils
 * @Description 发邮箱工具类
 * @Author Dark Chocolate 2069057986@qq.com
 * @Date 2025/1/19 9:34
 * @Version JDK 17
 */
@Slf4j
@Service
public class MailUtils {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private RedisUtils redisUtils;

    @Value("${spring.mail.username}")
    private String from;
    /**
     * @Description 验证发送邮箱的验证码和前端传入的验证码是否一致
     * */
    public boolean checkCaptcha(String email, String captcha) {
        String captchaCode = (String) redisUtils.get(email);
        return captchaCode != null && captchaCode.equals(captcha);
    }


    public void sendBlogReminder(String to){
        // 创建消息
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            // 设置主题、发件人、内容
            mimeMessage.setSubject("朝花夕拾");
            mimeMessage.setFrom(new InternetAddress(from, "朝花夕拾", "UTF-8"));
            mimeMessage.setText("祝你拥有一个美好的一天！");

            // 设置收件人
            mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            // 发送邮件
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            log.error("发送邮箱失败, 收件人: {}, 错误信息: {}", to, e.getMessage(), e);
            throw new BusinessException("发送邮箱失败");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 简单文本邮件
     *
     * @param to      收件人
     * @param subject 主题
     * @param content 内容
     */
    public void sendSimpleMail(String to, String subject, String content) throws UnsupportedEncodingException {
        //创建SimpleMailMessage对象
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件发送人
        message.setFrom(String.valueOf(new InternetAddress(from, EmailEnum.EMAIL_HEAD.getMsg(), "UTF-8")));
        //邮件接收人
        message.setTo(to);
        //邮件主题
        message.setSubject(subject);
        //邮件内容
        message.setText(content);
        //发送邮件
        mailSender.send(message);
    }

    /**
     * html邮件
     *
     * @param to      收件人,多个时参数形式 ："xxx@xxx.com,xxx@xxx.com,xxx@xxx.com"
     * @param subject 主题
     * @param content 内容
     */
    public void sendHtmlMail(String to, String subject, String content) {
        //获取MimeMessage对象
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper;
        try {
            messageHelper = new MimeMessageHelper(message, true);
            //邮件发送人
            messageHelper.setFrom(from);
            //邮件接收人,设置多个收件人地址
            InternetAddress[] internetAddressTo = InternetAddress.parse(to);
            messageHelper.setTo(internetAddressTo);
            //messageHelper.setTo(to);
            //邮件主题
            message.setSubject(subject);
            //邮件内容，html格式
            messageHelper.setText(content, true);
            //发送
            mailSender.send(message);
            //日志信息
            log.info("邮件已经发送。");
        } catch (Exception e) {
            log.error("发送邮件时发生异常！", e);
        }
    }

    /**
     * 带附件的邮件
     *
     * @param to       收件人
     * @param subject  主题
     * @param content  内容
     * @param filePath 附件
     */
    public void sendAttachmentsMail(String to, String subject, String content, String filePath) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);
            FileSystemResource file = new FileSystemResource(new File(filePath));
            String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
            helper.addAttachment(fileName, file);
            mailSender.send(message);
            log.info("邮件已经发送。");
        } catch (Exception e) {
            log.error("发送邮件时发生异常！", e);
        }

    }
}
