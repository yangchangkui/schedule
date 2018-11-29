package com.it.ky.schedule.task;


import com.it.ky.schedule.entity.EmailInfo;
import com.it.ky.schedule.service.EmailService;
import com.it.ky.schedule.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 定时发邮件的任务 发邮件提醒
 * @author: yangchangkui
 * @date: 2018-11-03 16:12
 */
@Component
public class SendEmailTask {

    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Resource
    private JavaMailSender mailSender;

    @Resource
    private EmailService emailService;

    @Resource
    private UserService userService;

    /**
     * 发送方
     */
    @Value("${spring.mail.username}")
    private String fromEmail;


    /**
     * 定时发邮件 每天 16:30 给指定的人发邮件
     */
    @Scheduled(cron = "0 30 16 * * ?")
    public void scheduledSendEmail(){
        try{
            log.info("开始给值日生发邮件......");
            EmailInfo emailInfo = emailService.getEmailInfo();
            if(emailInfo != null){
                List<String> dutyUserEmails = userService.getDutyUserEmails();
                for (String email : dutyUserEmails) {
                    SimpleMailMessage message = new SimpleMailMessage();
                    message.setFrom(fromEmail);
                    //自己给自己发送邮件
                    message.setTo(email);
                    message.setSubject(emailInfo.getEmailTheme());
                    message.setText(emailInfo.getEmailContent());
                    mailSender.send(message);
                    log.info("给"+email+"发送邮件成功！");
                }
            }else{
                log.info("没有邮件内容发送。。。");
            }

        }catch (Exception e){
            log.error("邮件发送失败，原因是：{}",e);
        }
    }
}
