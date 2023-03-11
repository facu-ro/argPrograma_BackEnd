
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
public class RedSocial {
    
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int id_red;
  
  //@NotNull
  private String descripcion;
  
  private String url;
  private String icono;
  
  //@NotNull
  //private int fk_persona;

  
  @ManyToOne(fetch=FetchType.LAZY, /*cascade=CascadeType.ALL,*/ optional=false)
  @JoinColumn(name="fk_persona",referencedColumnName="id_persona", insertable=true, nullable=true, updatable=true)
  //@OnDelete(action = OnDeleteAction.CASCADE)
  @JsonIgnore
  private Persona persona;
  
  public RedSocial(){}

  public RedSocial(String descripcion, String url, String icono, Persona persona){
      
        this.descripcion = descripcion;
        this.url = url;
        this.icono = icono;
        this.persona = persona;
    }

 

 public void setPersonaid(int personaid) {
        persona.setId_persona(personaid);
    
 }

  
}
