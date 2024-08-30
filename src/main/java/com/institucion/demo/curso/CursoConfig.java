package com.institucion.demo.curso;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.institucion.demo.estudiante.Estudiante;
import com.institucion.demo.estudiante.EstudianteRepository;
import com.institucion.demo.profesor.Profesor;
import com.institucion.demo.profesor.ProfesorRepository;

@Component
public class CursoConfig implements CommandLineRunner {

    @Autowired
    private EstudianteRepository estudianteRepository;
    @Autowired
    private ProfesorRepository profesorRepository;
    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public void run(String... args) throws Exception {
        //Inicialezar Estudiante
        Profesor profesor1 = new Profesor("John", "Doe");
        profesor1 = profesorRepository.save(profesor1);

        //Inicializar Profesor
        Estudiante estudiante1 = new Estudiante("Michael", "River", "mike@river.com");
        estudiante1 = estudianteRepository.save(estudiante1);

        //Inicializar Curso
        Curso curso1 = new Curso("Matemáticas", profesor1);
        Set<Estudiante> setEstudiantes1 = new HashSet<>();
        setEstudiantes1.add(estudiante1);

        curso1.setEstudiantes(setEstudiantes1);
        cursoRepository.save(curso1);

        estudianteRepository.save(estudiante1); 
        profesorRepository.save(profesor1);

    }

}
