package com.example.Sistema.de.Registro.v2.Entity;


import javax.persistence.*;
import java.time.LocalDate;


////En el contexto de Java Persistence API (JPA), las entidades son objetos que representan tablas de una base de datos relacional
//// y se utilizan para mapear los registros de la tabla en objetos Java.
//define una clase llamada "Turno" que representa un Turno.

////La anotación "@Table" se utiliza para especificar el nombre de la tabla que se utilizará para almacenar los registros de la entidad.
@Entity
@Table(name="turnos")
public class Turno {
    //La clase tiene los siguientes campos o propiedades:

    //  //La anotación "@Id" se utiliza para indicar que el campo "id" es la clave primaria de la entidad.
    //
    //    //Además, la anotación "@GeneratedValue" se utiliza para indicar cómo se generará el valor de la clave primaria en la base de datos.
    //    // En este caso, se utiliza "GenerationType.IDENTITY"
    //    // que significa que el valor de la clave primaria se generará automáticamente mediante una estrategia específica de la base de datos.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // // Define una relación muchos-a-uno con otra entidad
    @ManyToOne
    //Especifica la columna utilizada para la relación y el nombre de la columna en la tabla
    @JoinColumn(name = "paciente_id",referencedColumnName = "id")
    private Paciente paciente;

    // Define una relación muchos-a-uno con otra entidad
    @ManyToOne
    // Especifica la columna utilizada para la relación y el nombre de la columna en la tabla
    @JoinColumn(name = "odontologos_id" , referencedColumnName = "id")
    private Odontologo odontologo;

    @Column
    private LocalDate fecha;


    //La clase tiene tres constructores:

    //El primer constructor toma todos los campos como argumentos y los inicializa.
    public Turno(Long id, Paciente paciente, Odontologo odontologo, LocalDate fecha) {
        this.id = id;
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.fecha = fecha;
    }


    //El segundo constructor toma todos los campos excepto "id" como argumentos y los inicializa.
// Este constructor se utiliza para crear nuevos objetos de "Turnos" que aún no tienen un "id" asignado.
    public Turno(Paciente paciente, Odontologo odontologo, LocalDate fecha) {
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.fecha = fecha;
    }

    //El tercer constructor es un constructor (por defecto)vacío que no toma argumentos.
    // Este constructor se utiliza cuando no se tienen valores para inicializar los campos.


    public Turno() {
    }

    public Turno(Odontologo odontologo, Paciente paciente, LocalDate of) {
    }


    //También se crean métodos "get" y "set" para cada uno de los campos de la clase, lo que permite acceder y modificar los valores de los campos.

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Turno{" +
                "id=" + id +
                ", paciente=" + paciente +
                ", odontologo=" + odontologo +
                ", fecha=" + fecha +
                '}';
    }
}
