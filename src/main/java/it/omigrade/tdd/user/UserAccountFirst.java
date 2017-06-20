package it.omigrade.tdd.user;

import java.util.Date;

/**
 * <br><br>Created by Omi087 on 19/06/2017.
 */
public class UserAccountFirst {
    private final MyRepository repository;
    private final String username;

    public UserAccountFirst(String username) {
        this.repository = new DBrepository();
        this.username = username;
    }

    public boolean accedi(String password) {
        User user = repository.getUser(username, password);
        if (user == null)
            return false;
        else if (user.scadenza.before(new Date()))
            return false;
        else
            return true;
    }

}
