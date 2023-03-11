
package com.argprograma.argprograma.repository;

import com.argprograma.argprograma.model.Estudio;
import com.argprograma.argprograma.model.Persona;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IestudioRepository extends JpaRepository <Estudio, Integer> {
    
    public List<Estudio> findByPersona(Persona perso);
}
