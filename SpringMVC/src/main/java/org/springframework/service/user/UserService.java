package org.springframework.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.UserCourseENtityManager;
import org.springframework.dao.UserEntityManager;
import org.springframework.dao.UserProfileEntityManager;
import org.springframework.model.Course;
import org.springframework.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserEntityManager userEntityManager;

    @Autowired
    UserProfileEntityManager userProfileEntityManager;

    @Autowired
    UserCourseENtityManager userCourseENtityManager;

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

    public User patchUser(User user, Integer id) {
        return userEntityManager.patchUser(user,id);
    }

    public void deleteUser(Integer id) {
        userEntityManager.deleteUser(id);
    }

    public void bicond(Integer id){
        userEntityManager.biDirection(id);
    }

    public void deleteUserProfile(Integer id) {
        userProfileEntityManager.deleteUserProfile(id);
    }

    public Course addUserToCourse(Integer id){
        return userCourseENtityManager.addUserCourse(id);
    }
    public List<Course> getUserCourse(Integer id){
        return userCourseENtityManager.getUserCourse(id);
    }
}
