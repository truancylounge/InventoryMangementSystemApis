package com.bakersinn.inventory.dao;

import com.bakersinn.inventory.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Lalith on 9/27/15.
 */
public class UserDao implements UserDaoInterface {

    @Override
    public User getUserByName(String username) {
        System.out.println("Entering UserDao::getUserByName()");
        User user = new User();
        try {
            SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
            dataSource.setDriver(new com.mysql.jdbc.Driver());
            dataSource.setUrl("jdbc:mysql://localhost/inventory");
            dataSource.setUsername("root");
            //dataSource.setPassword("P@ssw0rd");
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            String sql = "select * from users where users where username = ?" ;
            user = jdbcTemplate.queryForObject(sql, new Object[]{username}, new RowMapper<User>() {
                @Override
                public User mapRow(ResultSet resultSet, int i) throws SQLException {
                    User user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setUsername(resultSet.getString("username"));
                    user.setPassword(resultSet.getString("password"));
                    user.setAuthenticated(resultSet.getBoolean("authenticate"));
                    return user;

                }
            });

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return  user;
    }

    @Override
    public User createUser(User user) {
        return null;
    }
}
