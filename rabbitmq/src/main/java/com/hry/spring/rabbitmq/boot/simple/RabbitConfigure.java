package com.hry.spring.rabbitmq.boot.simple;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置RabbitMQ中使用到队列、交换机、绑定等信息
 *
 * Created by huangrongyou@yixin.im on 2018/2/11.
 */
@Configuration
public class RabbitConfigure {

    // 队列名称
    public final static String SPRING_BOOT_QUEUE = "spring-boot-queue";
    // 交换机名称
    public final static String SPRING_BOOT_EXCHANGE = "spring-boot-exchange";
    // 绑定的值
    public static final String SPRING_BOOT_BIND_KEY = "spring-boot-bind-key";


    /**
     * 定义队列
     * @return
     */
    @Bean
    Queue queue() {
        return new Queue(SPRING_BOOT_QUEUE, false);
    }

    /**
     * 定义交换机
     * @return
     */
    @Bean
    TopicExchange exchange() {
        return new TopicExchange(SPRING_BOOT_EXCHANGE);
    }

    /**
     * 定义绑定
     * @param queue
     * @param exchange
     * @return
     */
    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(SPRING_BOOT_BIND_KEY);
    }

//    @Bean
//    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
//                                             MessageListenerAdapter listenerAdapter) {
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory);
//        container.setQueueNames(SFG_MESSAGE_QUEUE);
//        container.setMessageListener(listenerAdapter);
//        return container;
//    }

//    @Bean
//    MessageListenerAdapter listenerAdapter(ProductMessageListener receiver) {
//        return new MessageListenerAdapter(receiver, "receiveMessage");
//    }

}
