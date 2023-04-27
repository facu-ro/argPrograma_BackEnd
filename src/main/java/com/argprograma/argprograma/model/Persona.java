
package com.argprograma.argprograma.model;


//import java.validation.constraints.NotNull;
//import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;



@Getter @Setter
@Entity
public class Persona implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_persona;
    
    //@NotNull  no encuentra el paquete :/

    @Lob
    private String user_name;
    
    private String email;
    
    private String password;
    

    
    @OneToOne(mappedBy="persona", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @PrimaryKeyJoinColumn
   @JsonIgnore
    private Presentacion presentacion;
   
    //private String curriculum;

    
    
    public Persona(){}

    public Persona(String user_name, String email, String password) {
        
        this.user_name = user_name;
        this.email = email;
        this.password = password;
    }
    
   
    
    
    
}
