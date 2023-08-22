package dev.symmys.tram.service_impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.symmys.tram.dao.LoginDao;
import dev.symmys.tram.entity.User;
import dev.symmys.tram.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired 
    LoginDao objLoginDao;
    
    @Override
    public boolean doesUserHaveAccount(String email) {
        return objLoginDao.doesUserHaveAccount(email);
    }

    @Override
    public int registerUser(User objUser) {
        return objLoginDao.registerUser(objUser);
    }

    @Override
    public User getUserByEmail(String email) {
        return objLoginDao.getUserByEmail(email);
    }
    
}
