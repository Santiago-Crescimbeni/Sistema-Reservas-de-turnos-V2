package com.example.Sistema.de.Registro.v2.Repository;

import com.example.Sistema.de.Registro.v2.Entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//@Repository: Esta anotación indica que esta interfaz es un componente de Spring que maneja la interacción con la base de datos.
//
//public interface TurnoRepository: Esta es una interfaz pública llamada TurnoRepository, que define un contrato para interactuar con una entidad de turno.
//
//extends JpaRepository<Turno,Long>: La interfaz TurnoRepository extiende la interfaz JpaRepository.
// JpaRepository es una interfaz de Spring Data JPA que proporciona métodos predefinidos para interactuar con la base de datos.
// La clase Turno es la entidad con la que se interactúa y Long es el tipo de datos del identificador único.
// En este caso, no se agregan métodos personalizados, por lo que se utilizan los métodos predefinidos proporcionados por JpaRepository.


@Repository
public interface TurnoRepository extends JpaRepository<Turno,Long> {

}
