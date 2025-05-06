package com.spl.hm.spring_jwt_auth.bootstrap;

import java.util.Optional;

import com.spl.hm.spring_jwt_auth.dto.AuthRequest;
import com.spl.hm.spring_jwt_auth.entity.Role;
import com.spl.hm.spring_jwt_auth.entity.User;
import com.spl.hm.spring_jwt_auth.entity.enums.RoleEnum;
import com.spl.hm.spring_jwt_auth.repository.RoleRepository;
import com.spl.hm.spring_jwt_auth.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AdminSeeder implements ApplicationListener<ContextRefreshedEvent> {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        this.createSuperAdministrator();
    }

    private void createSuperAdministrator() {
        AuthRequest request = AuthRequest.builder()
            .fullName("Super Admin")
            .username("super.admin@email.com")
            .password("superAdmin@123")
            .build();

        Optional<Role> optionalRole = roleRepository.findByName(RoleEnum.SUPER_ADMIN);
        Optional<User> optionalUser = userRepository.findByEmail(request.getUsername());

        if (optionalRole.isEmpty() || optionalUser.isPresent()) {
            return;
        }

        User superAdminUser = User.builder()
            .fullName(request.getFullName())
            .email(request.getUsername())
            .password(passwordEncoder.encode(request.getPassword()))
            .role(optionalRole.get())
            .build();

        userRepository.save(superAdminUser);
    }
}
