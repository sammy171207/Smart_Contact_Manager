package com.scm.scm.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message){
        super(message);
    }
    public  ResourceNotFoundException(){
        super("Resources Not Found ");
    }

}
