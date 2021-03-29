package org.springframework.dao;

import org.springframework.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.spi.PersistenceProvider;

@Service
public class UserEntityManager {

    //CRUD

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

        entityManager.persist(user);

        User user1 = new User();
        user1.setAge(11);
        user1.setName("B");
        user1.setEmail("b@gmail.com");
        entityManager.persist(user);

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

}
