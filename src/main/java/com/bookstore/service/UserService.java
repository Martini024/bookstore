package com.bookstore.service;

import com.bookstore.model.User;

import java.util.List;

public interface UserService {

    public abstract void createUser(User user);

    public abstract void updateUser(String id, User user);

    public abstract void deleteUser(String id);

    public abstract List<User> getAllUsers();

    public abstract User getUserById(String id);

}
