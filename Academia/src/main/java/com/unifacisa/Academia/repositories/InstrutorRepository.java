package com.unifacisa.Academia.repositories;

import com.unifacisa.Academia.entities.Instrutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstrutorRepository extends JpaRepository<Instrutor,Integer> {
}
