package com.itsqmet.casotres.controller;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.itsqmet.casotres.dto.RegisterForm;
import com.itsqmet.casotres.service.UserService;

@Controller
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registro")
    public String registro(Model model) {
        model.addAttribute("registro", new RegisterForm());
        return "registro";
    }

    @PostMapping("/registro")
    public String registrar(
            @Valid @ModelAttribute("registro") RegisterForm registro,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            return "registro";
        }

        try {
            userService.registrar(
                registro.getNombre(),
                registro.getEmail(),
                registro.getPassword()
            );
        } catch (IllegalArgumentException ex) {
            model.addAttribute("error", ex.getMessage());
            return "registro";
        }

        return "redirect:/login?registrado";
    }
}