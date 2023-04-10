package com.example.Sistema.de.Registro.v2.Entity;

//define una clase llamada "Domicilio" que representa un domicilio.


import javax.persistence.*;

////En el contexto de Java Persistence API (JPA), las entidades son objetos que representan tablas de una base de datos relacional
//// y se utilizan para mapear los registros de la tabla en objetos Java.
////La anotación "@Table" se utiliza para especificar el nombre de la tabla que se utilizará para almacenar los registros de la entidad.
@Entity
@Table(name="domicilios")
public class Domicilio {
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
    private String calle;
    @Column
    private String numero;
    @Column
    private String localidad;
    @Column
    private String provincia;


    //La clase tiene tres constructores:
    //
    //El primer constructor toma todos los campos como argumentos y los inicializa.
    public Domicilio(Long id, String calle, String numero, String localidad, String provincia) {
        this.id = id;
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }

//El segundo constructor toma todos los campos excepto "id" como argumentos y los inicializa.
// Este constructor se utiliza para crear nuevos objetos de "Domicilio" que aún no tienen un "id" asignado.

    public Domicilio(String calle, String numero, String localidad, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }


    //El tercer constructor es un constructor (por defecto)vacío que no toma argumentos.
    // Este constructor se utiliza cuando no se tienen valores para inicializar los campos.
    //Jackson es una biblioteca de Java que se utiliza para convertir objetos Java en JSON y viceversa.
    //Jackson utiliza este constructor de la clase Java para crear objetos y establecer sus valores a partir de datos JSON.
    public Domicilio() {
    }



    //También se crean métodos "get" y "set" para cada uno de los campos de la clase, lo que permite acceder y modificar los valores de los campos.
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }


    @Override
    public String toString() {
        return "Domicilio{" +
                "id=" + id +
                ", calle='" + calle + '\'' +
                ", numero='" + numero + '\'' +
                ", localidad='" + localidad + '\'' +
                ", provincia='" + provincia + '\'' +
                '}';
    }
}
