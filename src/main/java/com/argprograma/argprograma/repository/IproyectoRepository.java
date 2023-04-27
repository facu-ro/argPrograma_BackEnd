
package com.argprograma.argprograma.repository;

import com.argprograma.argprograma.model.Persona;
import com.argprograma.argprograma.model.Presentacion;
import com.argprograma.argprograma.model.Proyecto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IproyectoRepository extends JpaRepository <Proyecto, Integer> {
    
    public List<Proyecto> findByPresentacion(Presentacion presentacion);
}
