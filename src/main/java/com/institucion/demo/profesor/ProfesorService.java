package com.institucion.demo.profesor;

import java.util.List;

import org.springframework.stereotype.Service;

import com.institucion.demo.curso.CursoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProfesorService {

    private final ProfesorRepository profesorRepository;
    private final CursoRepository cursoRepository;

    public List<Profesor> getProfesores() {
        return profesorRepository.findAll();
    }

    public void agregarProfesor(Profesor profesor) {
        profesorRepository.save(profesor);
        System.out.println("El ha agregado al profesor: " +profesor );
    }

    public void borrarProfesor(Long profesorId){
        Profesor profesor = profesorRepository.findById(profesorId)
        .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));
       
        profesor.getCursos().forEach(curso -> {
            curso.setProfesor(null);
            cursoRepository.save(curso);
        });

        profesorRepository.deleteById(profesorId);
        System.out.println("Se ha eliminado el profesor con id: " + profesorId);
    }

}
