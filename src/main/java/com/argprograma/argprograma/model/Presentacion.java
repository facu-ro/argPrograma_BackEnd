
package com.argprograma.argprograma.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import static javax.persistence.ConstraintMode.CONSTRAINT;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;



@Getter @Setter
@Entity
//@IdClass( Persona.class )
public class Presentacion implements Serializable{
    
    //DROP TABLES estudio,experiencia,habilidad,proyecto,red_social,presentacion,persona
    @Id
   // @GeneratedValue(strategy=GenerationType.IDENTITY)
  // @Column(name="fk_persona",insertable=true, nullable=true, updatable=true)
   //private int id_presentacion;
    private int fk_persona;
   // @JoinColumn(name="fk_persona",referencedColumnName="id_persona",insertable=true, nullable=true, updatable=true)
    //@OnDelete(action = OnDeleteAction.CASCADE)
    
     @Lob
    private String descripcion;
    
    private String  nombre;
    
    //@NotNull
    private String apellido;
    private String foto;
    
    
    
    
    private String banner;
    
   
    @JsonIgnore
    @MapsId
    @OneToOne()
    @JoinColumn(name="fk_persona",referencedColumnName="id_persona",insertable=true,updatable=true )
    private Persona persona;
    
    
   // private int id_presentacion;
    
   

    
   @OneToMany (mappedBy="presentacion",fetch=FetchType.LAZY, cascade=CascadeType.ALL)
   @JsonIgnore
   private List<Experiencia> experiencias; 
   
   @OneToMany (mappedBy="presentacion",fetch=FetchType.LAZY, cascade=CascadeType.ALL)
   @JsonIgnore
   private List<Proyecto> proyectos; 
   
   @OneToMany (mappedBy="presentacion",fetch=FetchType.LAZY, cascade=CascadeType.ALL)
   @JsonIgnore
   private List<Habilidad> habilidad; 
   
   @OneToMany (mappedBy="presentacion",fetch=FetchType.LAZY, cascade=CascadeType.ALL)
   @JsonIgnore
   private List<Estudio> estudio; 
   
   
   @OneToMany (mappedBy="presentacion",fetch=FetchType.LAZY, cascade=CascadeType.ALL)
   @JsonIgnore
   private List<RedSocial> redes; 
    
    
    public Presentacion() {
    }
    
    public Presentacion(String nombre, String apellido, String foto, String descripcion, String banner) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.foto = foto;
        this.descripcion = descripcion;
        this.banner = banner;
    }
    
  
    
}
