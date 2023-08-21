package dev.symmys.tram.dao_impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import dev.symmys.tram.dao.LoginDao;
import dev.symmys.tram.entity.User;

@Repository
public class LoginDaoImpl implements LoginDao {

    String CHECK_EXISTING_USER = "SELECT COUNT(*) FROM USERS WHERE user_email = ?";

    @Autowired 
    JdbcTemplate jdbcTemplate;
    
    @Override
    public boolean doesUserHaveAccount(String email) {
        int count = jdbcTemplate.queryForObject(CHECK_EXISTING_USER, new Object[]{email}, Integer.class);
        return (count > 0);
    }
}
