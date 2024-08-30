package com.institucion.demo.curso;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path = "api/v1/curso")
public class CursoController {

    private final CursoService cursoService;

    @GetMapping
    public List<Curso> getCursos(){
        return cursoService.getCursos();
    }
    
    @PostMapping
    public void registrarCurso(@RequestBody Curso curso) {
        cursoService.agregarCurso(curso);
    }

    @DeleteMapping(path= "{cursoId}")
    public void deleteStudent(@PathVariable("cursoId") Long cursoId){
        cursoService.borrarCurso(cursoId);
    }
}
