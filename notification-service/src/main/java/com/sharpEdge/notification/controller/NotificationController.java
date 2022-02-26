package com.sharpEdge.notification.controller;

import com.sharpEdge.notification.dto.NotificationRequest;
import com.sharpEdge.notification.dto.NotificationResponse;
import com.sharpEdge.notification.model.Notification;
import com.sharpEdge.notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/api/v1/notification")
public class NotificationController {
    private final NotificationService notificationService;
    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }
    @GetMapping("{id}")
    public NotificationResponse getNotification(@PathVariable("id") long id){
        return notificationService.getNotification(id);
    }

    @PostMapping
    public NotificationResponse createNotification(@RequestBody NotificationRequest notificationRequest){
        return notificationService.createNotification(notificationRequest);
    }
}
