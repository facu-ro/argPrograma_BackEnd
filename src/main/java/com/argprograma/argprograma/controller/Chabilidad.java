
package com.argprograma.argprograma.controller;

import com.argprograma.argprograma.model.Habilidad;
import com.argprograma.argprograma.model.Persona;
import com.argprograma.argprograma.service.habilidadService;
import com.argprograma.argprograma.service.personaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Chabilidad {
    
    @Autowired
    private habilidadService habiServ;
    
    @Autowired
    private personaService persoServ;
    
    
    
    @PostMapping("habilidad/nuevaHabilidad-persona/{id_persona}")
    public void agregar(@PathVariable int id_persona,@RequestBody Habilidad habi){
        
       Persona perso= persoServ.buscarPersona(id_persona);
       
       habi.setPersona(perso);
        
       habiServ.crearHabilidad(habi);
    }
    
    
    @GetMapping("habilidad/verHabilidades")
    @ResponseBody
    public List<Habilidad> Listar(){
     
       return habiServ.verHabilidad();
    }
    
    @DeleteMapping("habilidad/borrarHabilidad/{id_habilidad}")
    public void borrar(@PathVariable  int id_habilidad){
        
     habiServ.borrarHabilidad(id_habilidad);
    }
    
    
    @PutMapping("habilidad/editarHabilidad")
    public void editar(@RequestBody Habilidad habi){
        
        Habilidad habiEdit= habiServ.buscarHabilidad( habi.getId_habilidad() );
        
        habiEdit.setHabilidad( habi.getHabilidad() );
        habiEdit.setImagen( habi.getImagen() );
        habiEdit.setPorcentaje( habi.getPorcentaje() );
        
        habiServ.editarHabilidad(habiEdit);
    }
    
    
    @GetMapping("habilidad/verUnaHabilidad/{id_habilidad}")
    @ResponseBody
    public Habilidad verUno(@PathVariable int id_habilidad){
    
        return habiServ.buscarHabilidad(id_habilidad);
    }
    
    
    @GetMapping("habilidad/verHabilidadPorPersona/{id_persona}")
    @ResponseBody
    public List<Habilidad> verPorPersona(@PathVariable int id_persona){
    
       Persona perso=persoServ.buscarPersona(id_persona);
       
       return habiServ.buscarPorPersona(perso);
    }
    
}
