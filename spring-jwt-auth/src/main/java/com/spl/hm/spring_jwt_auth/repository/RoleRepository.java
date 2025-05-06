package com.spl.hm.spring_jwt_auth.repository;

import java.util.Optional;

import com.spl.hm.spring_jwt_auth.entity.Role;
import com.spl.hm.spring_jwt_auth.entity.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(RoleEnum name);
}
