package com.raymundo.onlineshop.backend.repository;

import com.raymundo.onlineshop.backend.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends CrudRepository<UserEntity, Long> {

}