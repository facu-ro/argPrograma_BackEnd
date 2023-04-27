
package com.argprograma.argprograma.controller;

import com.argprograma.argprograma.model.Habilidad;
import com.argprograma.argprograma.model.Persona;
import com.argprograma.argprograma.model.Presentacion;
import com.argprograma.argprograma.service.habilidadService;
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
public class Chabilidad {
    
    @Autowired
    private habilidadService habiServ;
    
    @Autowired
    private presentacionService presenServ;
    
    
    
    @PostMapping("habilidad/nuevaHabilidad-Presentacion/{fk_presentacion}")
    public void agregar(@PathVariable int fk_presentacion,@RequestBody Habilidad habi){
        
       Presentacion presen= presenServ.buscarPresentacion(fk_presentacion);
       
      habi.setPresentacion(presen);
        
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
        
        habiEdit.setDescripcion_habilidad(habi.getDescripcion_habilidad());
        habiEdit.setImagen( habi.getImagen() );
        habiEdit.setPorcentaje( habi.getPorcentaje() );
        
        habiServ.editarHabilidad(habiEdit);
    }
    
    
    @GetMapping("habilidad/verUnaHabilidad/{id_habilidad}")
    @ResponseBody
    public Habilidad verUno(@PathVariable int id_habilidad){
    
        return habiServ.buscarHabilidad(id_habilidad);
    }
    
    
    @GetMapping("habilidad/verHabilidadPorPresentacion/{fk_presentacion}")
    @ResponseBody
    public List<Habilidad> verPorPresentacion(@PathVariable int fk_presentacion){
    
       Presentacion presen=presenServ.buscarPresentacion(fk_presentacion);
       
       return habiServ.buscarPorPresentacion(presen);
    }
    
}
