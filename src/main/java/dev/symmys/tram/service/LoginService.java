package dev.symmys.tram.service;

import dev.symmys.tram.entity.User;

public interface LoginService {
    
    public boolean doesUserHaveAccount(String email);
}
