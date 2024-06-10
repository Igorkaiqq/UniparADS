package org.example.pdvapi.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class ApiException extends Exception {

    private List<String> errors;

    public ApiException(List<String> errors) {
        this.errors = errors;
    }

    public ApiException(String error) {
        this.errors = Arrays.asList(error);
    }

}
