package com.example.demo.dao;

import com.example.demo.models.User;
import com.example.demo.services.TaskService;
import com.example.demo.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;
import java.util.List;

public class UserDAO implements DAO<User, Long>{

    @Override
    public List<User> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<User> users = session.createQuery("from User").getResultList();
        session.close();
        return users;
    }

    @Override
    public User getById(Long userId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        User user = (User) session.createQuery("from User where id = :id").setParameter("id", userId);
        session.close();
        return user;
    }

    public User getUserByPseudo(String email){
        Session session = HibernateUtil.getSessionFactory().openSession();
        User user;
        try {
            user = (User) session.createQuery("FROM User WHERE email = :email")
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException e) {
            user = null;
        }
        session.close();
        return user;
    }

    @Override
    public long create(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Long userId = (Long) session.save(user);
        session.close();

        return userId;
    }

    @Override
    public long update(User user) {
        return 0;
    }

    @Override
    public void delete(Long userId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.createQuery("delete from User where id = :id")
                .setParameter("id", userId)
                .executeUpdate();

        transaction.commit();
        session.close();
    }
}
