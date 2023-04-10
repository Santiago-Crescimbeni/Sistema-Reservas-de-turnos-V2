package com.example.Sistema.de.Registro.v2.Repository;

import com.example.Sistema.de.Registro.v2.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


//public interface UsuarioRepository: Esta es una interfaz pública llamada UsuarioRepository, que define un contrato para interactuar con una entidad de usuario.
//
//extends JpaRepository<Usuario,Long>: La interfaz UsuarioRepository extiende la interfaz JpaRepository.
// JpaRepository es una interfaz de Spring Data JPA que proporciona métodos predefinidos para interactuar con la base de datos.
// La clase Usuario es la entidad con la que se interactúa y Long es el tipo de datos del identificador único.
//
//Optional<Usuario> findByEmail(String email): Este método define una consulta que busca un usuario por correo electrónico.
// Optional es una clase que se utiliza para evitar errores de puntero nulo y el tipo de retorno especifica que se espera un usuario.
// findByEmail es una convención de nombres de Spring Data JPA para la consulta. El parámetro email especifica el correo electrónico por el que se busca al usuario.


public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    Optional<Usuario> findByEmail(String email);
}
