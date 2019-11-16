package br.com.bravi.util;

public class PersonException extends RuntimeException {

    public PersonException(Integer id){
        super("Person is not found : " + id);
    }
}
