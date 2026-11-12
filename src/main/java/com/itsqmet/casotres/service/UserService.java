package com.itsqmet.casotres.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.itsqmet.casotres.model.User;
import com.itsqmet.casotres.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserService(
            UserRepository repository,
            PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registrar(String nombre, String email, String password) {

        email = email.trim().toLowerCase();

        if (repository.existsByEmail(email)) {
            throw new IllegalArgumentException(
                "El correo electrónico ya está registrado"
            );
        }

        User usuario = new User();
        usuario.setNombre(nombre.trim());
        usuario.setEmail(email);
        usuario.setPassword(passwordEncoder.encode(password));

        repository.save(usuario);
    }
}