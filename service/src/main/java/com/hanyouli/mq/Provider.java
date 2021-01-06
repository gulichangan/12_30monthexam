package com.hanyouli.mq;

import com.hanyouli.entity.Mybuy;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Provider {

    @Resource
    private AmqpTemplate amqpTemplate;

    public void send(String string){
        amqpTemplate.convertAndSend("MonthTest","A",string);

    }
}
