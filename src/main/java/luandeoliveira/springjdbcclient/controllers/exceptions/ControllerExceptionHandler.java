package luandeoliveira.springjdbcclient.controllers.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import luandeoliveira.springjdbcclient.services.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<StandardError> userNotFoundException(HttpServletRequest servletRequest, UserNotFoundException e){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new StandardError("Usuário não encontrado.", HttpStatus.NOT_FOUND.value(), e.getMessage(), servletRequest.getServletPath(), Instant.now()));
    }
}
