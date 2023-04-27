
package com.argprograma.argprograma.service;

import com.argprograma.argprograma.model.Persona;
import com.argprograma.argprograma.model.Presentacion;
import com.argprograma.argprograma.model.RedSocial;
import com.argprograma.argprograma.repository.IredsocialRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class redSocialService {
    
    @Autowired
    public IredsocialRepository redSocialRepo;
    
    public List<RedSocial> verRedSocial(){
        
        return redSocialRepo.findAll();
    }
    
    public void crearRedSocial(RedSocial red){
        
        redSocialRepo.save(red);
    }
    
    
    public void borrarRedSocial(int id){
    
        redSocialRepo.deleteById(id);
    }
    
    
    public RedSocial buscarRedSocial(int id){
    
       return redSocialRepo.findById(id).orElse(null);
    }
    
    public void editarRedSocial(RedSocial red){
    
        redSocialRepo.save(red);
    }
    
    public List<RedSocial> buscarPorPresentacion(Presentacion presen){
        
        
        return redSocialRepo.findByPresentacion(presen);
    
       
    }
    
    
  
    
}
