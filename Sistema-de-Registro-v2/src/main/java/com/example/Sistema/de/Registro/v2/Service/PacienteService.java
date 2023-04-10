package com.example.Sistema.de.Registro.v2.Service;


import com.example.Sistema.de.Registro.v2.Entity.Paciente;
import com.example.Sistema.de.Registro.v2.Exception.DataInvalidException;
import com.example.Sistema.de.Registro.v2.Exception.ResourceNotFoundException;
import com.example.Sistema.de.Registro.v2.Repository.PacienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


// "PacienteService" proporciona una capa de abstracción entre la aplicación y la base de datos,
// permitiendo a los usuarios realizar operaciones CRUD en objetos "Paciente" de manera fácil y segura.




//La anotación "@Service" indica que esta clase es un componente de servicio y puede ser administrada por un contenedor de Spring.
@Service
public class PacienteService {


    //Se declara una variable de instancia llamada pacienteRepository que se utilizará para acceder a la capa de persistencia de datos.
    private PacienteRepository pacienteRepository;


    //Se define un constructor que recibe una instancia de PacienteRepository como parámetro.
    //La anotación @Autowired se utiliza para inyectar la dependencia de PacienteRepository en el constructor de PacienteService.
    //El constructor asigna el valor del parámetro pacienteRepository a la variable de instancia pacienteRepository. Esto se conoce como inyección de dependencia.
    @Autowired
    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }




    //El método agregarPaciente recibe un objeto Paciente como parámetro y lo guarda en la base de datos utilizando el método save del repositorio pacienteRepository.
    // Antes de guardar, realiza una validación de los campos del paciente y lanza una excepción DataInvalidException si alguno de ellos está vacío o nulo.
      public Paciente agregarPaciente (Paciente paciente)throws DataInvalidException {
        if (paciente.getDomicilio() == null|| paciente.getNombre().isEmpty()|| paciente.getDocumento().isEmpty()|| paciente.getApellido().isEmpty()|| paciente.getFechaIngreso() == null){
            throw new DataInvalidException("Error. Alguno de los campos de registro del paciente  se encuentran incompleto");
        }else{
            return  pacienteRepository.save(paciente);
        }
    }



//El método listarPaciente recibe un parámetro id de tipo Long que identifica al paciente que se quiere buscar en la base de datos.
// Utiliza el método findById del repositorio pacienteRepository para buscar el paciente.
// Si lo encuentra, devuelve un objeto Optional con el paciente encontrado. Si no lo encuentra, lanza una excepción ResourceNotFoundException.
    public Optional<Paciente> listarPaciente (Long id) throws ResourceNotFoundException{
        Optional<Paciente> pacienteABuscar=pacienteRepository.findById(id);
        if (pacienteABuscar.isPresent()){
            return  pacienteRepository.findById(id);
        }else {
            throw new ResourceNotFoundException("Error. No se encontro el paciente Buscado");
        }

    }


    //El método modificarPaciente recibe un objeto Paciente como parámetro y lo actualiza en la base de datos utilizando el método save del repositorio pacienteRepository.
    // Antes de actualizar, busca el paciente en la base de datos utilizando el método findById del repositorio y si lo encuentra, lo actualiza.
    // Si no lo encuentra, lanza una excepción ResourceNotFoundException.
    public Paciente modificarPaciente (Paciente paciente)throws ResourceNotFoundException{
        Optional<Paciente> pacienteaModificar= pacienteRepository.findById(paciente.getId());
        if (pacienteaModificar.isPresent()){
            return  pacienteRepository.save(paciente);
        }else {
            throw new ResourceNotFoundException("Error. No se encontro el paciente para actualizar");
        }

    }



    //El método eliminarPaciente recibe un parámetro id de tipo Long que identifica al paciente que se quiere eliminar de la base de datos.
    // Utiliza el método findById del repositorio pacienteRepository para buscar el paciente.
    // Si lo encuentra, utiliza el método deleteById del repositorio para eliminarlo. Si no lo encuentra, lanza una excepción ResourceNotFoundException.
    public void  eliminarPaciente (Long id) throws ResourceNotFoundException {
        Optional<Paciente> pacienteAEliminar= pacienteRepository.findById(id);
        if(pacienteAEliminar.isPresent()){
            pacienteRepository.deleteById(id);
        }else {
            throw new ResourceNotFoundException("Error. No se encontro el paciente registrado con el id:  "+ id);
        }

    }


//El método listarTodosPacientes busca todos los pacientes registrados en la base de datos utilizando el método findAll del repositorio pacienteRepository.
// Si encuentra pacientes, devuelve una lista de objetos Paciente. Si la lista está vacía, lanza una excepción ResourceNotFoundException.
    public List<Paciente>  listarTodosPacientes ()throws ResourceNotFoundException{
        List<Paciente> todosPacientes = pacienteRepository.findAll();
        if (todosPacientes.isEmpty()){
            throw new ResourceNotFoundException("Error. No se agregaron pacientes, la lista se encuentra vacia");
        }else {
           return todosPacientes;
        }

    }


}
