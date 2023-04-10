package com.example.Sistema.de.Registro.v2.Dto;

import java.time.LocalDate;

//Se crea un DTO (Data Transfer Object) para representar una versión simplificada de la entidad Turno,
// con solo los atributos necesarios para ser enviados y recibidos a través de la API REST del sistema.
//
//El uso de DTOs es común en aplicaciones de tres capas, donde la capa de presentación (la interfaz de usuario)
// necesita comunicarse con la capa de servicios (la lógica de negocio), pero no necesita conocer todos los detalles de las entidades de datos subyacentes.
// En lugar de eso, se utilizan DTOs para enviar y recibir solo la información necesaria.


//La clase tiene los siguientes atributos:
public class TurnoDto {


    private Long id;
    private LocalDate fecha;
    private Long pacienteId;
    private String nombrePaciente;
    private Long odontologoId;
    private String nombreOdontologo;



    //La clase define tres constructores: uno vacío y dos que reciben los valores para los atributos del objeto.
    public TurnoDto() {
    }

    public TurnoDto(Long id, LocalDate fecha, Long pacienteId, String nombrePaciente, Long odontologoId, String nombreOdontologo) {
        this.id = id;
        this.fecha = fecha;
        this.pacienteId = pacienteId;
        this.nombrePaciente = nombrePaciente;
        this.odontologoId = odontologoId;
        this.nombreOdontologo = nombreOdontologo;
    }


    public TurnoDto(LocalDate fecha, Long pacienteId, String nombrePaciente, Long odontologoId, String nombreOdontologo) {
        this.fecha = fecha;
        this.pacienteId = pacienteId;
        this.nombrePaciente = nombrePaciente;
        this.odontologoId = odontologoId;
        this.nombreOdontologo = nombreOdontologo;
    }

// la clase proporciona getters y setters para acceder y modificar los atributos, y un método toString() que devuelve una cadena que representa el objeto en forma de texto.

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public Long getOdontologoId() {
        return odontologoId;
    }

    public void setOdontologoId(Long odontologoId) {
        this.odontologoId = odontologoId;
    }



    public String getNombreOdontologo() {
        return nombreOdontologo;
    }

    public void setNombreOdontologo(String nombreOdontologo) {
        this.nombreOdontologo = nombreOdontologo;
    }


    @Override
    public String toString() {
        return "TurnoDto{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", pacienteId=" + pacienteId +
                ", nombrePaciente='" + nombrePaciente + '\'' +
                ", odontologoId=" + odontologoId +
                ", nombreOdontologo='" + nombreOdontologo + '\'' +
                '}';
    }
}
