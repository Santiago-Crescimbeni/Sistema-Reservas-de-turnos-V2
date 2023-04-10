package com.example.Sistema.de.Registro.v2.Security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// La anotación @Configuration indica que esta clase es una clase de configuración de Spring
@Configuration
public class PasswordEncoder {
    // La anotación @Bean se utiliza para indicar que este método crea y configura un bean de Spring

    @Bean
    public BCryptPasswordEncoder myPasswordEncoder(){
        // Se crea un objeto BCryptPasswordEncoder y se devuelve como bean de Spring

        return new BCryptPasswordEncoder();
}

}





//INFO DE INTERES:

//Este código define una clase de configuración de Spring que crea un objeto de codificador de contraseñas BCryptPasswordEncoder como un bean de Spring.
// Esto se hace utilizando la anotación @Bean, que indica que el método myPasswordEncoder() crea y configura el objeto de codificador de contraseñas
// y lo devuelve como un bean de Spring.
//
//El objeto BCryptPasswordEncoder se utiliza para codificar las contraseñas de los usuarios de la aplicación, lo que ayuda a mantener la seguridad de la información confidencial.
// Al utilizar la codificación de contraseñas, incluso si un atacante accede a la base de datos de contraseñas de la aplicación,
// no podrá leer las contraseñas en texto sin formato. En su lugar, solo verá la versión codificada de las contraseñas, lo que dificulta la obtención de la contraseña real.