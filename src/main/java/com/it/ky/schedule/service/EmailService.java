package com.it.ky.schedule.service;

import com.it.ky.schedule.entity.EmailInfo;

/**
 * @author: yangchangkui
 * @date: 2018-11-03 17:21
 */
public interface EmailService {
    EmailInfo getEmailInfo();

    /**
     * 发送简单邮件
     * @param to
     * @param subject
     * @param content
     */
    public void sendSimpleEmail(String to, String subject, String content);
    /**
     * 发送html格式邮件
     * @param to
     * @param subject
     * @param content
     */
    public void sendHtmlEmail(String to, String subject, String content);
    /**
     * 发送带附件的邮件
     * @param to
     * @param subject
     * @param content
     * @param filePath
     */
    public void sendAttachmentsEmail(String to, String subject, String content, String filePath);
    /**
     * 发送带静态资源的邮件
     * @param to
     * @param subject
     * @param content
     * @param rscPath
     * @param rscId
     */
    public void sendInlineResourceEmail(String to, String subject, String content, String rscPath, String rscId);
}
