package com.hanyouli.mq;

import com.hanyouli.entity.Mybuy;
import com.hanyouli.mail.MailBean;
import com.hanyouli.mail.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Consumer {
    @Resource
    MailService mailService;

    Logger logger = LoggerFactory.getLogger(Consumer.class);

    @RabbitListener(queues =  "testA")
    public void sendEmail(String string){

        MailBean mailBean = new MailBean();
        mailBean.setContent("尊敬的客户你好,你购买的" + string + "，已经付款成功，谢谢您对我们商城的支持！");
        mailBean.setReceiver("2938135485@qq.com");
        mailBean.setSubject("购买成功提醒！");
        try {
            mailService.sendSimpleMail(mailBean);
            logger.info("消费者发送邮件");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
