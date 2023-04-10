package com.example.Sistema.de.Registro.v2.Controller;

import com.example.Sistema.de.Registro.v2.Entity.Odontologo;
import com.example.Sistema.de.Registro.v2.Exception.DataInvalidException;
import com.example.Sistema.de.Registro.v2.Exception.ResourceNotFoundException;
import com.example.Sistema.de.Registro.v2.Service.OdontologoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//define un controlador para manejar solicitudes HTTP relacionadas con la entidad "Odontólogo"

//@RestController se utiliza para definir una clase que maneja las solicitudes HTTP de entrada y devuelve una respuesta HTTP de salida en formato JSON o XML.


// @RequestMapping("/odontologos")  se utiliza para asignar URLs a métodos específicos dentro de una clase controladora. Al agregar @RequestMapping("/odontologos")
//en la declaración de clase del controlador,
//se indica que todas las solicitudes que comiencen con /odontologos se manejarán en la clase OdontologoController.

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    //Utiliza un Servicio de Odontologos mediante la instacia
    private OdontologoService odontologoService;



    //@Autowired es una de las formas en que se puede inyectar una dependencia en Spring Framework
    //se utiliza para permitir que Spring resuelva y cree automáticamente una instancia de una clase o interfaz, que se puede utilizar en el componente actual.
    // Inyecta la dependencia de la clase Service en el controlador
    @Autowired
    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }





//El método buscarOdontologo es un controlador que maneja una solicitud GET en la ruta /odontologos/{id}.
// Recibe un parámetro id que indica el ID del odontólogo a buscar en la base de datos.
// Llama al método listarOdontologo del servicio para buscar el odontólogo con el ID proporcionado.
// Si encuentra el odontólogo, devuelve una respuesta HTTP 200 OK con los detalles del odontólogo en el cuerpo de la respuesta.
// Si no se encuentra el odontólogo, devuelve una respuesta HTTP 400 BAD REQUEST.
    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> buscarOdontologo(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Odontologo> listaOdontologo=odontologoService.listarOdontologo(id);
        if(listaOdontologo.isPresent()){
            return ResponseEntity.ok(listaOdontologo.get());
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }




    //El método actualizarOdontologo es un controlador que maneja una solicitud PUT en la ruta /odontologos.
    // Recibe un objeto JSON que representa los detalles del odontólogo a actualizar.
    // Llama al método modificarOdontologo del servicio para actualizar el registro de odontólogo en la base de datos.
    // Si se actualiza correctamente, devuelve una respuesta HTTP 200 OK con los detalles del odontólogo actualizado en el cuerpo de la respuesta.
    // Si no se puede actualizar el odontólogo, devuelve una respuesta HTTP 400 BAD REQUEST.

      @PutMapping
    public ResponseEntity<Odontologo> actualizarOdontologo(@RequestBody Odontologo odontologo)throws ResourceNotFoundException{
        Odontologo odontologoActualizado = odontologoService.modificarOdontologo(odontologo);
        if (odontologoActualizado != null) {
            return ResponseEntity.ok(odontologoActualizado);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }



//El método buscarTodosOdontologos es un controlador que maneja una solicitud GET en la ruta /odontologos.
// No recibe ningún parámetro y llama al método listarTodosOdontologo del servicio para recuperar una lista de todos los odontólogos registrados en la base de datos.
// Si encuentra al menos un odontólogo, devuelve una respuesta HTTP 200 OK con la lista de odontólogos en el cuerpo de la respuesta.
// Si no hay ningún odontólogo registrado, devuelve una respuesta HTTP 400 BAD REQUEST.

    @GetMapping
    public ResponseEntity<List<Odontologo>> buscarTodosOdontologos() throws ResourceNotFoundException {
        List<Odontologo> listaOdontologos = odontologoService.listarTodosOdontologo();
        return ResponseEntity.ok(listaOdontologos);
    }



//El método eliminarOdontologo es un controlador que maneja una solicitud DELETE en la ruta /odontologos/{id}.
// Recibe un parámetro id que indica el ID del odontólogo a eliminar de la base de datos.
// Llama al método eliminarOdontologo del servicio para eliminar el registro del odontólogo con el ID proporcionado.
// Si se elimina correctamente, devuelve una respuesta HTTP 204 NO CONTENT. Si no se puede eliminar el odontólogo, devuelve una respuesta HTTP 400 BAD REQUEST.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarOdontologo(@PathVariable Long id) throws ResourceNotFoundException {
        odontologoService.eliminarOdontologo(id);
        return ResponseEntity.noContent().build();
    }




    //El método agregarOdontologo es un controlador que maneja una solicitud POST en la ruta /odontologos.
    // Recibe un objeto JSON que representa los detalles del odontólogo a agregar en la base de datos.
    // Llama al método agregarOdontologo del servicio para guardar el nuevo registro de odontólogo en la base de datos.
    // Si se guarda correctamente, devuelve una respuesta HTTP 201 CREATED con los detalles del odontólogo agregado en el cuerpo de la respuesta.
    // Si no se puede agregar el odontólogo, devuelve una respuesta HTTP 400 BAD REQUEST.
    @PostMapping
    public ResponseEntity<Odontologo> agregarOdontologo(@RequestBody Odontologo odontologo) throws DataInvalidException {
        Odontologo odontologoAgregado = odontologoService.agregarOdontologo(odontologo);
        return ResponseEntity.status(HttpStatus.CREATED).body(odontologoAgregado);
    }
}










