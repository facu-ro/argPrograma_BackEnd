
package com.argprograma.argprograma.controller;

import com.argprograma.argprograma.model.Persona;
import com.argprograma.argprograma.service.personaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
public class Cpersona {
    
    
    @Autowired
    private personaService persoServ;
    
    @PostMapping("/nuevaPersona/persona")
    public void agregar(@RequestBody Persona pers){
        
        persoServ.crearPersona(pers);
    }
    
    
    @GetMapping("verPersona/personas")
    @ResponseBody
    public List<Persona> Listar(){
     
       return persoServ.verPersonas();
    }
    
    @DeleteMapping("/borrarPersona/{id}")
    public void borrar(@PathVariable int id){
        
     persoServ.borrarPersona(id);
    }
    
    
    @PutMapping("/editarPersona")
    public void editar(@RequestBody Persona pers){
        
        persoServ.editarPersona(pers);
    }
    
    
    @GetMapping("verUnaPersona/{id}")
    @ResponseBody
    public Persona verUno(@PathVariable int id){
    
        
        return persoServ.buscarPersona(id);
    }
    
    
    
    
    @PostMapping("/login")
    //ResponseEntity<?>
    public boolean login(@RequestBody Persona per){
    
        
       Persona person= persoServ.login(per.getEmail(), per.getPassword() );
       
       
      if(person!=null){
           
         // person.isEmpty();
           //return ResponseEntity.ok(person.getEmail());
           
           //return person.getNombre() +" "+person.getApellido();
           
           return true;
       }
       else{
           
          
           //return (ResponseEntity<?>) ResponseEntity.internalServerError();
           //return "No se encontró al usuario";
           
           return false;
       }
        
       
       // return  person;
        
    }
    
    
    
    
    
    
    
}
