package br.com.bravi.util;

public class PersonBadRequest extends RuntimeException {

    public PersonBadRequest(String msg) {
        super("Parameter is null or empty: " + msg);
    }
}
