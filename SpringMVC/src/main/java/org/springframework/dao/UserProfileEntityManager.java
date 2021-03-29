package org.springframework.dao;

import org.springframework.model.User;
import org.springframework.model.UserProfile;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Service
public class UserProfileEntityManager {

    public void deleteUserProfile(Integer id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        UserProfile currentUser = entityManager.find(UserProfile.class,id);
        entityManager.remove(currentUser);

        entityManager.getTransaction().commit();
        entityManagerFactory.close();
    }
}
