package com.spl.hm.spring_jwt_auth.service;

import java.util.List;

import com.spl.hm.spring_jwt_auth.entity.User;
import com.spl.hm.spring_jwt_auth.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> allUsers() {
        return userRepository.findAll();
    }
}
