package com.itsqmet.casotres.controller;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.itsqmet.casotres.model.Pet;
import com.itsqmet.casotres.service.PetService;
import com.itsqmet.casotres.service.SpeciesService;

@Controller
@RequestMapping("/mascotas")
public class PetController {

    private final PetService petService;
    private final SpeciesService speciesService;

    public PetController(
            PetService petService,
            SpeciesService speciesService) {

        this.petService = petService;
        this.speciesService = speciesService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("mascotas", petService.listar());
        return "mascotas/lista";
    }

    @GetMapping("/nueva")
    public String nueva(Model model) {
        model.addAttribute("mascota", new Pet());
        model.addAttribute("especies", speciesService.listar());
        return "mascotas/formulario";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("mascota", petService.buscarPorId(id));
        model.addAttribute("especies", speciesService.listar());
        return "mascotas/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(
            @Valid @ModelAttribute("mascota") Pet mascota,
            BindingResult result,
            Model model) {

        if (mascota.getEspecie() != null &&
            mascota.getEspecie().getId() != null) {

            try {
                mascota.setEspecie(
                    speciesService.buscarPorId(
                        mascota.getEspecie().getId()
                    )
                );
            } catch (IllegalArgumentException ex) {
                result.rejectValue(
                    "especie",
                    "invalid",
                    "Seleccione una especie válida"
                );
            }
        }

        if (result.hasErrors()) {
            model.addAttribute("especies", speciesService.listar());
            return "mascotas/formulario";
        }

        if (mascota.getId() != null) {
            petService.buscarPorId(mascota.getId());
        }

        petService.guardar(mascota);
        return "redirect:/mascotas";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        petService.eliminar(id);
        return "redirect:/mascotas";
    }
}