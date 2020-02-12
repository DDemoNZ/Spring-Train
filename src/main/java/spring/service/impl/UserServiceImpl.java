package spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.dao.impl.UserDaoImpl;
import spring.model.User;
import spring.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDaoImpl userDaoImpl;

    @Override
    public void add(User user) {
        userDaoImpl.add(user);
    }

    @Override
    public List<User> listUsers() {
        return userDaoImpl.listUsers();
    }
}
