package com.sharpEdge.notification.service;

import com.sharpEdge.notification.dao.NotificationDao;
import com.sharpEdge.notification.dto.NotificationRequest;
import com.sharpEdge.notification.dto.NotificationResponse;
import com.sharpEdge.notification.model.Notification;
import com.sharpEdge.notification.util.ListMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {
    private final NotificationDao notificationDao;
    private final ModelMapper modelMapper;
    private final ListMapper<Notification, NotificationResponse> notificationToResponseListMapper;

    @Autowired
    public NotificationService(NotificationDao notificationDao, ModelMapper modelMapper, ListMapper<Notification, NotificationResponse> notificationToResponseListMapper) {
        this.modelMapper = modelMapper;
        this.notificationDao = notificationDao;
        this.notificationToResponseListMapper = notificationToResponseListMapper;
    }

    public NotificationResponse getNotification(long id){
        return modelMapper.map(notificationDao.getById(id), NotificationResponse.class);
    }

    public List<NotificationResponse> getSenderNotifications(String sender_username){
        return (List<NotificationResponse>) notificationToResponseListMapper.map(notificationDao.findNotificationBySender(sender_username), new NotificationResponse());
    }

    public List<NotificationResponse> getRecieverNotifications(String reciever_username){
        return (List<NotificationResponse>) notificationToResponseListMapper.map(notificationDao.findNotificationByReceiver(reciever_username), new NotificationResponse());
    }

    public NotificationResponse createNotification(NotificationRequest notificationRequest){
        Notification response = notificationDao.save(modelMapper.map(notificationRequest, Notification.class));
        return modelMapper.map(response, NotificationResponse.class);
    }
}
