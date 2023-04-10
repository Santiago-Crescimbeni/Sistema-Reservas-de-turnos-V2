package com.example.Sistema.de.Registro.v2.Entity;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

//@Entity: Anotación de JPA que indica que la clase es una entidad que se mapeará a una tabla en la base de datos.
//@Table(name = "Usuarios"): Anotación que especifica el nombre de la tabla de la base de datos que se usará para esta entidad.
@Entity
@Table(name = "Usuarios")
public class Usuario implements UserDetails {

    //@Id: Anotación que indica que el atributo es una clave primaria de la entidad.
    //@GeneratedValue(strategy = GenerationType.IDENTITY): Anotación que especifica cómo se generará el valor de la clave primaria de la entidad,
    // en este caso se utilizará una estrategia de identidad.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//@Column: Anotación que se utiliza para mapear una propiedad de la entidad con una columna en la tabla de la base de datos.
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private String email;
    @Column
    private String password;


    //@Enumerated(EnumType.STRING): Anotación que se utiliza para mapear un atributo de tipo enumerado a una columna de tipo cadena en la tabla de la base de datos.
@Enumerated(EnumType.STRING)
    private UsuarioRol rol;


    //se proporciona un constructor vacío y otro que incluye todos los atributos de la entida
//Un constructor que toma los cinco atributos de la entidad Usuario. Se utiliza para crear nuevos objetos de la entidad Usuario.
    public Usuario(String nombre, String apellido, String email, String password, UsuarioRol rol) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.rol =  rol;
    }


    // Un constructor vacío que no toma parámetros.
    // Se utiliza principalmente por el framework de persistencia para crear objetos de la entidad Usuario a partir de resultados de consultas de base de datos.
    public Usuario() {
    }


    // Un constructor que toma los seis atributos de la entidad Usuario, incluyendo el identificador.
    // Este constructor se utiliza para crear objetos de la entidad Usuario a partir de resultados de consultas de base de datos.
    public Usuario(Long id, String nombre, String apellido, String email, String password, UsuarioRol rol) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.rol = rol;
    }

//Retorna una colección de roles/grantedAuthorities que el usuario posee.
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

            SimpleGrantedAuthority grantedAuthority= new SimpleGrantedAuthority(rol.name());
            return Collections.singletonList(grantedAuthority);
    }



//Retorna la contraseña del usuario.
    @Override
    public String getPassword() {
        return password;
    }


    //Retorna el nombre de usuario del usuario.
    @Override
    public String getUsername() {
        return email;
    }

    //Indica si la cuenta del usuario ha expirado.
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }


    // Indica si la cuenta del usuario está bloqueada.
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // Indica si las credenciales del usuario (contraseña) han expirado.
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }


    //Indica si el usuario está habilitado o deshabilitado.
    @Override
    public boolean isEnabled() {
        return true;
    }
}
