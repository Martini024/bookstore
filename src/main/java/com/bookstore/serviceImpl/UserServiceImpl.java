package com.bookstore.serviceImpl;

import com.bookstore.mapper.UserDao;
import com.bookstore.model.User;
import com.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void createUser(User user) {
        userDao.createUser(user.getId(), user.getName());
    }

    @Override
    public void updateUser(String id, User user) {
        userDao.updateUser(id, user.getName());
    }

    @Override
    public void deleteUser(String id) {
        userDao.deleteUser(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.findAllUsers();
    }

    @Override
    public User getUserById(String id) {
        return userDao.findUserById(id);
    }
}