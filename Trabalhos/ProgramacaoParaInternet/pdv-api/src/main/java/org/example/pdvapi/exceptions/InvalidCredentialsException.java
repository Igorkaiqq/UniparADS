package org.example.pdvapi.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class InvalidCredentialsException extends ApiException {

    public InvalidCredentialsException(String error) {
        super(error);
    }

}
