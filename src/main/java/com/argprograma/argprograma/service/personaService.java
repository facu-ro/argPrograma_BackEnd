
package com.argprograma.argprograma.service;

import com.argprograma.argprograma.model.Persona;
import com.argprograma.argprograma.repository.IpersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class personaService  {
    
    @Autowired
    public IpersonaRepository personaRepo;
    
    public List<Persona> verPersonas(){
        
        return personaRepo.findAll();
    }
    
    public void crearPersona(Persona pers){
        
        personaRepo.save(pers);
    }
    
    
    public void borrarPersona(int id){
    
        personaRepo.deleteById(id);
    }
    
    
    public Persona buscarPersona(int id){
    
        return personaRepo.findById(id).orElse(null);
    }
    
    public void editarPersona(Persona pers){
    
        personaRepo.save(pers);
    }


    public Persona login(String email, String password){
    
       return personaRepo.findByEmailAndPassword(email, password);
        
    }
    
    
    
}
