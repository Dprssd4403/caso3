package com.itsqmet.casotres.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itsqmet.casotres.model.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {
}