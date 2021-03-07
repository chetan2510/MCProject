package com.networking.mc.repository;

import com.networking.mc.model.RescueModel;
import org.springframework.data.repository.CrudRepository;

/**
 * Represents rescuer repository
 */
public interface RescuerRepository extends CrudRepository<RescueModel, Long> {

    RescueModel findByRescuerName(String rescuerName);
    long deleteByRescuerName(String rescuerName);
}
