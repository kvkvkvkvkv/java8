package org.springframework.dao;

import org.springframework.controller.exception.EmployeeNotFoundException;
import org.springframework.model.Student;
import org.springframework.model.User;
import org.springframework.model.UserProfile;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.spi.PersistenceProvider;
import java.rmi.StubNotFoundException;
import java.util.List;
import java.util.logging.Logger;

@Service
public class UserEntityManager {

    //CRUD
    Logger log = Logger.getLogger("UserEntityManager");

    //Create
    @PostConstruct
    public void init(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction( ).begin( );

        User user = new User();
        user.setAge(10);
        user.setName("A");
        user.setEmail("a@gmail.com");

        UserProfile userProfile = new UserProfile();
        userProfile.setHobby("play");
        userProfile.setYouTube("link1");

        user.setUserProfile(userProfile);

        entityManager.persist(user);

        User user1 = new User();
        user1.setAge(11);
        user1.setName("B");
        user1.setEmail("b@gmail.com");

        UserProfile userProfile1 = new UserProfile();
        userProfile1.setHobby("music");
        userProfile1.setYouTube("link2");

        user1.setUserProfile(userProfile1);

        entityManager.persist(user1);
        entityManager.getTransaction().commit();

        entityManager.close( );
        entityManagerFactory.close();
    }

    //Read
    public User readUser(Integer id){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        User user = entityManager.find(User.class,id);

        entityManager.getTransaction().commit();
        entityManagerFactory.close();

        return user;
    }

    //read
    //query
    public List<User> readUsers() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("Select u from User u");
        List<User> users = query.getResultList();

        entityManager.getTransaction().commit();
        entityManagerFactory.close();

        return users;
    }

    public User createUser(User user) {
        log.info(user.toString());
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManagerFactory.close();

        return user;
    }

    public User updateUser(User user) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        User currentUser = entityManager.find(User.class,user.getUserId());
        currentUser = user;

        entityManager.getTransaction().commit();
        entityManagerFactory.close();

        return user;
    }

    public User patchUser(User user, Integer id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        User currentUser = entityManager.find(User.class,id);
        log.info(currentUser.toString());
        if(user.getAge()!=null){
            currentUser.setAge(user.getAge());
        }
        if (user.getEmail()!=null){
            currentUser.setEmail(user.getEmail());
        }
        if (user.getName()!=null){
            currentUser.setName(user.getName());
        }

        entityManager.getTransaction().commit();
        entityManagerFactory.close();

        return user;
    }

    public void deleteUser(Integer id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        User currentUser = entityManager.find(User.class,id);
        entityManager.remove(currentUser);
        entityManager.getTransaction().commit();
        entityManagerFactory.close();
    }

    public void biDirection(Integer id){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        UserProfile userProfile;
        try {
            userProfile = entityManager.find(UserProfile.class,id);
        } catch (EmployeeNotFoundException e){
            throw new EmployeeNotFoundException("Not found id "+id);
        }

        User user = userProfile.getUser();
        user.setName(user.getName()+"new");

        entityManager.getTransaction().commit();
        entityManagerFactory.close();
    }
}
