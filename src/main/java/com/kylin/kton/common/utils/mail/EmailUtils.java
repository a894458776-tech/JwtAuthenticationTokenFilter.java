/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.mail.MessagingException
 *  javax.mail.internet.MimeMessage
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.beans.factory.annotation.Value
 *  org.springframework.mail.MailException
 *  org.springframework.mail.SimpleMailMessage
 *  org.springframework.mail.javamail.JavaMailSender
 *  org.springframework.mail.javamail.MimeMessageHelper
 *  org.springframework.stereotype.Component
 */
package com.kylin.kton.common.utils.mail;

import java.io.File;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtils {
    private static final Logger log = LoggerFactory.getLogger(EmailUtils.class);
    @Autowired
    private JavaMailSender mailSender;
    @Value(value="${mail.username}")
    private String from;

    public boolean sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(this.from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        try {
            this.mailSender.send(message);
            log.info("\u7b80\u5355\u90ae\u4ef6\u53d1\u9001\u6210\u529f\uff0c\u6536\u4ef6\u4eba\uff1a{}", (Object)to);
            return true;
        }
        catch (MailException e) {
            log.error("\u53d1\u9001\u7b80\u5355\u90ae\u4ef6\u65f6\u53d1\u751f\u5f02\u5e38\uff01", (Throwable)e);
            return false;
        }
    }

    public boolean sendHtmlMail(String to, String subject, String content) {
        MimeMessage message = this.mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(this.from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);
            this.mailSender.send(message);
            log.info("HTML\u90ae\u4ef6\u53d1\u9001\u6210\u529f\uff0c\u6536\u4ef6\u4eba\uff1a{}", (Object)to);
            return true;
        }
        catch (MessagingException e) {
            log.error("\u53d1\u9001HTML\u90ae\u4ef6\u65f6\u53d1\u751f\u5f02\u5e38\uff01", (Throwable)e);
            return false;
        }
    }

    public boolean sendAttachmentsMail(String to, String subject, String content, String filePath) {
        MimeMessage message = this.mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(this.from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);
            File file = new File(filePath);
            if (!file.exists()) {
                log.error("\u9644\u4ef6\u4e0d\u5b58\u5728\uff0c\u8def\u5f84\uff1a{}", (Object)filePath);
                return false;
            }
            String fileName = file.getName();
            helper.addAttachment(fileName, file);
            this.mailSender.send(message);
            log.info("\u5e26\u9644\u4ef6\u7684\u90ae\u4ef6\u53d1\u9001\u6210\u529f\uff0c\u6536\u4ef6\u4eba\uff1a{}\uff0c\u9644\u4ef6\uff1a{}", (Object)to, (Object)filePath);
            return true;
        }
        catch (MessagingException e) {
            log.error("\u53d1\u9001\u5e26\u9644\u4ef6\u7684\u90ae\u4ef6\u65f6\u53d1\u751f\u5f02\u5e38\uff01", (Throwable)e);
            return false;
        }
    }

    public boolean sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId) {
        MimeMessage message = this.mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(this.from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);
            File file = new File(rscPath);
            if (!file.exists()) {
                log.error("\u9759\u6001\u8d44\u6e90\u4e0d\u5b58\u5728\uff0c\u8def\u5f84\uff1a{}", (Object)rscPath);
                return false;
            }
            helper.addInline(rscId, file);
            this.mailSender.send(message);
            log.info("\u5e26\u9759\u6001\u8d44\u6e90\u7684\u90ae\u4ef6\u53d1\u9001\u6210\u529f\uff0c\u6536\u4ef6\u4eba\uff1a{}\uff0c\u8d44\u6e90\uff1a{}", (Object)to, (Object)rscPath);
            return true;
        }
        catch (MessagingException e) {
            log.error("\u53d1\u9001\u5e26\u9759\u6001\u8d44\u6e90\u7684\u90ae\u4ef6\u65f6\u53d1\u751f\u5f02\u5e38\uff01", (Throwable)e);
            return false;
        }
    }
}

