package com.sharpEdge.clients.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("NOTIFICATIONSERVICE:8083")
public interface NotificationClient {
    @PostMapping("/api/v1/notification")
    public NotificationResponse createNotification(@RequestBody NotificationRequest notificationRequest);
}
