package it.omigrade.tdd.user;

/**
 * <br><br>Created by Omi087 on 19/06/2017.
 */
public interface MyRepository {
    User getUser(String username, String password);
}
