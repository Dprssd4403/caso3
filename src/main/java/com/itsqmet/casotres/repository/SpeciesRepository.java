package com.itsqmet.casotres.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itsqmet.casotres.model.Species;

import java.util.Optional;

public interface SpeciesRepository extends JpaRepository<Species, Long> {

    Optional<Species> findByNombre(String nombre);
}