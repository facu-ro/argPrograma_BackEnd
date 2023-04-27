
package com.argprograma.argprograma.controller;

import com.argprograma.argprograma.model.Persona;
import com.argprograma.argprograma.model.Presentacion;
import com.argprograma.argprograma.model.RedSocial;
import com.argprograma.argprograma.service.personaService;
import com.argprograma.argprograma.service.presentacionService;
import com.argprograma.argprograma.service.redSocialService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
class Credsocial {
    
    @Autowired
    private redSocialService redServ;
    
    @Autowired
    private presentacionService presenServ;
    
    @PostMapping("nuevaRed/red-Presentacion/{fk_presentacion}")
    public void agregar(@PathVariable int fk_presentacion,@RequestBody RedSocial red ){
       
       Presentacion presen= presenServ.buscarPresentacion(fk_presentacion);
        
       red.setPresentacion(presen);
     
       redServ.crearRedSocial(red);
    }
    
    
    @GetMapping("verRedes")
    @ResponseBody
    public List<RedSocial> Listar(){
     
       return  redServ.verRedSocial();
    }
    
    @DeleteMapping("/borrarRedes/{id}")
    public void borrar(@PathVariable int id){
        
     redServ.borrarRedSocial(id);
    }
    
    
    @PutMapping("/editarRed")
    public void editar(@RequestBody RedSocial red ){
        
        RedSocial redEdit=redServ.buscarRedSocial(red.getId_red());
        
        redEdit.setDescripcion(red.getDescripcion());
        redEdit.setUrl(red.getUrl());
        redEdit.setIcono(red.getIcono());
        
        redServ.editarRedSocial(redEdit);
    }
    
    
    @GetMapping("verUnaRedSocial/{id}")
    @ResponseBody
    public RedSocial verUno(@PathVariable int id){

        return redServ.buscarRedSocial(id);
    }
    
    
    @GetMapping("RedPorPresentacion/{id}")
    @ResponseBody
    public List<RedSocial> verPorPresentacion(@PathVariable int id){
    
        
       Presentacion presen=presenServ.buscarPresentacion(id);
       
       return redServ.buscarPorPresentacion(presen);
    }
    
}
