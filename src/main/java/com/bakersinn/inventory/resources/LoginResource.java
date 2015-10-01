package com.bakersinn.inventory.resources;

import com.bakersinn.inventory.dao.UserDao;
import com.bakersinn.inventory.dao.UserDaoInterface;
import com.bakersinn.inventory.model.User;
import org.slf4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by Lalith on 9/27/15.
 */

@Path("/login")
public class LoginResource {
    private static final Logger LOGGER = getLogger(ProductResource.class);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public User createUser(User user) {
        System.out.println("Inside POST Login");
        UserDaoInterface userDao = new UserDao();
        return userDao.createUser(user);

    }

    @POST
    @Path("/authenticate")
    @Consumes(MediaType.APPLICATION_JSON)
    public User authenticateuser(User user) {
        System.out.println("Inside Authenticate POST Login");
        UserDaoInterface userDao = new UserDao();
        User userDb = userDao.getUserByName(user.getUsername());
        if(userDb.getPassword().equals(user.getPassword())) {
            user.setAuthenticated(Boolean.TRUE);
        } else {
            user.setAuthenticated(Boolean.FALSE);
        }

        return user;
    }
}
