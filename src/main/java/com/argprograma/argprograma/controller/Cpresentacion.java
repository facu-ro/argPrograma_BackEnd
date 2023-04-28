
package com.argprograma.argprograma.controller;

import com.argprograma.argprograma.model.Persona;
import com.argprograma.argprograma.model.Presentacion;
import com.argprograma.argprograma.service.personaService;
import com.argprograma.argprograma.service.presentacionService;
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
public class Cpresentacion {
    
    @Autowired
    private presentacionService presenServ;
    
    @Autowired
    private personaService persoServ;
    
    
    @PostMapping("nuevaPresentacion/{id_persona}/presentacion")
    public void agregar(@PathVariable("id_persona") int id_persona,@RequestBody Presentacion presen){
        
        Persona pers= persoServ.buscarPersona(id_persona);
       
        presen.setPersona(pers);
       
    
        presenServ.crearPresentacion(presen);
    }
    
    
    @GetMapping("verPresentacion/presentacion")
    @ResponseBody
    public List<Presentacion> Listar(){
     
       return presenServ.verPresentacion();
    }
    
    
    @GetMapping("presentacion/verUnaPresentacion/{id_persona}")
    @ResponseBody
    public Presentacion Listar(@PathVariable("id_persona") int id_persona){
     
       Presentacion presen= presenServ.buscarPresentacion(id_persona);
        
       return presen;
    }
    
    
    @PutMapping("presentacion/editarPresentacion/")
    public void editar(@RequestBody Presentacion presen){
        
       Presentacion presenEditar= presenServ.buscarPresentacion(presen.getFk_persona());
       
       Persona pers= persoServ.buscarPersona(presen.getFk_persona());

        
        presenEditar.setPersona(pers);
        presenEditar.setApellido(presen.getApellido());
        presenEditar.setNombre(presen.getNombre());
        presenEditar.setBanner(presen.getBanner());
        presenEditar.setDescripcion(presen.getDescripcion());
        presenEditar.setFoto(presen.getFoto());
              
    
        presenServ.crearPresentacion(presenEditar);
    }
    
    
    
    
    @DeleteMapping("borrarPresentacion/{id}")
    public void borrar(@PathVariable int id){
        
     presenServ.borrarPresentacion(id);
    }
    
    
    
    
    
    
    
}
