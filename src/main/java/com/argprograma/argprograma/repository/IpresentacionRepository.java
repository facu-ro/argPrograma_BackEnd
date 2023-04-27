

package com.argprograma.argprograma.repository;

import com.argprograma.argprograma.model.Presentacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IpresentacionRepository extends JpaRepository <Presentacion, Integer> {
    
}
