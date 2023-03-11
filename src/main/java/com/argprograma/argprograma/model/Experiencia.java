
package com.argprograma.argprograma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Getter @Setter
@Entity

public class Experiencia {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_experiencia;
    
    //@NotNull
    private String puesto;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date inicio;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fin;
    
    @Lob
    private String descripcion;
    private String imagen;
    private String url;
    
    //@NotNull
    private String empresa;
    
    //@NotNull
    //private int fk_persona;

    @ManyToOne(fetch=FetchType.LAZY, /* cascade=CascadeType.ALL*/ optional=false)
    @JoinColumn(name="fk_persona",referencedColumnName="id_persona",insertable=true, nullable=true, updatable=true)
    //@OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Persona persona;
    
    public Experiencia(){}

    public Experiencia(String puesto, Date inicio, Date fin, String descripcion, String imagen, String url, String empresa, Persona persona){
       
        this.puesto = puesto;
        this.inicio = inicio;
        this.fin = fin;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.url = url;
        this.empresa = empresa;
        this.persona = persona;
    }
    
   
    
    
    
}
