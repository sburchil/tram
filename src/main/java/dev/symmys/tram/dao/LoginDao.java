package dev.symmys.tram.dao;

import dev.symmys.tram.entity.User;

public interface LoginDao {
    public boolean doesUserHaveAccount(String email);
}
