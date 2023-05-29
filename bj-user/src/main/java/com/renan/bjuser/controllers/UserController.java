package com.renan.bjuser.controllers;

import com.renan.bjuser.entities.User;
import com.renan.bjuser.repositories.UserRepository;
import com.renan.bjuser.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping(value = "/save")
    public ResponseEntity<User> saveUser(@RequestBody User user){

        user = userService.saveUser(user);
        return ResponseEntity.created(URI.create("/users/" + user.getId())).body(user);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id){

        User User = userService.findUserById(id);
        return ResponseEntity.ok(User);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<User> findUserByName(@RequestParam String name){

        User user = userService.findUserByName(name);
        return ResponseEntity.ok(user);
    }

}