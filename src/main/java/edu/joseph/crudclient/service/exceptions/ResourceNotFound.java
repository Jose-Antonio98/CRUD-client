package edu.joseph.crudclient.service.exceptions;

public class ResourceNotFound extends RuntimeException{

    public ResourceNotFound(Object id) {
        super("Resource not found. id: " + id);
    }

    public ResourceNotFound() {
        super("Resource not found.");
    }
}
