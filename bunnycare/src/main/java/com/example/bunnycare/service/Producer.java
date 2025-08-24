package com.example.bunnycare.service;

import com.example.bunnycare.configuration.RabbitMQConfiguration;
import com.example.bunnycare.model.BunnyCareInfo;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    private final RabbitTemplate rabbitTemplate;


    public Producer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        this.rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
    }


    public void sendMessage(BunnyCareInfo info) {
        this.rabbitTemplate.convertAndSend(RabbitMQConfiguration.EXCHANGE_NAME, RabbitMQConfiguration.ROUTING_KEY, info);
        System.out.println("Sent Place: " + info.getShelter_name());
    }


}
