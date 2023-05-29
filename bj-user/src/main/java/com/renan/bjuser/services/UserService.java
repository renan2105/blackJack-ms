package com.renan.bjuser.services;

import com.renan.bjuser.entities.User;
import com.renan.bjuser.repositories.UserRepository;
import com.renan.bjuser.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User saveUser(User user){

        return userRepository.save(user);

    }

    public User findUserById(Long id){

        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }


    public User findUserByName(String name){

        return userRepository.findByName(name);
    }

}
