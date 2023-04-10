package com.example.Sistema.de.Registro.v2.ServiceTest;
import com.example.Sistema.de.Registro.v2.Entity.Domicilio;
import com.example.Sistema.de.Registro.v2.Entity.Odontologo;
import com.example.Sistema.de.Registro.v2.Entity.Paciente;
import com.example.Sistema.de.Registro.v2.Exception.DataInvalidException;
import com.example.Sistema.de.Registro.v2.Exception.ResourceNotFoundException;
import com.example.Sistema.de.Registro.v2.Service.OdontologoService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
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
    public void modificarOdontologo() throws ResourceNotFoundException {


        Odontologo odontologoModificado= new Odontologo("raf", "luciano", "123456");


        Odontologo odontologoModificadoDevuelto= odontologoService.modificarOdontologo(odontologoModificado);


        //Verifica que los datos del objeto Paciente devuelto por el método modificarPaciente()
        // son iguales a los datos del objeto Paciente modificado creado en el paso anterior, utilizando el método assertEquals().
        assertEquals(odontologoModificado, odontologoModificadoDevuelto);

        //Verifica que los objetos Paciente devuelto por el método modificarPaciente() y
        // el objeto Paciente modificado creado en el paso anterior son el mismo objeto en memoria, utilizando el método assertTrue().

        assertTrue(odontologoModificado == odontologoModificadoDevuelto);

    }


    @Test
    @Order(4)
    public void eliminarOdontologo() throws ResourceNotFoundException {

        Long id=1L;

        odontologoService.eliminarOdontologo(id);


        assertTrue(odontologoService.listarOdontologo(1L).isEmpty());


    }
}
