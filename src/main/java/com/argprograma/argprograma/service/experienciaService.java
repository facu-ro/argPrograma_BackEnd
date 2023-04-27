
package com.argprograma.argprograma.service;

import com.argprograma.argprograma.model.Experiencia;
import com.argprograma.argprograma.model.Persona;
import com.argprograma.argprograma.model.Presentacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.argprograma.argprograma.repository.IexperienciaRepository;

@Service
public class experienciaService {
    
    @Autowired
    public IexperienciaRepository expeRepo;
    
    public List<Experiencia> verExperiencias(){
        
        return expeRepo.findAll();
    }
    
    public void crearExperiencia(Experiencia expe){
        
        expeRepo.save(expe);
    }
    
    
    public void borrarExperiencia(int id /*Experiencia expe*/){
    
        expeRepo.deleteById(id);
       // expeRepo.delete(expe);
    }
    
    
    public Experiencia buscarExperiencia(int id){
    
       return expeRepo.findById(id).orElse(null);
    }
    
    public void editarExperiencia(Experiencia expe){
    
        expeRepo.save(expe);
    }


    
    public List<Experiencia> buscarPorPresentacion(Presentacion presen){
        
        return expeRepo.findByPresentacion(presen);
    
       
    }
    
    
    
}
