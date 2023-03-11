
package com.argprograma.argprograma.repository;

import com.argprograma.argprograma.model.Habilidad;
import com.argprograma.argprograma.model.Persona;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IhabilidadRepository extends JpaRepository <Habilidad, Integer> {
 
    
    public List<Habilidad> findByPersona(Persona perso);

}
