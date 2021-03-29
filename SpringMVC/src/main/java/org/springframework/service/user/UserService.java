package org.springframework.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.UserEntityManager;
import org.springframework.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserEntityManager userEntityManager;

    public User getUser(Integer id){
        return userEntityManager.readUser(id);
    }

    public List<User> getUsers() {
        return userEntityManager.readUsers();
    }

    public User createUser(User user) {
        return userEntityManager.createUser(user);
    }

    public User updateUser(User user) {
        return userEntityManager.updateUser(user);
    }
}
