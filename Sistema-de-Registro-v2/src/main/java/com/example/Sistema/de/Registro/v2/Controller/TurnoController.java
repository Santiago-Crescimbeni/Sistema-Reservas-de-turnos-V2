package com.example.Sistema.de.Registro.v2.Controller;

import com.example.Sistema.de.Registro.v2.Dto.TurnoDto;
import com.example.Sistema.de.Registro.v2.Exception.DataInvalidException;
import com.example.Sistema.de.Registro.v2.Exception.ResourceNotFoundException;
import com.example.Sistema.de.Registro.v2.Service.OdontologoService;
import com.example.Sistema.de.Registro.v2.Service.PacienteService;
import com.example.Sistema.de.Registro.v2.Service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

//define un controlador para manejar solicitudes HTTP relacionadas con la entidad "Turnos"
//@RestController se utiliza para definir una clase que maneja las solicitudes HTTP de entrada y devuelve una respuesta HTTP de salida en formato JSON o XML.


// @RequestMapping("/turnos")  se utiliza para asignar URLs a métodos específicos dentro de una clase controladora. Al agregar @RequestMapping("/turnos")
//en la declaración de clase del controlador,
//se indica que todas las solicitudes que comiencen con /turnos se manejarán en la clase pacientesController.


@RestController
@RequestMapping("/turnos")
public class TurnoController {


    //La clase tiene tres campos privados: turnoService, pacienteService y odontologoService,
    // que se inicializan mediante la inyección de dependencias en el constructor de la clase.


    private TurnoService turnoService;
    private PacienteService pacienteService;
    private OdontologoService odontologoService;


    //@Autowired es una de las formas en que se puede inyectar una dependencia en Spring Framework
    //se utiliza para permitir que Spring resuelva y cree automáticamente una instancia de una clase o interfaz, que se puede utilizar en el componente actual.
    //Constructor con parámetros para crear un nuevo turno.

    @Autowired
    public TurnoController(TurnoService turnoService, PacienteService pacienteService, OdontologoService odontologoService) {
        this.turnoService = turnoService;
        this.pacienteService = pacienteService;
        this.odontologoService = odontologoService;
    }




// El método registrarTurno() maneja una solicitud POST HTTP en la URL base /, que crea un nuevo turno utilizando la información proporcionada en el cuerpo de la solicitud.
// El objeto TurnoDto que se proporciona en el cuerpo de la solicitud se convierte en un objeto Turno y se agrega a través del servicio de turno.
// Si se realiza con éxito, el método devuelve un objeto ResponseEntity con el código de estado HTTP 200 OK y el objeto TurnoDto del turno recién creado.

    @PostMapping
    public     ResponseEntity<TurnoDto> registrarTurno(@RequestBody TurnoDto turno) throws DataInvalidException {
            return ResponseEntity.ok(turnoService.agregarTurno(turno));
        }


//El método listarTurno() maneja una solicitud GET HTTP en la URL /{id}, que busca y devuelve un turno específico según el ID proporcionado en la URL.
// El ID del turno se proporciona como una variable de ruta en la URL.
// Si el turno se encuentra, el método devuelve un objeto ResponseEntity con el código de estado HTTP 200 OK y el objeto TurnoDto correspondiente al turno buscado.


    @GetMapping("/{id}")
    public ResponseEntity<TurnoDto> listarTurno(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<TurnoDto> turnoBuscado= turnoService.listarTurnoOptional(id);

            return ResponseEntity.ok(turnoBuscado.get());


    }



//El método listarTodosTurnos() maneja una solicitud GET HTTP en la URL base /, que devuelve una lista de todos los turnos registrados.
// El método devuelve un objeto ResponseEntity con el código de estado HTTP 200 OK y una lista de objetos TurnoDto que representan los turnos registrados.

    @GetMapping
    public ResponseEntity<List<TurnoDto>> listarTodosTurnos() throws ResourceNotFoundException {
        return ResponseEntity.ok(turnoService.listarTodosTurno());
    }





//El método eliminarTurno() maneja una solicitud DELETE HTTP en la URL /{id}, que elimina un turno específico según el ID proporcionado en la URL.
// El ID del turno se proporciona como una variable de ruta en la URL.
// Si el turno se elimina correctamente, el método devuelve un objeto ResponseEntity con el código de estado HTTP 200 OK y un mensaje de confirmación.
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarTurno(@PathVariable Long id) throws ResourceNotFoundException {

            turnoService.eliminarTurno(id);
            return ResponseEntity.ok("Se eliminó el turno" +
                    " con id= " + id);

    }



//El método actualizarTurno() maneja una solicitud PUT HTTP en la URL base /,
// que actualiza un turno existente utilizando la información proporcionada en el cuerpo de la solicitud.
// El objeto TurnoDto que se proporciona en el cuerpo de la solicitud se convierte en un objeto Turno y se actualiza a través del servicio de turno.
// Si se realiza con éxito, el método devuelve un objeto ResponseEntity con el código de estado HTTP 200 OK y un mensaje de confirmación.

    @PutMapping()
    public ResponseEntity<String> actualizarTurno(@RequestBody TurnoDto turno) throws ResourceNotFoundException {
            turnoService.modificarTurno(turno);
            return ResponseEntity.ok("Se actualizó el turno con id= " + turno.getId());

    }





}
