package com.example.Sistema.de.Registro.v2.Exception;

public class DataInvalidException extends Exception{

    //La clase DataInvalidException extiende de la clase Exception, lo que significa que representa una excepción que se produce cuando hay datos inválidos en alguna operación.
    //
    //El constructor de la clase DataInvalidException recibe un mensaje que se mostrará cuando se lance la excepción.
    // El mensaje indica la causa de la excepción y ayuda a entender por qué se produjo.
    //
    //Esta clase se utiliza junto con la anotación @ResponseStatus en los controladores para enviar una respuesta HTTP con
    // el código de estado 400 Bad Request cuando se lanza una excepción DataInvalidException.


    public DataInvalidException(String message) {
        super(message);
    }
}
