
package com.argprograma.argprograma.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Getter @Setter
@Entity
public class Estudio {
    
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_estudio;
    
  //@NotNull
    private String titulo;
    private String estado;
    
    @Lob
    private String descripcion;
    private String imagen;
    private String url;
    
    //@NotNull
    private String institucion; 
    //private int fk_persona;
    
    
    @ManyToOne(fetch=FetchType.LAZY, /*cascade=CascadeType.ALL,*/ optional=false)
    @JoinColumn(name="fk_persona",referencedColumnName="id_persona")
    //@OnDelete(action = OnDeleteAction.CASCADE)
    
    @JsonIgnore
    private Persona persona;
    
    public Estudio(){}

    public Estudio( String titulo, String estado, String descripcion, String imagen, String url, String institucion, Persona persona){
        this.titulo = titulo;
        this.estado = estado;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.url = url;
        this.institucion = institucion;
        this.persona = persona;
    }

    
    
    
    
    
}
