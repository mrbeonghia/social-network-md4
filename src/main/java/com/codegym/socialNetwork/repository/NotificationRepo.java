package com.codegym.socialNetwork.repository;

import com.codegym.socialNetwork.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepo extends JpaRepository<Notification, Long> {
}
