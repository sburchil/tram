package dev.symmys.tram.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import dev.symmys.tram.entity.User;

public class UserRowMapper implements RowMapper<User> {

    @Override
    @Nullable
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
         User objUser = new User();
         objUser.setUserId(rs.getInt("UserId"));
         objUser.setEmail(rs.getString("UserEmail"));
         objUser.setFirstName(rs.getString("FirstName"));
         objUser.setLastName(rs.getString("LastName"));
         objUser.setAddress(rs.getString("UserAddress"));
        objUser.setDob(rs.getDate("UserDOB"));
        objUser.setCreatedDate(rs.getDate("CreatedDate"));
        objUser.setCreatedBy(rs.getString("CreatedBy"));
         return objUser;
    }
    
}
