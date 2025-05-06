package com.spl.hm.spring_jwt_auth.bootstrap;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

import com.spl.hm.spring_jwt_auth.entity.Role;
import com.spl.hm.spring_jwt_auth.entity.enums.RoleEnum;
import com.spl.hm.spring_jwt_auth.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RoleSeeder implements ApplicationListener<ContextRefreshedEvent> {

    private final RoleRepository roleRepository;


    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        this.loadRoles();
    }

    private void loadRoles() {
        RoleEnum[] roleNames = new RoleEnum[] { RoleEnum.USER, RoleEnum.ADMIN, RoleEnum.SUPER_ADMIN };
        Map<RoleEnum, String> roleDescriptionMap = Map.of(
            RoleEnum.USER, "Default user role",
            RoleEnum.ADMIN, "Administrator role",
            RoleEnum.SUPER_ADMIN, "Super Administrator role"
        );

        Arrays.stream(roleNames).forEach((roleName) -> {
            Optional<Role> optionalRole = roleRepository.findByName(roleName);

            optionalRole.ifPresentOrElse(System.out::println, () -> {
                Role roleToCreate = Role.builder()
                    .name(roleName)
                    .description(roleDescriptionMap.get(roleName))
                    .build();
                roleRepository.save(roleToCreate);
            });
        });
    }
}
