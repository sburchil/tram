package dev.symmys.tram.dao_impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dev.symmys.tram.dao.LoginDao;
import dev.symmys.tram.entity.User;
import dev.symmys.tram.mapper.UserRowMapper;

@Repository
public class LoginDaoImpl implements LoginDao {

    String CHECK_EXISTING_USER = "SELECT COUNT(*) FROM USERS WHERE email = ?";
    String INSERT_NEW_USER = "INSERT INTO users (email, first_name, last_name, created_date, created_by, enabled) VALUES (?, ?, ?, SYSDATE(), 'TramProcess', 0)";
    String GET_USER_BY_EMAIL = "SELECT * FROM users WHERE email = ?";
    String GET_USER_BY_USERNAME = "SELECT * FROM users USR, credentials CRED WHERE (CRED.user_name = ? AND CRED.password = ?) AND USR.user_id = CRED.user_id AND USR.enabled = 1";

    @Autowired 
    JdbcTemplate jdbcTemplate;
    
    @Override
    public boolean doesUserHaveAccount(String email) {
        int count = jdbcTemplate.queryForObject(CHECK_EXISTING_USER, Integer.class, email);
        return (count > 0);
    }

    @Override
    public int registerUser(User objUser) {
        int count = jdbcTemplate.update(INSERT_NEW_USER, objUser.getEmail(), objUser.getFirstName(), objUser.getLastName());
        return count;
    }

    @Override
    public User getUserByEmail(String email) {
        List<User> objUser = jdbcTemplate.query(GET_USER_BY_EMAIL, new UserRowMapper(), email);
        if(objUser.size() > 0){
            return objUser.get(0);
        }
        return null;
    }

    @Override
    public User getUserByUsername(String userName) {
        List<User> objUser = jdbcTemplate.query(GET_USER_BY_USERNAME, new UserRowMapper(), userName);
        if(objUser.size() > 0){
            return objUser.get(0);
        }
        return null;
    }
}
