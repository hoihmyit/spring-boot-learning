package com.spl.hm.spring_jwt_auth.service;

import java.util.List;
import java.util.Optional;

import com.spl.hm.spring_jwt_auth.dto.AuthRequest;
import com.spl.hm.spring_jwt_auth.entity.Role;
import com.spl.hm.spring_jwt_auth.entity.User;
import com.spl.hm.spring_jwt_auth.entity.enums.RoleEnum;
import com.spl.hm.spring_jwt_auth.repository.RoleRepository;
import com.spl.hm.spring_jwt_auth.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public List<User> allUsers() {
        return userRepository.findAll();
    }

    public User createAdministrator(AuthRequest request) {
        Optional<Role> optionalRole = roleRepository.findByName(RoleEnum.ADMIN);

        if (optionalRole.isEmpty()) {
            return null;
        }

        User adminUser = User.builder()
            .fullName(request.getFullName())
            .email(request.getUsername())
            .password(request.getPassword())
            .role(optionalRole.get())
            .build();

        return userRepository.save(adminUser);
    }
}
