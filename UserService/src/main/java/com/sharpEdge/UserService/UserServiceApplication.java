package com.sharpEdge.UserService;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(
        scanBasePackages = {
                "com.sharpEdge.UserService",
                "com.sharpEdge.amqp"
        }
)
@EnableFeignClients(
        basePackages = "com.sharpEdge.clients"
)
public class UserServiceApplication {
    public static void main(String[] args){
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
