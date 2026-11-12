package com.itsqmet.casotres.dto;

import jakarta.validation.constraints.*;

public class RegisterForm {

    @NotBlank(message = "Ingrese su nombre")
    private String nombre;

    @NotBlank(message = "Ingrese su correo")
    @Email(message = "Ingrese un correo válido")
    private String email;

    @NotBlank(message = "Ingrese su contraseña")
    @Size(min = 8, message = "Mínimo 8 caracteres")
    private String password;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}