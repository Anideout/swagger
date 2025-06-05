package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, String> {

    List<Persona> getNombreContaining();
}
