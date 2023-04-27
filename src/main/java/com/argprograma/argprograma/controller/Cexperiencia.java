
package com.argprograma.argprograma.controller;

import com.argprograma.argprograma.model.Experiencia;
import com.argprograma.argprograma.model.Persona;
import com.argprograma.argprograma.model.Presentacion;
import com.argprograma.argprograma.service.experienciaService;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;




@RestController
//@RequestMapping("/experiencia")  {"http://localhost:4200"} , allowCredentials="false"
//@CrossOrigin( origins="http://localhost:4200")

@RequestMapping("/api")



public class Cexperiencia {
    
    @Autowired
    private experienciaService expeServ;
    
    @Autowired
    private presentacionService presenServ;
    
    //presentacion
    
    @PostMapping("experiencia/nuevaExperencia-Presentacion/{fk_presentacion}")
    public void agregar(@PathVariable int fk_presentacion,@RequestBody Experiencia expe){

        Presentacion presen= presenServ.buscarPresentacion(fk_presentacion);
        
        expe.setPresentacion(presen);
        
        expeServ.crearExperiencia(expe);
    }
    
    
    @GetMapping("experiencia/verExperiencias/")
    @ResponseBody
    public List<Experiencia> Listar(){
     
       return expeServ.verExperiencias();
    }
    
    
    @DeleteMapping("experiencia/borrarExperiencia/{id_experiencia}")
    //@RequestMapping(value= "{id_experiencia}", method = RequestMethod.DELETE)
    public void borrar(@PathVariable("id_experiencia") int id_experiencia){
     
     Experiencia expeBorrar=expeServ.buscarExperiencia(id_experiencia);
     expeServ.borrarExperiencia(id_experiencia);
    }
    
    
    @PutMapping("experiencia/editarExperencia")
    public void editar(@RequestBody Experiencia expe){
        
        Experiencia expeEdit= expeServ.buscarExperiencia( expe.getId_experiencia() );
        
        expeEdit.setDescripcion( expe.getDescripcion() );
        expeEdit.setEmpresa( expe.getEmpresa() );
        expeEdit.setFin( expe.getFin() );
        expeEdit.setInicio( expe.getFin() );
        expeEdit.setImagen( expe.getImagen() );
        expeEdit.setPuesto( expe.getPuesto() );
        expeEdit.setUrl( expe.getUrl() );
        
        
        expeServ.editarExperiencia(expeEdit);
    }
    
    
    
    @GetMapping("experiencia/verUnaExperiencia/{id_experiencia}")
    @ResponseBody
    public Experiencia verUno(@PathVariable int id_experiencia){
    
        return expeServ.buscarExperiencia(id_experiencia);
    }
    
    
    @GetMapping("experiencia/verExperienciaPorPresentacion/{fk_presentacion}")
    @ResponseBody
    public List<Experiencia> verPorPresentacion(@PathVariable int fk_presentacion){
    
       Presentacion presen=presenServ.buscarPresentacion(fk_presentacion);
       
       return expeServ.buscarPorPresentacion(presen);
    }
    
    
}
