package com.example.Sistema.de.Registro.v2.Exception;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//, este controlador de excepciones global maneja excepciones específicas y devuelve una respuesta HTTP apropiada con un mensaje de error cuando ocurren en toda la aplicación.

//La anotación @ControllerAdvice indica que esta clase se utiliza para manejar excepciones en toda la aplicación.
@ControllerAdvice
public class GlobalException {

    //La clase tiene dos métodos anotados con @ExceptionHandler.
    //La clase también utiliza un objeto Logger para registrar cualquier excepción que se maneje en los métodos.



    //El primer método maneja excepciones de tipo ResourceNotFoundException y devuelve una respuesta de ResponseEntity con un mensaje de error y un estado NOT_FOUND (404).
    Logger logger= Logger.getLogger(GlobalException.class);
    @ExceptionHandler (ResourceNotFoundException.class)
    public ResponseEntity<String> ProcesarRNFE(ResourceNotFoundException ex){
        logger.error(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }



   // El segundo método maneja excepciones de tipo DataInvalidException y devuelve una respuesta de ResponseEntity con un mensaje de error y un estado BAD_REQUEST (400).
    @ExceptionHandler(DataInvalidException.class)
    public ResponseEntity<String> procesaDIE(DataInvalidException ex){
        logger.error(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
