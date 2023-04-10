package com.example.Sistema.de.Registro.v2.Security;

import com.example.Sistema.de.Registro.v2.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// La anotación @Configuration indica que esta clase es una clase de configuración de Spring @Configuration
// La anotación @EnableWebSecurity se utiliza para habilitar la seguridad web en la aplicación


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    // La anotación @Autowired se utiliza para inyectar las dependencias del servicio de usuario y el codificador de contraseña

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // Este método se utiliza para configurar el proveedor de autenticación de la aplicación
    // Se configura el proveedor de autenticación para que utilice el proveedor personalizado proporcionado por el método daoAuthenticationProvider()
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

       auth.authenticationProvider(daoAuthenticationProvider());
    }


    // Este método se utiliza para configurar la seguridad HTTP en la aplicación
    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http
               // Se deshabilita la protección CSRF
               .csrf().disable()
               // Se configura la autorización de solicitudes
               .authorizeRequests()
               // Se especifican las URL que solo pueden ser accedidas por usuarios con los roles USER o ADMIN
               .antMatchers( "/altasTurnos.html").hasAnyRole("USER","ADMIN")
               // Se especifican las URL que solo pueden ser accedidas por usuarios con el rol ADMIN
               .antMatchers("/altaOdontologo.html", "/listarOdontologo.html", "/altaPacientes.html","/listarPacientes.html", "/listarTurnos.html").hasRole("ADMIN")
               // Se especifica que cualquier otra solicitud requiere autenticación
               .anyRequest().authenticated()
               .and()
               // Se habilita el formulario de inicio de sesión
               .formLogin()
               .and()
               // Se habilita la funcionalidad de cierre de sesión
               .logout();

    }


    // Este método crea y configura un objeto DaoAuthenticationProvider que se utiliza para autenticar a los usuarios

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider (){
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
        // Se establece el servicio de usuario personalizado para recuperar los detalles del usuario durante la autenticación
        provider.setUserDetailsService(usuarioService);
        // Se establece el codificador de contraseñas para el proveedor de autenticación
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
    }
}
