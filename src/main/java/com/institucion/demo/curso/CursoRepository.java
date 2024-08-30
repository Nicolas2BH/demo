package com.institucion.demo.curso;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CursoRepository extends JpaRepository<Curso,Long>{
    @Query("SELECT c FROM Curso c WHERE c.nombre = ?")
    Optional<Curso> findByNombre(String nombre);
}
