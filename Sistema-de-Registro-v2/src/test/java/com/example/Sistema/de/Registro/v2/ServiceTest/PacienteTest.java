package com.example.Sistema.de.Registro.v2.ServiceTest;


import com.example.Sistema.de.Registro.v2.Entity.Domicilio;
import com.example.Sistema.de.Registro.v2.Entity.Odontologo;
import com.example.Sistema.de.Registro.v2.Entity.Paciente;
import com.example.Sistema.de.Registro.v2.Exception.DataInvalidException;
import com.example.Sistema.de.Registro.v2.Exception.ResourceNotFoundException;
import com.example.Sistema.de.Registro.v2.Service.PacienteService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;



//Se realizan las pruebas unitarias de cada componente para garantizar su efectivo funcionamineto (guardar-buscar-buscar Todos- eliminar- actualizar);
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class PacienteTest {

    @Autowired
    private PacienteService pacienteService;

    @Test
    @Order(1)
    public void guardarPaciente() throws DataInvalidException {


        //se crea un objeto "Domicilio" y un objeto "Paciente" con ciertos datos.
        Domicilio domicilio1=new Domicilio("rubi","123","trompso","oslo");
        Paciente paciente1=new Paciente("perez","juan","444555666", LocalDate.of(2023, 3, 2),domicilio1);

        //Se llama al método "agregarPaciente" de "PacienteService" y se guarda el resultado en una variable "pacienteaGuardar".
       Paciente pacienteaGuardar= pacienteService.agregarPaciente(paciente1);

       //Se verifica que el id del paciente guardado sea 1 mediante el método "assertEquals".
        // Si el id del paciente guardado es igual a 1, el test pasa, de lo contrario, falla.
       assertEquals(1L,pacienteaGuardar.getId());

    }

    @Test
    @Order(2)
    public void buscarPaciente() throws ResourceNotFoundException {
        Long id=1L;

//        Domicilio domicilio1=new Domicilio("rubi","123","trosx","os");
//
//        Paciente paciente1= new Paciente("juan","perez","222222",LocalDate.of(2019,5,1),domicilio1);
//       pacienteService.agregarPaciente(paciente1);
//

        // Se busca el paciente en la base de datos
        Optional<Paciente> pacienteaBuscar= pacienteService.listarPaciente(id);


        // Se verifica que el paciente buscado no sea nulo
        assertNotNull(pacienteaBuscar.get());

    }


    @Test
    @Order(3)
    public void listarTodosPacientes() throws ResourceNotFoundException, DataInvalidException {
        // Creamos algunos pacientes y los agregamos a la base de datos

        Domicilio domicilio1 = new Domicilio("Algala", "111", "vn", "ny");
        Paciente paciente1 = new Paciente("juanciro", "motaner", "111222", LocalDate.of(2022, 3, 1), domicilio1);
        pacienteService.agregarPaciente(paciente1);



        // Obtenemos la lista de todos los pacientes
        List<Paciente> pacientesListados = pacienteService.listarTodosPacientes();

        // Verificamos que la lista de pacientes obtenida contenga los mismos pacientes que agregamos anteriormente
        assertEquals(2,pacientesListados.size());

    }



    @Test
    @Order(4)
    public void modificarPaciente() throws ResourceNotFoundException, DataInvalidException {

        //Crea un nuevo objeto Paciente con datos modificados a través del constructor y
        // lo guarda en la base de datos a través del método modificarPaciente()
        // de la clase PacienteService.


        Domicilio domicilio1=new Domicilio("rubi","123","trompso","oslo");
        Paciente paciente1=new Paciente("pablo","juan","444555666", LocalDate.of(2023, 3, 2),domicilio1);
        Paciente pacienteGuardado= pacienteService.agregarPaciente(paciente1);

        Paciente pacienteModificado= new Paciente(1L,"pa","juan","444555666", LocalDate.of(2023, 3, 2),domicilio1);
        Paciente pacienteModificadoDevuelto= pacienteService.modificarPaciente(pacienteModificado);


       Optional<Paciente> pacienteBuscado= pacienteService.listarPaciente(pacienteModificadoDevuelto.getId());

       Assertions.assertEquals(pacienteModificado.getId(),pacienteModificadoDevuelto.getId());



    }


    @Test
    @Order(5)
    public void eliminarPaciente() throws ResourceNotFoundException, DataInvalidException {

        // Creamos un nuevo paciente y lo agregamos a la base de datos
        Domicilio domicilio1 = new Domicilio("Algala", "111", "vn", "ny");
        Paciente paciente1 = new Paciente("juanciro", "motaner", "111222", LocalDate.of(2022, 3, 1), domicilio1);
        Paciente pacienteGuardado = pacienteService.agregarPaciente(paciente1);

        // Eliminamos el paciente recién agregado
        pacienteService.eliminarPaciente(pacienteGuardado.getId());

        // Verificamos que el paciente haya sido eliminado
        assertThrows(ResourceNotFoundException.class, () -> {
            pacienteService.listarPaciente(pacienteGuardado.getId());
        });

    }



}
