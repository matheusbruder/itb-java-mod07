package br.com.mpbruder.tutoriais.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class TutorialExceptionHandler extends ResponseEntityExceptionHandler {

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

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ExceptionDetails> handlerDataIntegrityViolationException(DataIntegrityViolationException ex) {
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .title("Invalid data")
                        .message("One or more values provided violate integrity rules")
                        .timestamp(LocalDateTime.now())
                        .build()
                , HttpStatus.BAD_REQUEST
        );
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        List<FieldError> errors = ex.getFieldErrors();
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .title("Invalid parameters")
                        .message("One or more fields with invalid values")
                        .fields(errors.stream().map(FieldError::getField).collect(Collectors.joining("; ")))
                        .fieldsMessages(errors.stream().map(FieldError::getDefaultMessage)
                                .collect(Collectors.joining("; ")))
                        .timestamp(LocalDateTime.now())
                        .build(),
                status
        );
    }
}
