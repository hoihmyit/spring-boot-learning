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
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final RoleRepository roleRepository;

    public User signup(AuthRequest request) {
        RoleEnum roleEnum = RoleEnum.USER;

        if (request.getRole().name() != null) {
            roleEnum = request.getRole();
        }

        Optional<Role> optionalRole = roleRepository.findByName(roleEnum);

        if (optionalRole.isEmpty()) {
            return null;
        }

        User user = User.builder()
            .fullName(request.getFullName())
            .email(request.getUsername())
            .password(passwordEncoder.encode(request.getPassword()))
            .role(optionalRole.get())
            .build();

        return userRepository.save(user);
    }

    public User authenticate(AuthRequest request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
            )
        );

        return userRepository.findByEmail(request.getUsername()).orElseThrow();
    }

    public List<User> allUsers() {
        return userRepository.findAll();
    }
}
