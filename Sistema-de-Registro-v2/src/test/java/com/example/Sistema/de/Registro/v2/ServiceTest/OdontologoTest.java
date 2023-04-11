package com.example.Sistema.de.Registro.v2.ServiceTest;
import com.example.Sistema.de.Registro.v2.Entity.Odontologo;
import com.example.Sistema.de.Registro.v2.Exception.DataInvalidException;
import com.example.Sistema.de.Registro.v2.Exception.ResourceNotFoundException;
import com.example.Sistema.de.Registro.v2.Service.OdontologoService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class OdontologoTest {

    @Autowired
    private OdontologoService odontologoService ;

    @Test
    @Order(1)
    public void agregarOdontologo() throws DataInvalidException {

        Odontologo odontologo1= new Odontologo("rafael", "luciano", "123456");

        Odontologo odontologoAgregado= odontologoService.agregarOdontologo(odontologo1);


        Assertions.assertEquals(1L,odontologoAgregado.getId());


    }


    @Test
    @Order(2)
    public void buscarOdontologo() throws ResourceNotFoundException {

        Long id=1L;



        Optional<Odontologo> odontologoBuscado= odontologoService.listarOdontologo(id);

        assertNotNull(odontologoBuscado.get());


    }


    @Test
    @Order(3)
    public void buscarTodosOdontologos () throws DataInvalidException, ResourceNotFoundException {

        Odontologo odontologo1= new Odontologo("pablo","rubeno","5575");

        odontologoService.agregarOdontologo(odontologo1);

        List<Odontologo> odontologosList =odontologoService.listarTodosOdontologo();

        assertEquals(2,odontologosList.size());

    }


    @Test
    @Order(4)
    public void modificarOdontologo() throws ResourceNotFoundException, DataInvalidException {


        Odontologo odontologo= new Odontologo(1L,"rafael", "luciano", "123456");
        Odontologo odontologoGuardado=odontologoService.agregarOdontologo(odontologo);

        Odontologo odontologoModificado= new Odontologo(1L,"ra", "luciano", "123456");

        Odontologo odontologoModificadoDevuelto= odontologoService.modificarOdontologo(odontologoModificado);

        Optional<Odontologo> odontologoBuscado= odontologoService.listarOdontologo(odontologoModificadoDevuelto.getId());
        Assertions.assertEquals(odontologoModificado.getId(),odontologoModificadoDevuelto.getId());

    }


    @Test
    @Order(5)
    public void eliminarOdontologo() throws ResourceNotFoundException, DataInvalidException {
        Odontologo odontologo = new Odontologo("odo1", "apeOdo", "12344");
        odontologoService.agregarOdontologo(odontologo);

        Long id = 1L;
        odontologoService.eliminarOdontologo(id);

        // ya no es necesario buscar el odontologo eliminado
        assertFalse(odontologoService.listarTodosOdontologo().contains(id));

    }
}
