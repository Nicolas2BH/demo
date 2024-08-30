package com.institucion.demo.estudiante;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante,Long>{

    @Query("SELECT e FROM Estudiante e WHERE e.email = ?")
    Optional<Estudiante> findStudentByEmail(String email);
}
