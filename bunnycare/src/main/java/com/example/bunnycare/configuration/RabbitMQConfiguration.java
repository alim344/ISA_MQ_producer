package com.example.bunnycare.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.amqp.core.Queue;

@Configuration
public class RabbitMQConfiguration {

    public static final String EXCHANGE_NAME = "unnycare_exchange";
    public static final String ROUTING_KEY = "unnycare_key";
    public static final String QUEUE_NAME = "unnycare";

    @Bean
    public Queue queue(){
           return new Queue(QUEUE_NAME, false);
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding binding(Queue queue, DirectExchange directExchange){
        return BindingBuilder.bind(queue).to(directExchange).with(ROUTING_KEY);
    }


}
