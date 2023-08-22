package dev.symmys.tram.service;

import dev.symmys.tram.entity.User;

public interface LoginService {
    
    public boolean doesUserHaveAccount(String email);

    public int registerUser(User objUser);

    public User getUserByEmail(String email);
}
