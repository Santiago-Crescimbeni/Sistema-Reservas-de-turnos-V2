package com.example.Sistema.de.Registro.v2.Controller;

import com.example.Sistema.de.Registro.v2.Entity.Paciente;
import com.example.Sistema.de.Registro.v2.Exception.DataInvalidException;
import com.example.Sistema.de.Registro.v2.Exception.ResourceNotFoundException;
import com.example.Sistema.de.Registro.v2.Service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


//define un controlador para manejar solicitudes HTTP relacionadas con la entidad "Pacientes"

//@RestController se utiliza para definir una clase que maneja las solicitudes HTTP de entrada y devuelve una respuesta HTTP de salida en formato JSON o XML.


// @RequestMapping("/pacientes")  se utiliza para asignar URLs a métodos específicos dentro de una clase controladora. Al agregar @RequestMapping("/pacientes")
//en la declaración de clase del controlador,
//se indica que todas las solicitudes que comiencen con /pacientes se manejarán en la clase pacientesController.

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    //Utiliza un Servicio de pacientes
    private PacienteService pacienteService;


    //@Autowired es una de las formas en que se puede inyectar una dependencia en Spring Framework
    //se utiliza para permitir que Spring resuelva y cree automáticamente una instancia de una clase o interfaz, que se puede utilizar en el componente actual.
    // Inyecta la dependencia de la clase Service en el controlador
    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }





//El primer método "@PutMapping" recibe una solicitud HTTP con un objeto de tipo Paciente en el cuerpo,
// actualiza los datos del paciente en la base de datos utilizando el servicio "pacienteService.modificarPaciente",
// y devuelve una respuesta HTTP con el objeto Paciente actualizado.

@PutMapping
public ResponseEntity<Paciente> actualizarPaciente(@RequestBody Paciente paciente)throws ResourceNotFoundException{
    Paciente pacienteActualizado = pacienteService.modificarPaciente(paciente);
    return ResponseEntity.ok(pacienteActualizado);
}



//El segundo método "@GetMapping" recibe una solicitud HTTP con un parámetro de ruta que representa el ID de un Paciente,
// busca en la base de datos el Paciente correspondiente utilizando el servicio "pacienteService.listarPaciente",
// y devuelve una respuesta HTTP con el objeto Paciente correspondiente si se encuentra, o devuelve una respuesta HTTP sin contenido si no se encuentra el Paciente.

    @GetMapping ("/{id}")
    public ResponseEntity<Paciente> buscarPaciente(@PathVariable Long id)throws ResourceNotFoundException {
        Optional<Paciente> paciente = pacienteService.listarPaciente(id);
        if(paciente.isPresent()) {
            return ResponseEntity.ok(paciente.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    //El tercer método "@PostMapping" recibe una solicitud HTTP con un objeto de tipo Paciente en el cuerpo,
    // verifica si los campos requeridos están completos, agrega el nuevo Paciente a la base de datos utilizando el servicio "pacienteService.agregarPaciente",
    // y devuelve una respuesta HTTP con el objeto Paciente agregado.

    @PostMapping
    ResponseEntity <Paciente> registrarPaciente(@RequestBody Paciente paciente) throws  DataInvalidException {
        return ResponseEntity.ok(pacienteService.agregarPaciente(paciente)) ;}




    //El cuarto método "@GetMapping" recibe una solicitud HTTP sin parámetros de ruta,
    // busca en la base de datos todos los pacientes utilizando el servicio "pacienteService.listarTodosPacientes",
    // y devuelve una respuesta HTTP con una lista de objetos Paciente correspondientes.
    @GetMapping
    public ResponseEntity<List<Paciente>> buscarTodos()throws ResourceNotFoundException{
        List<Paciente> pacientes = pacienteService.listarTodosPacientes();
        return ResponseEntity.ok(pacientes);
    }




//El quinto método "@DeleteMapping" recibe una solicitud HTTP con un parámetro de ruta que representa el ID de un Paciente,
// busca en la base de datos el Paciente correspondiente utilizando el servicio "pacienteService.eliminarPaciente",
// elimina el Paciente de la base de datos si se encuentra, y devuelve una respuesta HTTP sin contenido.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPaciente(@PathVariable Long id)throws ResourceNotFoundException {
        pacienteService.eliminarPaciente(id);
        return ResponseEntity.noContent().build();
    }


}

