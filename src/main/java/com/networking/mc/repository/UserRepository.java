package com.networking.mc.repository;

import com.networking.mc.model.UserModel;
import org.springframework.data.repository.CrudRepository;

/**
 * Represents user repository
 */
public interface UserRepository extends CrudRepository<UserModel, Long> {

    UserModel findByUserName(String userName);
    long deleteByUserName(String userName);
}
