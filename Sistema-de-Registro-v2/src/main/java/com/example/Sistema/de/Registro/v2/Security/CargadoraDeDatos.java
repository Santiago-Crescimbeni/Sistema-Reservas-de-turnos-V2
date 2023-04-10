package com.example.Sistema.de.Registro.v2.Security;


import com.example.Sistema.de.Registro.v2.Entity.Usuario;
import com.example.Sistema.de.Registro.v2.Entity.UsuarioRol;
import com.example.Sistema.de.Registro.v2.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;



//// La anotación @Component se utiliza para indicar que esta clase es un componente de Spring y debe ser escaneada y administrada por Spring.
@Component
public class CargadoraDeDatos implements ApplicationRunner {

    // Inyección de dependencias a través de la anotación @Autowired

    private UsuarioRepository usuarioRepository;

// Constructor que recibe una instancia de UsuarioRepository para su uso en el método run()
    @Autowired
    public CargadoraDeDatos(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    // El método run() se ejecutará automáticamente cuando se inicie la aplicación

    @Override
    public void run(ApplicationArguments args) {

        // Se crea un objeto BCryptPasswordEncoder para cifrar las contraseñas

        BCryptPasswordEncoder cifrador=new BCryptPasswordEncoder();

        // Se define una contraseña para el primer usuario y se cifra
        String passACifrar="12345678";
        String passCifrada=cifrador.encode(passACifrar);


        // Se crea un objeto Usuario con la información del primer usuario
        Usuario usuarioAInsertar = new Usuario( "juan","perez","juan@gmail.com",passCifrada, UsuarioRol.ROLE_USER);

        // Se guarda el usuario en la base de datos utilizando el objeto usuarioRepository
        usuarioRepository.save(usuarioAInsertar);


        // Se define una contraseña para el segundo usuario y se cifra
        String passwordCifrado2= cifrador.encode("87654321");

        // Se crea un objeto Usuario con la información del segundo usuario
        usuarioAInsertar = new Usuario("santiago","crescimbeni","santi@gmail.com",passwordCifrado2, UsuarioRol.ROLE_ADMIN);


        // Se guarda el usuario en la base de datos utilizando el objeto usuarioRepository
        usuarioRepository.save(usuarioAInsertar);


    }
}




// info de interes:
//Este código define una clase CargadoraDeDatos que implementa la interfaz ApplicationRunner.
// La anotación @Component indica que esta clase es un componente de Spring y debe ser escaneada y administrada por Spring.
//
//La clase CargadoraDeDatos tiene un constructor que toma una instancia de UsuarioRepository como argumento y la almacena en un campo privado de la clase.
//
//El método run() es un método que implementa la interfaz ApplicationRunner y se ejecuta automáticamente cuando se inicia la aplicación.
// En este método, se crea un objeto BCryptPasswordEncoder para cifrar las contraseñas de los usuarios y se define una contraseña para cada uno de los dos usuarios.
//
//Se crea un objeto Usuario para cada usuario, utilizando las contraseñas cifradas y se guarda en la base de datos utilizando el objeto usuarioRepository.
//
//Esta clase se utiliza para cargar algunos datos de ejemplo en la base de datos cuando la aplicación se inicia, lo que puede ser útil para pruebas y desarrollo.