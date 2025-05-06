package com.spl.hm.spring_jwt_auth.repository;

import java.util.Optional;

import com.spl.hm.spring_jwt_auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
