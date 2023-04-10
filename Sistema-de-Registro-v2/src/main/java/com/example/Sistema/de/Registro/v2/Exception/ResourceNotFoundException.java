package com.example.Sistema.de.Registro.v2.Exception;


//public class ResourceNotFoundException extends Exception: Esta es una clase pública llamada ResourceNotFoundException que extiende la clase Exception.
//
//public ResourceNotFoundException(String message): Este es un constructor público que acepta un mensaje como parámetro.
// El mensaje se pasa a la superclase Exception, que es responsable de almacenarlo y proporcionarlo cuando se arroja la excepción.
//
//El propósito de esta clase es representar una excepción que se lanza cuando no se encuentra un recurso específico.
// Esta excepción puede ser útil en aplicaciones web o servicios web RESTful cuando se intenta acceder a un recurso que no existe,
// por ejemplo, cuando se accede a una URL incorrecta o se busca un objeto que no está presente en la base de datos.


public class ResourceNotFoundException extends Exception{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
