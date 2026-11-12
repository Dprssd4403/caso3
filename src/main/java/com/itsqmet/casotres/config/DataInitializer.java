package com.itsqmet.casotres.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.itsqmet.casotres.model.Species;
import com.itsqmet.casotres.repository.SpeciesRepository;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner cargarEspecies(SpeciesRepository repository) {

        return args -> {

            if (repository.findByNombre("Canino").isEmpty()) {
                repository.save(
                    new Species("Canino", "Perros")
                );
            }

            if (repository.findByNombre("Felino").isEmpty()) {
                repository.save(
                    new Species("Felino", "Gatos")
                );
            }

            if (repository.findByNombre("Ave").isEmpty()) {
                repository.save(
                    new Species("Ave", "Aves domésticas")
                );
            }

            if (repository.findByNombre("Roedor").isEmpty()) {
                repository.save(
                    new Species("Roedor", "Roedores domésticos")
                );
            }
        };
    }
}