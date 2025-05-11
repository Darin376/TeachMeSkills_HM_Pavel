package com.lesson49.dao;

import com.lesson49.entity.User;

import java.util.List;

public interface UserDAO {
    public List<User> getAllUser();

    public User getUserById(int id);

    public void userSave(User user);

    public void deleteUser(int id);
}
