
package com.argprograma.argprograma.service;

import com.argprograma.argprograma.model.Estudio;
import com.argprograma.argprograma.model.Persona;
import com.argprograma.argprograma.model.Presentacion;
import com.argprograma.argprograma.repository.IestudioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class estudioService {
    
    @Autowired
    public IestudioRepository estudioRepo;
    
    public List<Estudio> verEstudio(){
        
        return estudioRepo.findAll();
    }
    
    public void crearEstudio(Estudio estudio){
        
        estudioRepo.save(estudio);
    }
    
    
    public void borrarEstudio(int id){
    
        estudioRepo.deleteById(id);
    }
    
    
    public Estudio buscarEstudio(int id){
    
        return estudioRepo.findById(id).orElse(null);
    }
    
    public void editarEstudio(Estudio estudio){
    
        estudioRepo.save(estudio);
    }
    
    
    public List<Estudio> buscarPorPresentacion(Presentacion presentacion){
        
        return estudioRepo.findByPresentacion(presentacion);
    
    }
    
}
