package br.com.nord.exception;

import com.auth0.jwt.exceptions.JWTDecodeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalErrorHandlerAdvice {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<DefaultErrorMessage> handleNotFoundException(NotFoundException ex) {
        var errorResponse = new DefaultErrorMessage(HttpStatus.NOT_FOUND.value(), ex.getReason());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<DefaultErrorMessage> handleNotFoundException(MethodArgumentNotValidException ex) {
        var defaultMessage = ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
        var errorResponse = new DefaultErrorMessage(HttpStatus.BAD_REQUEST.value(), defaultMessage);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<DefaultErrorMessage> handleUsernameNotFoundException(UsernameNotFoundException ex) {
        var errorResponse = new DefaultErrorMessage(HttpStatus.FORBIDDEN.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errorResponse);
    }

    @ExceptionHandler(JWTDecodeException.class)
    public ResponseEntity<DefaultErrorMessage> handleJWTDecodeException(JWTDecodeException ex) {
        var errorResponse = new DefaultErrorMessage(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(TokenCreationException.class)
    public ResponseEntity<DefaultErrorMessage> handleJWTDecodeException(TokenCreationException ex) {
        var errorResponse = new DefaultErrorMessage(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

}
