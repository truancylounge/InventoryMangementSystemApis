package com.bakersinn.inventory.dao;

import com.bakersinn.inventory.model.User;

/**
 * Created by Lalith on 9/27/15.
 */
public interface UserDaoInterface {
    public User getUserByName(String username);
    public User createUser(User user);

}
