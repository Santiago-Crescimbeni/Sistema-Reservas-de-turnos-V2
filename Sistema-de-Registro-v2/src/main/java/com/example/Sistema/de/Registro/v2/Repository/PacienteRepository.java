package com.example.Sistema.de.Registro.v2.Repository;

import com.example.Sistema.de.Registro.v2.Entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



//@Repository: Esta anotación indica que esta interfaz es un componente de Spring que maneja la interacción con la base de datos.
//
//public interface PacienteRepository: Esta es una interfaz pública llamada PacienteRepository, que define un contrato para interactuar con una entidad de paciente.
//
//extends JpaRepository<Paciente,Long>: La interfaz PacienteRepository extiende la interfaz JpaRepository.
// JpaRepository es una interfaz de Spring Data JPA que proporciona métodos predefinidos para interactuar con la base de datos.
// La clase Paciente es la entidad con la que se interactúa y Long es el tipo de datos del identificador único.
// En este caso, no se agregan métodos personalizados, por lo que se utilizan los métodos predefinidos proporcionados por JpaRepository.
@Repository
public interface PacienteRepository extends JpaRepository<Paciente,Long> {
}
