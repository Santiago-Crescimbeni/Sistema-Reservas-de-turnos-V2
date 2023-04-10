package com.example.Sistema.de.Registro.v2.Entity;
//define una clase llamada "Odontologo" que representa un Odontologo.
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//En el contexto de Java Persistence API (JPA), las entidades son objetos que representan tablas de una base de datos relacional
// y se utilizan para mapear los registros de la tabla en objetos Java.

// la clase Odontologo se marca con la anotación "@Entity" para indicar que es una entidad persistente y se puede almacenar en una tabla de una base de datos relaciona
@Entity

//La anotación "@Table" se utiliza para especificar el nombre de la tabla que se utilizará para almacenar los registros de la entidad.
@Table (name="odontologos")
public class Odontologo {

    //La clase tiene los siguientes campos o propiedades:

    //La anotación "@Id" se utiliza para indicar que el campo "id" es la clave primaria de la entidad.

    //Además, la anotación "@GeneratedValue" se utiliza para indicar cómo se generará el valor de la clave primaria en la base de datos.
    // En este caso, se utiliza "GenerationType.IDENTITY"
    // que significa que el valor de la clave primaria se generará automáticamente mediante una estrategia específica de la base de datos.
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private String matricula;


    //está utilizando la anotación @OneToMany de Java Persistence API (JPA) para establecer una relación entre las entidades "Odontologo" y "Turno".
    //La anotación "@OneToMany" indica que un objeto "Odontologo" puede tener muchos objetos "Turno" asociados a él.
    // La propiedad "mappedBy" especifica que la relación inversa se establecerá en el campo "odontologo" de la entidad "Turno".
    // Esto significa que la clave primaria de la entidad "Odontologo" será la clave foránea en la entidad "Turno" y se utilizará para establecer la relación entre ellas.
    //se inicializa como un HashSet vacío para garantizar la unicidad de los objetos "Turno" en la colección.
    @OneToMany(mappedBy = "odontologo")
    private Set<Turno> turnos= new HashSet<>();



    //La clase tiene tres constructores:

    //El primer constructor toma todos los campos como argumentos y los inicializa.

    public Odontologo(Long id, String nombre, String apellido, String matricula) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }


    //El segundo constructor toma todos los campos excepto "id" como argumentos y los inicializa.
// Este constructor se utiliza para crear nuevos objetos de "Domicilio" que aún no tienen un "id" asignado.

    public Odontologo(String nombre, String apellido, String matricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }


    //El tercer constructor es un constructor (por defecto)vacío que no toma argumentos.
    // Este constructor se utiliza cuando no se tienen valores para inicializar los campos.
    //Jackson es una biblioteca de Java que se utiliza para convertir objetos Java en JSON y viceversa.
    //Jackson utiliza este constructor de la clase Java para crear objetos y establecer sus valores a partir de datos JSON.

    public Odontologo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
//También se crean métodos "get" y "set" para cada uno de los campos de la clase, lo que permite acceder y modificar los valores de los campos.



    //se sobrescribe el método toString() de la clase Object y devuelve una representación en forma de cadena del objeto Odontologo.
    //se construye una cadena que incluye los valores de los campos id, nombre, apellido y nroMatricula del objeto Odontologo
    // utilizando la sintaxis de cadena de caracteres de Java.


    @Override
    public String toString() {
        return "Odontologo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", matricula='" + matricula + '\'' +
                '}';
    }
}
