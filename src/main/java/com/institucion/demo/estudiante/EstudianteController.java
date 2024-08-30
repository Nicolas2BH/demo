package com.institucion.demo.estudiante;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@AllArgsConstructor
@RequestMapping(path = "api/v1/estudiante")
public class EstudianteController {

    private final EstudianteService estudianteService;
    
    @GetMapping
    public List<Estudiante> getEstuadiantes() {
        return estudianteService.getEstudiantes();
    }

    @PostMapping
    public void registrarEstudiante(@RequestBody Estudiante estudiante) {
        estudianteService.agregarEstuadiante(estudiante);
    }
    
    @DeleteMapping(path= "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        estudianteService.borrarEstudiante(studentId);
    }

    @PutMapping(path="{studentId}")
    public void updateStudent(
        @PathVariable("studentId") Long studentId, 
        @RequestParam(required = false) String nombre,
        @RequestParam(required = false) String apellido,
        @RequestParam(required = false) String email
        ) {
   
        estudianteService.actualizarEstuadiante(studentId, nombre,apellido, email);
    }
    
}
