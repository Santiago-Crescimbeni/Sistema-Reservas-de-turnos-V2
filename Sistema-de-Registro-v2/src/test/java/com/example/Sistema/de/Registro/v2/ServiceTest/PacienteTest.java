package com.example.Sistema.de.Registro.v2.ServiceTest;


import com.example.Sistema.de.Registro.v2.Entity.Domicilio;
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
//
//        Domicilio domicilio2 = new Domicilio("ruben", "999", "catal", "viet");
//        Paciente paciente2 = new Paciente("p", "juan", "444555666", LocalDate.of(2023, 3, 2), domicilio2);
//        pacienteService.agregarPaciente(paciente2);
//
//        Domicilio domicilio3 = new Domicilio("libertador", "444", "james craick", "cordoba");
//        Paciente paciente3 = new Paciente("pablo", "baston", "777666", LocalDate.of(2020, 1, 8), domicilio3);
//        pacienteService.agregarPaciente(paciente3);



        // Obtenemos la lista de todos los pacientes
        List<Paciente> pacientesListados = pacienteService.listarTodosPacientes();

        // Verificamos que la lista de pacientes obtenida contenga los mismos pacientes que agregamos anteriormente
        assertEquals(2,pacientesListados.size());

    }



    @Test
    @Order(4)
    public void modificarPaciente() throws ResourceNotFoundException {

        //Crea un nuevo objeto Paciente con datos modificados a través del constructor y
        // lo guarda en la base de datos a través del método modificarPaciente()
        // de la clase PacienteService.


        Domicilio domicilio1=new Domicilio("rubi","123","trompso","oslo");
        Paciente pacienteModificado=new Paciente("p","juan","444555666", LocalDate.of(2023, 3, 2),domicilio1);

        Paciente pacienteModificadoDevuelto= pacienteService.modificarPaciente(pacienteModificado);


        //Verifica que los datos del objeto Paciente devuelto por el método modificarPaciente()
        // son iguales a los datos del objeto Paciente modificado creado en el paso anterior, utilizando el método assertEquals().
        assertEquals(pacienteModificado, pacienteModificadoDevuelto);

        //Verifica que los objetos Paciente devuelto por el método modificarPaciente() y
        // el objeto Paciente modificado creado en el paso anterior son el mismo objeto en memoria, utilizando el método assertTrue().

        assertTrue(pacienteModificado == pacienteModificadoDevuelto);

    }


    @Test
    @Order(5)
    public void eliminarPaciente() throws ResourceNotFoundException {

//        // Crear el paciente
//        Domicilio domicilio1 = new Domicilio("rubi", "123", "trompso", "oslo");
//        Paciente paciente1 = new Paciente("perez", "juan", "444555666", LocalDate.of(2023, 3, 2), domicilio1);
//

        Long id=1L;
        // Verificar que el paciente ha sido creado correctamente
//        Optional<Paciente> pacienteBuscado = pacienteService.listarPaciente(pacienteGuardado.getId());
//        assertTrue(pacienteBuscado.isPresent());

        // Eliminar el paciente
         pacienteService.eliminarPaciente(id);

        // Verificar que el paciente ha sido eliminado correctamente
//        Optional<Paciente> pacienteEliminado = pacienteService.listarPaciente(pacienteGuardado.getId());
        assertTrue(pacienteService.listarPaciente(1L).isEmpty());
    }



}
