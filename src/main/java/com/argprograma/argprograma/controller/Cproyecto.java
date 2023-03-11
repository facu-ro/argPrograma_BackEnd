
package com.argprograma.argprograma.controller;

import com.argprograma.argprograma.model.Persona;
import com.argprograma.argprograma.model.Proyecto;
import com.argprograma.argprograma.service.personaService;
import com.argprograma.argprograma.service.proyectoService;
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
public class Cproyecto {
    
    @Autowired
    private proyectoService proyecServ;
    
    @Autowired
    private personaService persoServ;
    
    
    
    @PostMapping("proyecto/nuevaProyecto-persona/{id_persona}")
    public void agregar(@PathVariable int id_persona,@RequestBody Proyecto proyec ){
            
        Persona perso= persoServ.buscarPersona(id_persona);
        
        proyec.setPersona(perso);
        
        proyecServ.crearProyecto(proyec);
    
    }
    
    
    @GetMapping("proyecto/verProyectos/")
    @ResponseBody
    public List<Proyecto> Listar(){
     
       return  proyecServ.ListarProyectos();
    }
    
    @DeleteMapping("proyecto/borrarProyecto/{id_proyecto}")
    public void borrar(@PathVariable  int id_proyecto){
        
     proyecServ.borrarProyecto(id_proyecto);
    }
    
    
    @PutMapping("proyecto/editarProyecto/")
    public void editar(@RequestBody Proyecto proyec){
       
       Proyecto proyecEdit=proyecServ.buscarProyecto( proyec.getId_proyecto() );
        
       proyecEdit.setDescripcion( proyec.getDescripcion() );
       proyecEdit.setImagen( proyec.getImagen() );
       proyecEdit.setTitulo( proyec.getTitulo() );
       proyecEdit.setUrl( proyec.getUrl() );
       
       
       proyecServ.editarProyecto(proyecEdit);
    }
    
    
    
    @GetMapping("proyecto/verUnProyecto/{id_proyecto}")
    @ResponseBody
    public Proyecto verUno(@PathVariable int id_proyecto){
    
        return proyecServ.buscarProyecto(id_proyecto);
    }
    
    
    @GetMapping("proyecto/verProyectoPorPersona/{id_persona}")
    @ResponseBody
    public List<Proyecto> verPorPersona(@PathVariable int id_persona){
    
       Persona perso=persoServ.buscarPersona(id_persona);
       
       return proyecServ.buscarPorPersona(perso);
    }
    
    
    
}
