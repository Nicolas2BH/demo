package com.institucion.demo.curso;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.IllegalTransactionStateException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CursoService {
    
    private final CursoRepository cursoRepository;

    public List<Curso> getCursos(){
        return cursoRepository.findAll();
    }

    public void agregarCurso(Curso curso){
        Optional<Curso> cursoPorNombre = cursoRepository
            .findByNombre(curso.getNombre());
        
            if(cursoPorNombre.isPresent()){
                throw new Error("Ya existe un curso con este Nombre");
            }

            cursoRepository.save(curso);
    }

     public void borrarCurso(Long cursoId) {
        boolean exists = cursoRepository.existsById(cursoId);

        if (!exists) {
            throw new IllegalTransactionStateException(cursoId + " no existe");
        }
        cursoRepository.deleteById(cursoId);
        System.out.println("Se ha eliminado el curso con id: " + cursoId);
    }

}
