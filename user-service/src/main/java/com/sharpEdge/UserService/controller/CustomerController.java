package com.sharpEdge.UserService.controller;

import com.sharpEdge.UserService.dto.CustomerRequest;
import com.sharpEdge.UserService.dto.CustomerResponse;
import com.sharpEdge.UserService.service.CustomerService;
import com.sharpEdge.clients.notification.NotificationRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Slf4j
@RestController
@RequestMapping("/api/v1/user")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @PostMapping
    public RedirectView registerUser(@RequestBody CustomerRequest customerRequest){
        log.info("new user registration {} ", customerRequest);
        CustomerResponse response =  customerService.save(customerRequest);
        return new RedirectView("/api/v1/user/"+response.getUsername());
    }

    @GetMapping("/{username}")
    public ResponseEntity<CustomerResponse> getUser(@PathVariable("username") String username){
        return new ResponseEntity<CustomerResponse>(customerService.getUserByUsername(username), HttpStatus.OK) ;
    }

    @PostMapping("/notification")
    public RedirectView sendNotification(@RequestBody NotificationRequest notificationRequest){
        customerService.sendNotification(notificationRequest);
        return new RedirectView("/api/v1/user/"+notificationRequest.getSender());
    }

}
