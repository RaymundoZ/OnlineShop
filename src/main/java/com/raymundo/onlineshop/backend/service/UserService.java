package com.raymundo.onlineshop.backend.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raymundo.onlineshop.backend.dto.User;
import com.raymundo.onlineshop.backend.entity.UserEntity;
import com.raymundo.onlineshop.backend.exception.UserNotFoundException;
import com.raymundo.onlineshop.backend.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    public User getUserById(Long id) throws UserNotFoundException {
        return UserEntity.toDto(getUserEntityById(id));
    }

    public User createUser(UserEntity userEntity) {
        return UserEntity.toDto(userRepository.save(userEntity));
    }

    public User deleteUser(Long id) throws UserNotFoundException {
        UserEntity userEntity = getUserEntityById(id);
        userRepository.delete(userEntity);
        return UserEntity.toDto(userEntity);
    }

    public User updateUser(UserEntity userEntity) {
        return createUser(userEntity);
    }
    
    private UserEntity getUserEntityById(Long id) throws UserNotFoundException {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
    }

}
