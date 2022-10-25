package br.com.mpbruder.tutoriais.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class TutorialExceptionHandler {

    @ExceptionHandler(InvalidParamException.class)
    public ResponseEntity<ExceptionDetails> handlerInvalidParamException(InvalidParamException ex) {
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .title("Invalid parameter")
                        .message(ex.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build()
                , HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDetails> handlerNotFoundException(NotFoundException ex) {
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .title("Object not found")
                        .message(ex.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build()
                , HttpStatus.BAD_REQUEST
        );
    }

}
