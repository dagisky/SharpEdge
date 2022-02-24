package com.sharpEdge.clients.notification;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationResponse {
    private long id;
    private String message;
    private String sender;
    private String receiver;
    private long sentDate;
}
