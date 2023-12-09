package com.noxtec.noxtec.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.noxtec.noxtec.model.error.ErroMenssage;
import com.noxtec.noxtec.model.exception.ResourceNotFoundExcpition;

@ControllerAdvice
public class RestExceptionHandle {

    @ExceptionHandler(ResourceNotFoundExcpition.class)
    public ResponseEntity<?> handleResouceNotFounExcepition(ResourceNotFoundExcpition ex) {

        ErroMenssage error = new ErroMenssage("Not found", HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
