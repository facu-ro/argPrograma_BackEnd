
package com.argprograma.argprograma.repository;

import com.argprograma.argprograma.model.Experiencia;
import com.argprograma.argprograma.model.Persona;
import com.argprograma.argprograma.model.Presentacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface IexperienciaRepository extends JpaRepository <Experiencia, Integer>{
    
    public List<Experiencia> findByPresentacion(Presentacion presentacion);
    
}
