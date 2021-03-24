package com.codegym.socialNetwork.service.notification;

import com.codegym.socialNetwork.model.Notification;
import com.codegym.socialNetwork.repository.NotificationRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class NotificationService implements INotificationService {

    @Autowired
    private NotificationRepo notificationRepo;

    @Override
    public Iterable<Notification> findAll() {
        return notificationRepo.findAll();
    }

    @Override
    public Optional<Notification> findById(Long id) {
        return notificationRepo.findById(id);
    }

    @Override
    public void save(Notification notification) {
        notificationRepo.save(notification);
    }

    @Override
    public void remove(Long id) {
        notificationRepo.deleteById(id);
    }
}
