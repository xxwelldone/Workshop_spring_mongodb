package com.xxwelldone.workshopmongo.service.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(Object id){
        super("Not Found id: " +id);
    }
}
