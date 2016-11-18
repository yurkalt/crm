package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.model.User;
import project.model.UserDao;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by slava23 on 10/11/2016.
 */

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User getUserById(int id){
        return userDao.findOne(id);
    }

    public User getUserByName(String name){
        return userDao.findByUsername(name);
    }

    public User createUser(int id, String name){
        return userDao.save(new User(id, name));
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
