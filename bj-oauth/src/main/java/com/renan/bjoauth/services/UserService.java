package com.renan.bjoauth.services;

import com.renan.bjoauth.entities.User;
import com.renan.bjoauth.feignclients.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserFeignClient userFeignClient;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userFeignClient.findUserByName(username).getBody();
        if(user == null){
            throw new UsernameNotFoundException("Name not found");
        }

        return user;
    }
}
