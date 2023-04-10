package com.example.Sistema.de.Registro.v2.Service;

import com.example.Sistema.de.Registro.v2.Entity.Usuario;
import com.example.Sistema.de.Registro.v2.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


//@Service  indica que esta clase es un servicio
@Service
public class UsuarioService implements UserDetailsService {


    // declara una instancia de UsuarioRepository
    private UsuarioRepository usuarioRepository;

    //@Autowired  indica que la instancia de UsuarioRepository se inyecta por dependencia
    // constructor que recibe una instancia de UsuarioRepository
    // inicializa la instancia de UsuarioRepository
    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    // busca un Usuario en la base de datos por email
    // si el Usuario fue encontrado
    // devuelve el Usuario encontrado
    // si el Usuario no fue encontrado
    // lanza una excepción informando que el Usuario no fue encontrado
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuarioBuscado = usuarioRepository.findByEmail(username);
        if(usuarioBuscado.isPresent()){
            return usuarioBuscado.get();
        }else {
            throw new UsernameNotFoundException("Error. El usuario con el email "+ username +" no fue encontrado en la base de datos ");
        }
    }
}
