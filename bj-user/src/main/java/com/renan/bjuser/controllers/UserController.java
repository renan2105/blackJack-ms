package com.renan.bjuser.controllers;

import com.renan.bjuser.entities.User;
import com.renan.bjuser.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id){

        User User = userRepository.findById(id).get();
        return ResponseEntity.ok(User);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<User> findUserByEmail(@RequestParam String email){

        User user = userRepository.findByEmail(email);
        return ResponseEntity.ok(user);
    }

}