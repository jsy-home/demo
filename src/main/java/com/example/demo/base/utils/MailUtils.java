package com.example.demo.base.utils;

import com.example.demo.excepion.DGExcepion;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * 发送验证码到邮件
 */
@Component
public class MailUtils {

    @Autowired
    JavaMailSender javaMailSenderImpl;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public  void sendMimeMail(String destMailAddress) {
        MimeMessage mimeMessage = javaMailSenderImpl.createMimeMessage();
        try {
            // 开启文件上传
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            String key = CaptchaGenerator.randamGenerator();
            // 将验证码加入到缓存中
            redisTemplate.opsForValue().set("emailKey::"+destMailAddress,key);
            // 设置过期时间
            redisTemplate.expire("emailKey::"+destMailAddress,3, TimeUnit.MINUTES);
            // 设置文件主题
            mimeMessageHelper.setSubject("账号激活");
            // 设置文件内容 第二个参数设置是否支持html
            mimeMessageHelper.setText("<b style='color:red'>验证码</b>"+key, true);
            // 设置发送到的邮箱
            mimeMessageHelper.setTo(destMailAddress);
            // 设置发送人和配置文件中邮箱一致
            mimeMessageHelper.setFrom("2837779203@qq.com");
            // 上传附件
            // mimeMessageHelper.addAttachment("", new File(""));
        } catch (MessagingException e) {
            throw new DGExcepion(e.getMessage(),10002);
        }
        javaMailSenderImpl.send(mimeMessage);
    }
}
