package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Persona;
import com.example.demo.repository.PersonaRepository;

@Service
public class PersonaService {
    @Autowired
    private PersonaRepository personaRepository;

    public String almacenar(Persona persona) {
       this.personaRepository.save(persona);
       return "persona almacenada ok";
    }

    public List<Persona> listar() {
        return this.personaRepository.findAll();
    }

    public List<Persona> buscar() {
        return this.personaRepository.getNombreContaining();
    }
    
    public String eliminar(Persona persona) {
         this.personaRepository.delete(persona);
         return "eliminado!";
    }
}
