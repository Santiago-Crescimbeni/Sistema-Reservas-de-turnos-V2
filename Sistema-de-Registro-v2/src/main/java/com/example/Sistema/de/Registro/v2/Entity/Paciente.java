package com.example.Sistema.de.Registro.v2.Entity;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

////En el contexto de Java Persistence API (JPA), las entidades son objetos que representan tablas de una base de datos relacional
//// y se utilizan para mapear los registros de la tabla en objetos Java.

//define una clase llamada "Paciente" que representa un Paciente.

////La anotación "@Table" se utiliza para especificar el nombre de la tabla que se utilizará para almacenar los registros de la entidad.
@Entity
@Table(name="pacientes")
public class Paciente {

    //La clase tiene los siguientes campos o propiedades:


    //  //La anotación "@Id" se utiliza para indicar que el campo "id" es la clave primaria de la entidad.
    //
    //    //Además, la anotación "@GeneratedValue" se utiliza para indicar cómo se generará el valor de la clave primaria en la base de datos.
    //    // En este caso, se utiliza "GenerationType.IDENTITY"
    //    // que significa que el valor de la clave primaria se generará automáticamente mediante una estrategia específica de la base de datos.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String apellido;
    @Column
    private String nombre;
    @Column
    private String documento;
    @Column
    private LocalDate fechaIngreso;


    // // Define una relación uno-a-uno con otra entidad, y especifica que se deben aplicar todas las operaciones en cascada
    @OneToOne(cascade = CascadeType.ALL)
    // Especifica la columna utilizada para la relación y el nombre de la columna en la tabla
    @JoinColumn(name = "domicilio_id",referencedColumnName = "id")
    private Domicilio domicilio;


    // la anotación "@OneToMany(mappedBy = "equipo", fetch = FetchType.LAZY)" en la clase "Equipo" indica
    // que la lista de jugadores solo se cargará de la base de datos cuando se acceda explícitamente a ella
    // (por ejemplo, al llamar al método "getJugadores()" de la clase "Equipo"). Si la anotación "@OneToMany"
    // se hubiera configurado con "fetch = FetchType.EAGER", los jugadores se cargarían automáticamente cada
    // vez que se carga un equipo de la base de datos, incluso si no se van a utilizar todos los jugadores en ese momento.

    //El parámetro "mappedBy" especifica el nombre del atributo en la clase Turno que hace referencia al ob
    @OneToMany(mappedBy = "paciente",fetch = FetchType.LAZY)
    private Set<Turno> turnos= new HashSet<>();

    //La clase tiene tres constructores:

   //El primer constructor toma todos los campos como argumentos y los inicializa.
    public Paciente(Long id, String apellido, String nombre, String documento, LocalDate fechaIngreso, Domicilio domicilio) {
        this.id = id;
        this.apellido = apellido;
        this.nombre = nombre;
        this.documento = documento;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
    }

    //El segundo constructor toma todos los campos excepto "id" como argumentos y los inicializa.
// Este constructor se utiliza para crear nuevos objetos de "Domicilio" que aún no tienen un "id" asignado.

    public Paciente(String apellido, String nombre, String documento, LocalDate fechaIngreso, Domicilio domicilio) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.documento = documento;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
    }


    //El tercer constructor es un constructor (por defecto)vacío que no toma argumentos.
    // Este constructor se utiliza cuando no se tienen valores para inicializar los campos.
    //Jackson es una biblioteca de Java que se utiliza para convertir objetos Java en JSON y viceversa.
    //Jackson utiliza este constructor de la clase Java para crear objetos y establecer sus valores a partir de datos JSON.
    public Paciente() {
    }



    //También se crean métodos "get" y "set" para cada uno de los campos de la clase, lo que permite acceder y modificar los valores de los campos.

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }


    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                ", documento='" + documento + '\'' +
                ", fechaIngreso=" + fechaIngreso +
                ", domicilio=" + domicilio +'\''+
                '}';
    }
}
