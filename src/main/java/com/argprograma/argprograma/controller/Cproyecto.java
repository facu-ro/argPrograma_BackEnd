
package com.argprograma.argprograma.controller;

import com.argprograma.argprograma.model.Persona;
import com.argprograma.argprograma.model.Presentacion;
import com.argprograma.argprograma.model.Proyecto;
import com.argprograma.argprograma.service.personaService;
import com.argprograma.argprograma.service.presentacionService;
import com.argprograma.argprograma.service.proyectoService;
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
public class Cproyecto {
    
    @Autowired
    private proyectoService proyecServ;
    
    @Autowired
    private presentacionService presenServ;
    
    
    
    @PostMapping("proyecto/nuevaProyecto-Presentacion/{fk_presentacion}")
    public void agregar(@PathVariable int fk_presentacion,@RequestBody Proyecto proyec ){
            
        Presentacion presen= presenServ.buscarPresentacion(fk_presentacion);
        
        proyec.setPresentacion(presen);
        
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
    
    
    @GetMapping("proyecto/verProyectoPorPresentacion/{fk_presentacion}")
    @ResponseBody
    public List<Proyecto> verPorPresentacion(@PathVariable int fk_presentacion){
    
       Presentacion presen=presenServ.buscarPresentacion(fk_presentacion);
       
       return proyecServ.buscarPorPresentacion(presen);
    }
    
    
    
}
