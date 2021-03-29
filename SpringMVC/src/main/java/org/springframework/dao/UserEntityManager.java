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
        entityManager.getTransaction().commit();

        entityManager.close( );
        entityManagerFactory.close();
    }
}
