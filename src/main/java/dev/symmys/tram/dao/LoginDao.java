package dev.symmys.tram.dao;

import dev.symmys.tram.entity.User;

public interface LoginDao {
    public boolean doesUserHaveAccount(String email);

    public int registerUser(User objUser);

    public User getUserByEmail(String email);

    public User getUserByUsername(String userName);
}
