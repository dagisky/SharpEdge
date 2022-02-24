package com.sharpEdge.UserService.service;

import com.sharpEdge.UserService.dao.CustomerDao;
import com.sharpEdge.UserService.dto.CustomerRequest;
import com.sharpEdge.UserService.dto.CustomerResponse;
import com.sharpEdge.UserService.model.Customer;
import com.sharpEdge.amqp.RabbitMQMessageProducer;
import com.sharpEdge.clients.notification.NotificationClient;
import com.sharpEdge.clients.notification.NotificationRequest;
import com.sharpEdge.clients.notification.NotificationResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerService {
    private final ModelMapper modelMapper;
    private final CustomerDao customerDao;
    private final NotificationClient notificationClient;
    private final RabbitMQMessageProducer rabbitMQMessageProducer;


    @Autowired
    public CustomerService(ModelMapper modelMapper, CustomerDao customerDao, NotificationClient notificationClient, RabbitMQMessageProducer rabbitMQMessageProducer){
        this.modelMapper = modelMapper;
        this.customerDao = customerDao;
        this.notificationClient = notificationClient;
        this.rabbitMQMessageProducer = rabbitMQMessageProducer;
    }


    public CustomerResponse getUserByUsername(String username){
        return modelMapper.map(customerDao.findByUsername(username), CustomerResponse.class);
    }

    public CustomerResponse save(CustomerRequest customerRequest){
        Customer customer = customerDao.save(modelMapper.map(customerRequest, Customer.class));
        return modelMapper.map(customer, CustomerResponse.class);
    }

    public void sendNotification(NotificationRequest notificationRequest){
        rabbitMQMessageProducer.publish(notificationRequest, "internal.exchange", "internal.notification.routing-key");
//        return notificationClient.createNotification(notificationRequest);
    }

}
