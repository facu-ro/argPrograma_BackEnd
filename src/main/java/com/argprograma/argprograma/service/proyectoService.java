
package com.argprograma.argprograma.service;

import com.argprograma.argprograma.model.Persona;
import com.argprograma.argprograma.model.Presentacion;
import com.argprograma.argprograma.model.Proyecto;
import com.argprograma.argprograma.repository.IproyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class proyectoService {
    
    @Autowired
    public IproyectoRepository proyectoRepo;
    
    public List<Proyecto> ListarProyectos(){
        
        return proyectoRepo.findAll();
    }
    
    public void crearProyecto(Proyecto proye){
        
        proyectoRepo.save(proye);
    }
    
    
    public void borrarProyecto(int id){
    
        proyectoRepo.deleteById(id);
    }
    
    
    public Proyecto buscarProyecto(int id){
    
       return proyectoRepo.findById(id).orElse(null);
    }
    
    public void editarProyecto(Proyecto pers){
    
        proyectoRepo.save(pers);
    }
    
    
    
    public List<Proyecto> buscarPorPresentacion(Presentacion presen){
        
        return proyectoRepo.findByPresentacion(presen);
    
    }
    
}
