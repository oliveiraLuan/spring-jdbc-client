package luandeoliveira.springjdbcclient.controllers.exceptions;

import org.springframework.http.HttpStatus;

import java.time.Instant;

public record StandardError(String message, Integer status, String error, String path, Instant timestamp) {
}
