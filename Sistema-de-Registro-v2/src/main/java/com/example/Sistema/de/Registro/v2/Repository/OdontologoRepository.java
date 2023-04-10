package com.example.Sistema.de.Registro.v2.Repository;

import com.example.Sistema.de.Registro.v2.Entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



//@Repository: Esta anotación indica que esta interfaz es un componente de Spring que maneja la interacción con la base de datos.
//
//public interface OdontologoRepository: Esta es una interfaz pública llamada OdontologoRepository, que define un contrato para interactuar con una entidad de odontólogo.
//
//extends JpaRepository<Odontologo,Long>: La interfaz OdontologoRepository extiende la interfaz JpaRepository.
// JpaRepository es una interfaz de Spring Data JPA que proporciona métodos predefinidos para interactuar con la base de datos.
// La clase Odontologo es la entidad con la que se interactúa y Long es el tipo de datos del identificador único.
// En este caso, no se agregan métodos personalizados, por lo que se utilizan los métodos predefinidos proporcionados por JpaRepository.



@Repository
public interface OdontologoRepository extends JpaRepository<Odontologo,Long> {
}
