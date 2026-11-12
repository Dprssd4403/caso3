package com.itsqmet.casotres.service;

import org.springframework.stereotype.Service;

import com.itsqmet.casotres.model.Pet;
import com.itsqmet.casotres.repository.PetRepository;

import java.util.List;

@Service
public class PetService {

    private final PetRepository repository;

    public PetService(PetRepository repository) {
        this.repository = repository;
    }

    public List<Pet> listar() {
        return repository.findAll();
    }

    public Pet buscarPorId(Long id) {
        return repository.findById(id)
            .orElseThrow(() ->
                new IllegalArgumentException("Mascota no encontrada"));
    }

    public Pet guardar(Pet mascota) {
        return repository.save(mascota);
    }

    public void eliminar(Long id) {
        Pet mascota = buscarPorId(id);
        repository.delete(mascota);
    }
}