package com.sharpEdge.notification.dao;

import com.sharpEdge.notification.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationDao extends JpaRepository<Notification, Long> {
    public List<Notification> findNotificationBySender(String sender);
    public List<Notification> findNotificationByReceiver(String reciever);
}
