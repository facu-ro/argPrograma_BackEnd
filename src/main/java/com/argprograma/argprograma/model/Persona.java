
package com.argprograma.argprograma.model;


//import java.validation.constraints.NotNull;
//import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;



@Getter @Setter
@Entity
public class Persona{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_persona;
    
    //@NotNull  no encuentra el paquete :/
    private String  nombre;
    
    //@NotNull
    private String apellido;
    private String foto;
    
    @Lob
    private String descripcion;
    
    private String banner;
    
    
    private String email;
    
    private String password;
    
   @OneToMany (mappedBy="persona",fetch=FetchType.LAZY, cascade=CascadeType.ALL)
   @JsonIgnore
   private List<Experiencia> experiencias; 
   
   @OneToMany (mappedBy="persona",fetch=FetchType.LAZY, cascade=CascadeType.ALL)
   @JsonIgnore
   private List<Proyecto> proyectos; 
   
   @OneToMany (mappedBy="persona",fetch=FetchType.LAZY, cascade=CascadeType.ALL)
   @JsonIgnore
   private List<Habilidad> habilidad; 
   
   @OneToMany (mappedBy="persona",fetch=FetchType.LAZY, cascade=CascadeType.ALL)
   @JsonIgnore
   private List<Estudio> estudio; 
   
   
   @OneToMany (mappedBy="persona",fetch=FetchType.LAZY, cascade=CascadeType.ALL)
   @JsonIgnore
   private List<RedSocial> redes; 
   
    //private String curriculum;

    
    
    public Persona(){}
    
    public Persona(String nombre, String apellido, String foto, String banner, String email, String descripcion){
        this.nombre = nombre;
        this.apellido = apellido;
        this.foto = foto;
        this.banner = banner;
        this.email = email;
        this.descripcion = descripcion;
    }
    
    
    
}
