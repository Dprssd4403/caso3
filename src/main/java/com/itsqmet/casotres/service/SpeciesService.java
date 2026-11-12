package com.itsqmet.casotres.service;

import org.springframework.stereotype.Service;

import com.itsqmet.casotres.model.Species;
import com.itsqmet.casotres.repository.SpeciesRepository;

import java.util.List;

@Service
public class SpeciesService {

    private final SpeciesRepository repository;

    public SpeciesService(SpeciesRepository repository) {
        this.repository = repository;
    }

    public List<Species> listar() {
        return repository.findAll();
    }

    public Species buscarPorId(Long id) {
        return repository.findById(id)
            .orElseThrow(() ->
                new IllegalArgumentException("Especie no encontrada"));
    }
}