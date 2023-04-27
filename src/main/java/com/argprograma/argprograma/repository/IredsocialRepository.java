
package com.argprograma.argprograma.repository;

import com.argprograma.argprograma.model.Persona;
import com.argprograma.argprograma.model.Presentacion;
import com.argprograma.argprograma.model.RedSocial;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IredsocialRepository extends JpaRepository <RedSocial, Integer> {
    
    public List<RedSocial> findByPresentacion(Presentacion presen);
}
