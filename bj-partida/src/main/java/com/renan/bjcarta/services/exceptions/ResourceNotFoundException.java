package com.renan.bjcarta.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException (Object id){
        super(id + " não encontrado.");
    }

}
