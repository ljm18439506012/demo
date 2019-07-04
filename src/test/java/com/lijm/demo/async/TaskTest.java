package com.lijm.demo.async;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@Slf4j
public class TaskTest {

    @Autowired
    private Task task;

    // 邮箱相关
    @Autowired
    private JavaMailSender mailSender;

    @Test
    public void test() throws Exception {
        long start = System.currentTimeMillis();

        Future<String> one = task.doTaskOne();
        Future<String> two = task.doTaskTwo();
        Future<String> three = task.doTaskThree();

        while (true) {
            if(one.isDone() && two.isDone() && three.isDone()) {
                break;
            }
            Thread.sleep(1000);
        }
        long end = System.currentTimeMillis();
        System.out.println("总耗时" + (end - start) + "毫秒");
    }

    @Test
    public void testX() throws Exception {
        Future<String> futureResult = task.run();
        String result = futureResult.get(5, TimeUnit.SECONDS);
        log.info(result);
    }

    @Test
    public void mail() throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();
        // 发件人
        message.setFrom("m18439506012@163.com");
        // 收件人
        message.setTo("1342585981@qq.com");
        // 邮件主题
        message.setSubject("主题：简单的邮件");
        // 邮件内容
        message.setText("测试邮件内容");
        // 发送邮件
        mailSender.send(message);
    }

    /**
     * 携带附件发送邮件
     * @throws Exception
     */
    @Test
    public void sendAttachentsMail() throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("m18439506012@163.com");
        helper.setTo("1342585981@qq.com");
        helper.setSubject("这个邮件不简单");
        helper.setText("这个邮件带有附件（文件、图片）");

        FileSystemResource file = new FileSystemResource(new File("C:\\Users\\Administrator\\Desktop\\Friend.jpg"));
        helper.addAttachment("附件一.jpg", file);
        helper.addAttachment("附件二.jpg", file);

        mailSender.send(mimeMessage);

    }


    public void sendInlineMail() throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("1342585981@qq.com");
        helper.setTo("m18439506012@136.com");
        helper.setSubject("这个邮件不简单");
        helper.setText("<html><body><img src=\"cid:Friend\" ></body></html>", true);

        FileSystemResource resource = new FileSystemResource(new File("C:\\Users\\Administrator\\Desktop\\Friend.jpg"));
        helper.addInline("Friend", resource);

        mailSender.send(mimeMessage);
    }
}