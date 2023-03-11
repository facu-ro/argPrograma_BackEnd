
package com.argprograma.argprograma.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
  
  //@NotNull
   private String habilidad;
  
   private String porcentaje;
   private String imagen;    
   
   //@NotNull
   //private int fk_persona;
   
   @ManyToOne(fetch=FetchType.LAZY, /*cascade=CascadeType.ALL,*/ optional=false)
   @JoinColumn(name="fk_persona",referencedColumnName="id_persona")
   //@OnDelete(action = OnDeleteAction.CASCADE)
   @JsonIgnore
   private Persona persona;
   
   public Habilidad(){}

   public Habilidad( String habilidad, String porcentaje, String imagen, Persona persona){
        this.habilidad = habilidad;
        this.porcentaje = porcentaje;
        this.imagen = imagen;
        this.persona = persona;
    }

   
   
   
}
