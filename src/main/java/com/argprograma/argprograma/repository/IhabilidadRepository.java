
package com.argprograma.argprograma.repository;

import com.argprograma.argprograma.model.Habilidad;
import com.argprograma.argprograma.model.Persona;
import com.argprograma.argprograma.model.Presentacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IhabilidadRepository extends JpaRepository <Habilidad, Integer> {
 
    
    public List<Habilidad> findByPresentacion(Presentacion presentacion);

}
