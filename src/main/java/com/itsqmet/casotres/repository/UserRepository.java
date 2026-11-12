package com.itsqmet.casotres.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itsqmet.casotres.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}