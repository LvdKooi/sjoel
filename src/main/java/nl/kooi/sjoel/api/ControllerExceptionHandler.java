package nl.kooi.sjoel.api;

import nl.kooi.sjoel.domain.exception.NotFoundException;
import nl.kooi.sjoel.domain.exception.SjoelpuntenException;
import nl.kooi.sjoel.domain.exception.ValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler({SjoelpuntenException.class, ValidationException.class})
    public ResponseEntity<String> handleSjoelpuntenException(RuntimeException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(NotFoundException exception) {
        return ResponseEntity.status(404).body(exception.getMessage());
    }
}