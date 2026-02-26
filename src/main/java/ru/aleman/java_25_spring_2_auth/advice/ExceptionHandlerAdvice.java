package ru.aleman.java_25_spring_2_auth.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.aleman.java_25_spring_2_auth.exception.InvalidCredentials;
import ru.aleman.java_25_spring_2_auth.exception.UnauthorizedUser;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    // на InvalidCredentials он должен отсылать обратно клиенту HTTP-статус с кодом 400
    // и телом в виде сообщения из exception;
    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> handlerInvalidCredentials(InvalidCredentials ex) {
        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // на UnauthorizedUser он должен отсылать обратно клиенту HTTP-статус с кодом 401
    // и телом в виде сообщения из exception и писать в консоль сообщение из exception.
    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> handlerUnauthorizedUser(UnauthorizedUser ex) {
        System.out.println(String.format("Exception UnauthorizedUser : %s", ex.getMessage()));
        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}
