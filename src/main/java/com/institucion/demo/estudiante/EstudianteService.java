package com.institucion.demo.estudiante;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.IllegalTransactionStateException;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EstudianteService {

    private final EstudianteRepository estudianteRepository;

    public List<Estudiante> getEstudiantes() {
        return estudianteRepository.findAll();
    }

    public void agregarEstuadiante(Estudiante estudiante) {
        Optional<Estudiante> estudiantePorEmail = estudianteRepository
                .findStudentByEmail(estudiante.getEmail());

        if (estudiantePorEmail.isPresent()) {
            throw new Error("Ya existe unestudiante con ese email");
        }

        estudianteRepository.save(estudiante);
    }

    public void borrarEstudiante(Long studentId) {
        boolean exists = estudianteRepository.existsById(studentId);

        if (!exists) {
            throw new IllegalTransactionStateException(studentId + " no existe");
        }
        estudianteRepository.deleteById(studentId);
        System.out.println("Se ha eliminado el estudiante con id: " + studentId);
    }

    @Transactional
    public void actualizarEstuadiante(
            Long studentId,
            String nombre,
            String apellido,
            String email) {
        Estudiante estudiante = estudianteRepository.findById(studentId)
                .orElseThrow(() -> new IllegalTransactionStateException("No existe el Id"));

        if (nombre != null && nombre.length() > 0 && !Objects.equals(estudiante.getNombre(), nombre)) {
            estudiante.setNombre(nombre);
        }

        if (apellido != null && apellido.length() > 0 && !Objects.equals(estudiante.getApellido(), apellido)) {
            estudiante.setApellido(apellido);
        }

        if (email != null && email.length() > 0 && !Objects.equals(estudiante.getEmail(), email)) {
            estudiante.setEmail(email);
        }
    }
}
