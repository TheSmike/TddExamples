package it.omigrade.tdd.user;

/**
 * <br><br>Created by Omi087 on 19/06/2017.
 */
public class MockRepository implements MyRepository {
    @Override
    public User getUser(String username, String password) {
        return null;
    }
}
