
package com.argprograma.argprograma.controller;

import com.argprograma.argprograma.model.Estudio;
import com.argprograma.argprograma.model.Persona;
import com.argprograma.argprograma.service.estudioService;
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
public class Cestudio {
    
    @Autowired
    private estudioService estudioServ;
    
    @Autowired
    private personaService persoServ;
    
    
    @PostMapping("estudio/nuevoEstudio/{id_persona}")
    public void agregar(@PathVariable int id_persona,@RequestBody Estudio estu ){
        
       Persona perso= persoServ.buscarPersona(id_persona);
        
       estu.setPersona(perso);
        
       estudioServ.crearEstudio(estu);
    }
    
    
    @GetMapping("estudio/verEstudios")
    @ResponseBody
    public List<Estudio> Listar(){
     
       return  estudioServ.verEstudio();
    }
    
    @DeleteMapping("estudio/borrarEstudio/{id_estudio}")
    public void borrar(@PathVariable  int id_estudio){
        
     estudioServ.borrarEstudio(id_estudio);
    }
    
    
    @PutMapping("estudio/editarEstudio")
    public void editar(@RequestBody Estudio estu ){
        
       Estudio estuEdit= estudioServ.buscarEstudio( estu.getId_estudio() );
       
       estuEdit.setDescripcion( estu.getDescripcion() );
       estuEdit.setEstado( estu.getEstado() );
       estuEdit.setImagen( estu.getImagen() );
       estuEdit.setTitulo( estu.getTitulo() );
       estuEdit.setUrl( estu.getUrl() );
       estuEdit.setInstitucion( estu.getInstitucion() );
        
       estudioServ.editarEstudio(estuEdit);
    }
    
    
    @GetMapping("estudio/estudioPorPersona/{id_persona}")
    @ResponseBody
    public List<Estudio> verPorPersona(@PathVariable int id_persona){
    
        
       Persona perso=persoServ.buscarPersona(id_persona);
       
       return estudioServ.buscarPorPersona(perso);
    
    }
    
    
    @GetMapping("estudio/verUnEstudio/{id_estudio}")
    @ResponseBody
    public Estudio verUno(@PathVariable int id_estudio){

        return estudioServ.buscarEstudio(id_estudio);
    }
    
    
    
}
