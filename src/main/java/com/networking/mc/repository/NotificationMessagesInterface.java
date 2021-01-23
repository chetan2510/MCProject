package com.networking.mc.repository;

import com.networking.mc.model.NotificationMessages;
import org.springframework.data.repository.CrudRepository;

public interface NotificationMessagesInterface extends CrudRepository<NotificationMessages, Long> {
}
