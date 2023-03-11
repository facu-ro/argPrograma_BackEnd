
package com.argprograma.argprograma.repository;

import com.argprograma.argprograma.model.Experiencia;
import com.argprograma.argprograma.model.Persona;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface IexperienciaRepository extends JpaRepository <Experiencia, Integer>{
    
    public List<Experiencia> findByPersona(Persona perso);
    
}
