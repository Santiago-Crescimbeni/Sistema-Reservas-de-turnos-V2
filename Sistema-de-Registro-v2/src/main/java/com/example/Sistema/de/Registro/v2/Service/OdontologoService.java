package com.example.Sistema.de.Registro.v2.Service;



import com.example.Sistema.de.Registro.v2.Entity.Odontologo;
import com.example.Sistema.de.Registro.v2.Entity.Paciente;
import com.example.Sistema.de.Registro.v2.Exception.DataInvalidException;
import com.example.Sistema.de.Registro.v2.Exception.ResourceNotFoundException;
import com.example.Sistema.de.Registro.v2.Repository.OdontologoRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

//la clase "OdontologoService" proporciona una capa de abstracción entre la aplicación y la base de datos,
// permitiendo a los usuarios realizar operaciones CRUD en objetos "Odontologo" de manera fácil y segura.


//La anotación "@Service" indica que esta clase es un componente de servicio y puede ser administrada por un contenedor de Spring.

@Service
public class OdontologoService {

    //La clase tiene un campo odontologoRepository que se inicializa mediante inyección de dependencia a través del constructor con la anotación @Autowired,
    // que utiliza el repositorio OdontologoRepository.


    private OdontologoRepository odontologoRepository;


    @Autowired
    public OdontologoService(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }




    //agregarOdontologo: recibe un objeto Odontologo, verifica que los campos nombre, apellido y matricula no estén vacíos,
    // y si están completos, guarda el objeto en la base de datos utilizando el odontologoRepository.
    public Odontologo agregarOdontologo (Odontologo odontologo)throws DataInvalidException {
        if (odontologo.getNombre().isEmpty()||odontologo.getApellido().isEmpty()||odontologo.getMatricula().isEmpty()){
            throw new DataInvalidException("Error. Alguno de los campos de registro de Odontologo  se encuentran incompleto");
        }else{
            return  odontologoRepository.save(odontologo);
        }

    }



    //listarOdontologo: recibe un id de tipo Long, busca un objeto Odontologo en la base de datos con ese id utilizando el odontologoRepository,
    // y si lo encuentra, devuelve un objeto Optional con el Odontologo buscado. Si no lo encuentra, lanza una excepción ResourceNotFoundException.
    public Optional<Odontologo> listarOdontologo (Long id) throws ResourceNotFoundException {
        Optional<Odontologo> OdontologoABuscar=odontologoRepository.findById(id);
        if (OdontologoABuscar.isPresent()){
            return  odontologoRepository.findById(id);
        }else {
            throw new ResourceNotFoundException("Error. No se encontro el Odontologo Buscado");
        }

    }


    //modificarOdontologo: recibe un objeto Odontologo, busca un objeto Odontologo en la base de datos con el id del objeto recibido utilizando el odontologoRepository,
    // y si lo encuentra, guarda el objeto recibido en la base de datos utilizando el odontologoRepository. Si no lo encuentra, lanza una excepción ResourceNotFoundException.

    public Odontologo modificarOdontologo (Odontologo odontologo)throws ResourceNotFoundException{
        Optional<Odontologo> pacienteaModificar= odontologoRepository.findById(odontologo.getId());
        if (pacienteaModificar.isPresent()){
            return  odontologoRepository.save(odontologo);
        }else {
            throw new ResourceNotFoundException("Error. No se encontro el odontologo para actualizar");
        }

    }



    //eliminarOdontologo: recibe un id de tipo Long, busca un objeto Odontologo en la base de datos con ese id utilizando el odontologoRepository,
    // y si lo encuentra, lo elimina de la base de datos utilizando el odontologoRepository. Si no lo encuentra, lanza una excepción ResourceNotFoundException.
    public void  eliminarOdontologo (Long id)throws ResourceNotFoundException{
        Optional<Odontologo> pacienteAEliminar= odontologoRepository.findById(id);
        if(pacienteAEliminar.isPresent()){
            odontologoRepository.deleteById(id);
        }else {
            throw new ResourceNotFoundException("Error. No se encontro el paciente registrado con el id:  "+ id);
        }

    }




    //listarTodosOdontologo: busca todos los objetos Odontologo en la base de datos utilizando el odontologoRepository y si la lista no está vacía,
    // devuelve la lista de objetos Odontologo. Si la lista está vacía, lanza una excepción ResourceNotFoundException.
    public List<Odontologo> listarTodosOdontologo ()throws ResourceNotFoundException{
        List<Odontologo> todosPacientes = odontologoRepository.findAll();
        if (todosPacientes.isEmpty()){
            throw new ResourceNotFoundException("Error. No se agregaron pacientes, la lista se encuentra vacia");
        }else {
            return todosPacientes;
        }
    }




}
