package com.example.Sistema.de.Registro.v2.Service;
import com.example.Sistema.de.Registro.v2.Dto.TurnoDto;
import com.example.Sistema.de.Registro.v2.Entity.Odontologo;
import com.example.Sistema.de.Registro.v2.Entity.Paciente;
import com.example.Sistema.de.Registro.v2.Entity.Turno;
import com.example.Sistema.de.Registro.v2.Exception.DataInvalidException;
import com.example.Sistema.de.Registro.v2.Exception.ResourceNotFoundException;
import com.example.Sistema.de.Registro.v2.Repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


//Este es un servicio que maneja la lógica de negocio relacionada con la entidad Turno en una aplicación.
// Aquí se definen los métodos para agregar, listar, modificar y eliminar objetos Turno en la base de datos.


//se utiliza la anotación @Service para indicar que esta clase es un servicio que será administrado por el contenedor de Spring.
@Service
public class TurnoService {



   // Se define una variable turnoRepository que será inyectada en el constructor de la clase mediante la anotación @Autowired.
    private TurnoRepository turnoRepository;



    @Autowired
    public TurnoService(TurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }


//En este método se define la lógica para agregar un objeto Turno a la base de datos.
// Si los identificadores del Odontologo y el Paciente en el objeto TurnoDto son nulos, se lanza una excepción DataInvalidException.
// De lo contrario, se convierte el objeto TurnoDto a un objeto Turno y se guarda en la base de datos a través del método save() del repositorio turnoRepository.
// El objeto Turno guardado es convertido a un objeto TurnoDto y devuelto como respuesta.
    public TurnoDto agregarTurno (TurnoDto turnoDto)throws DataInvalidException {

        Turno turnoGuardado;
        if (turnoDto.getOdontologoId() == null || turnoDto.getPacienteId() == null) {
            throw new DataInvalidException("Error. No se puede registrar turno, es necesario registrar un paciente y un odontologo");
        } else {
            turnoGuardado = turnoRepository.save(turnoDTOATurno(turnoDto));
        }
        return turnoATurnoDTO(turnoGuardado);
    }




//Este método busca un turno en la base de datos utilizando su identificador (id).
// Si el turno es encontrado, se convierte a un objeto TurnoDto y se devuelve como un Optional<TurnoDto>.
// Si el turno no es encontrado, se lanza una excepción ResourceNotFoundException.


    public Optional<TurnoDto> listarTurnoOptional(Long id) throws ResourceNotFoundException {
        Optional<Turno> turnoListado= turnoRepository.findById(id);
        if (turnoListado.isPresent()){
            return Optional.of(turnoATurnoDTO(turnoListado.get()));
        }else {
//
            throw new ResourceNotFoundException("Error. Turno no encontrado, se requiere revisar el registro del mismo ");
        }

    }



    //Este método busca un turno en la base de datos utilizando su identificador (id).
    // Si el turno es encontrado, se convierte el objeto TurnoDto a un objeto Turno y se guarda en la base de datos a través del método save() del repositorio turnoRepository.
    // Si el turno no es encontrado, se lanza una excepción ResourceNotFoundException.
    //de lo contrario se modifica


    public void modificarTurno (TurnoDto turnoDto)throws ResourceNotFoundException{
       Optional<Turno> turnoAModificar=turnoRepository.findById(turnoDto.getId());
       if (turnoAModificar.isPresent()){
           turnoRepository.save(turnoDTOATurno(turnoDto));
       }else {
           throw new ResourceNotFoundException("Error. No se puede modificar el turno, revisar registro del mismo ");
       }

    }




    //Este método busca un turno en la base de datos utilizando su identificador (id).
    // Si el turno es encontrado, se elimina de la base de datos.
    // Si el turno no es encontrado, se lanza una excepción ResourceNotFoundException.
    public void  eliminarTurno (Long id) throws ResourceNotFoundException {

        Optional<TurnoDto> tuernoAEliminar= listarTurnoOptional(id);
        if(tuernoAEliminar.isPresent()){
            throw new ResourceNotFoundException("Error. No se puede eliminar el turno, no existe en el registro");
        }else {
            turnoRepository.deleteById(id);
        }

    }

    //Este método lista todos los turnos registrados en la base de datos. Si la lista de turnos está vacía, se lanza una excepción ResourceNotFoundException.
    // Si hay turnos en la lista, se convierte cada turno a un objeto TurnoDto y se devuelve como una lista de objetos TurnoDto.
    public List<TurnoDto> listarTodosTurno () throws ResourceNotFoundException{

        List<Turno> turnoEncontrado= turnoRepository.findAll();
        List<TurnoDto> respuesta= new ArrayList<>();
        if (turnoEncontrado.isEmpty()){
            throw new ResourceNotFoundException("Error. No existe ningun turno registrado");
        }else {
            for (Turno turno : turnoEncontrado) {
                respuesta.add(turnoATurnoDTO(turno));
            }
            return respuesta ;
        }

    }



    //Este método convierte un objeto Turno a un objeto TurnoDto. Se carga la información de turno al turno DTO y se devuelve como respuesta.

    private TurnoDto turnoATurnoDTO(Turno turno){
        //convertir el turno a un turnoDTO
        TurnoDto respuesta= new TurnoDto();
        //cargar la información de turno al turno DTO
        respuesta.setId(turno.getId());
        respuesta.setPacienteId(turno.getPaciente().getId());
        respuesta.setNombrePaciente(turno.getPaciente().getNombre());
        respuesta.setOdontologoId(turno.getOdontologo().getId());
        respuesta.setNombreOdontologo(turno.getOdontologo().getNombre());
        respuesta.setFecha(turno.getFecha());
        //devolución
        return respuesta;
    }


    //Este método convierte un objeto TurnoDto a un objeto Turno. Se carga la información de turno DTO al turno y se devuelve como respuesta.

    private Turno turnoDTOATurno(TurnoDto turnodto){
        Turno respuesta= new Turno();
        //cargar la información de turno DTO al turno
        Odontologo odontologo= new Odontologo();
        Paciente paciente= new Paciente();
        odontologo.setId(turnodto.getOdontologoId());
        odontologo.setNombre(turnodto.getNombreOdontologo());
        paciente.setId(turnodto.getPacienteId());
        paciente.setNombre(turnodto.getNombrePaciente());
        respuesta.setFecha(turnodto.getFecha());
        respuesta.setId(turnodto.getId());
        //no debemos olvidarnos de agregar ambos objetos
        respuesta.setOdontologo(odontologo);
        respuesta.setPaciente(paciente);
        //salida
        return respuesta;
    }







}
