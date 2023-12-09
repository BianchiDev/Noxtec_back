package com.noxtec.noxtec.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ResourceNotFoundExcpition extends RuntimeException {
    public ResourceNotFoundExcpition(String menssage) {
        super(menssage);
    }
}
