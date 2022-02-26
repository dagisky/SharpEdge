package com.sharpEdge.notification;

import com.sharpEdge.amqp.RabbitMQMessageProducer;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(
        scanBasePackages = {
                "com.sharpEdge.notification",
                "com.sharpEdge.amqp"
        }
)
public class NotificationApp {
    public static void main(String[] args){
        SpringApplication.run(NotificationApp.class, args);
    }
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

//    @Bean
//    CommandLineRunner commandLineRunner(RabbitMQMessageProducer producer, NotificationConfig notificationConfig){
//        return args -> {
//            producer.publish("foo", notificationConfig.getInternalExchange(), notificationConfig.getInternalNotificationRoutingKey());
//        };
//    }
}


