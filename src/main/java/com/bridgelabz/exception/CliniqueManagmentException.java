package com.bridgelabz.exception;

public class CliniqueManagmentException extends Exception{
    public enum TypeOfException{
        INVALID_AVAILABILITY,APPOINTMENT_FULL;
    }

    public TypeOfException type;

    public CliniqueManagmentException(String message, TypeOfException type) {
        super(message);
        this.type = type;
    }
}
