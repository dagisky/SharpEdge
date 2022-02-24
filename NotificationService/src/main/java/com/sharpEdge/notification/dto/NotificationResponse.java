package com.sharpEdge.notification.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationResponse {
    private long id;
    private String message;
    private String sender;
    private String receiver;
    private long sentDate;
}
