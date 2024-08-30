package com.institucion.demo.curso;

import java.util.HashSet;
import java.util.Set;

import com.institucion.demo.estudiante.Estudiante;
import com.institucion.demo.profesor.Profesor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToMany
    @JoinTable(name = "curso_estudiante", joinColumns = @JoinColumn(name = "curso_id"), inverseJoinColumns = @JoinColumn(name = "estudiante_id"))
    private Set<Estudiante> estudiantes = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "profesor_id")
    private Profesor profesor;

    public Curso(String nombre) {
        this.nombre = nombre;
    }

    

    public Curso(String nombre, Profesor profesor) {
        this.nombre = nombre;
        this.profesor = profesor;
    }

    public Curso(String nombre, Set<Estudiante> estudiantes, Profesor profesor) {
        this.nombre = nombre;
        this.estudiantes = estudiantes;
        this.profesor = profesor;
    }

}
