
package com.argprograma.argprograma.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Getter @Setter
@Entity
public class Habilidad {
    
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
   private int id_habilidad;
  
  private double porcentaje;
  //@NotNull
  
  @Lob
   private String descripcion_habilidad;
  
   
   private String imagen;    
   
   //@NotNull
   //private int fk_persona;
   
   @ManyToOne(fetch=FetchType.LAZY, /*cascade=CascadeType.ALL,*/ optional=false)
   @JoinColumn(name="fk_presentacion",referencedColumnName="fk_persona")
   //@OnDelete(action = OnDeleteAction.CASCADE)
   @JsonIgnore
   private Presentacion presentacion;
   
   public Habilidad(){}

   public Habilidad( String descripcion_habilidad, double porcentaje, String imagen, Presentacion presentacion){
        this.descripcion_habilidad = descripcion_habilidad;
        this.porcentaje = porcentaje;
        this.imagen = imagen;
        this.presentacion = presentacion;
    }

   
   
   
}
