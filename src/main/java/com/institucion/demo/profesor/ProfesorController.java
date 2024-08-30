package com.institucion.demo.profesor;

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
@RequestMapping(path = "api/v1/profesor")
public class ProfesorController {
     private final ProfesorService profesorService;
    
    @GetMapping
    public List<Profesor> getEstudiantes() {
        return profesorService.getProfesores();
    }

    @PostMapping
    public void registrarProfesor(@RequestBody Profesor profesor) {
        profesorService.agregarProfesor(profesor);
    }
    
    @DeleteMapping(path= "{profesorId}")
    public void deleteStudent(@PathVariable("profesorId") Long profesorId){
        profesorService.borrarProfesor(profesorId);
    }
    
}
