package it.omigrade.tdd.template;

/**
 * <br><br>Created by Omi087 on 19/06/2017.
 */
public class MissingParamsException extends Exception{

    public MissingParamsException() {
        super("Almeno un parametro non è stato valorizzato");
    }
}
