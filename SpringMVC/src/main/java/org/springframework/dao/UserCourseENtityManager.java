package org.springframework.dao;

import org.springframework.model.Course;
import org.springframework.model.User;
import org.springframework.model.UserProfile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.logging.Logger;

@Service
public class UserCourseENtityManager {

    Logger log = Logger.getLogger("UserCourseENtityManager");

    public Course addUserCourse(Integer id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        User currentUser = entityManager.find(User.class,id);

        Course course = new Course();
        course.setName("Course 3");
        course.setUser(currentUser);

        currentUser.addUserToCourse(course);
        entityManager.persist(course);
        entityManager.getTransaction().commit();
        entityManagerFactory.close();

        return course;
    }

    public List<Course> getUserCourse(Integer id) {
        List<Course> course;
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        User currentUser = entityManager.find(User.class,id);
        log.info("current user............"+currentUser.toString());

        course = currentUser.getCourses();

        entityManager.getTransaction().commit();
        entityManagerFactory.close();

        return course;
    }
}
