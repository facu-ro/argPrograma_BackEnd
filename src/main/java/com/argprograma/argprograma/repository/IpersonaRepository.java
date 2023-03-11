
package com.argprograma.argprograma.repository;

import com.argprograma.argprograma.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IpersonaRepository extends JpaRepository <Persona, Integer> {
    
    public Persona findByEmailAndPassword(String email, String password);
}
