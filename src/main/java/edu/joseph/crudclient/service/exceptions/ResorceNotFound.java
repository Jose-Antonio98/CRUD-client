package edu.joseph.crudclient.service.exceptions;

public class ResorceNotFound extends RuntimeException{

    public ResorceNotFound(Object id) {
        super("Resource not found. id: " + id);
    }

    public ResorceNotFound() {
        super("Resource not found.");
    }
}
