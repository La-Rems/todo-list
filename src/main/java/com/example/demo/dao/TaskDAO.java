package com.example.demo.dao;

import com.example.demo.models.Task;
import com.example.demo.models.User;
import com.example.demo.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TaskDAO implements DAO<Task, Long>{

    @Override
    public List<Task> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Task> tasks = session.createQuery("from Task").getResultList();
        session.close();
        return tasks;
    }

    @Override
    public Task getById(Long taskId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Task task = (Task) session.createQuery("from Task t where t.id = :id").setParameter("id", taskId).getSingleResult();
        session.close();
        return task;
    }

    @Override
    public long create(Task task) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Long taskId = (Long) session.save(task);
        session.close();
        return taskId;
    }

    @Override
    public long update(Task taskUpdate) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.createQuery("update Task t set t.status = : status where t.id = :id")
                .setParameter("id", taskUpdate.getId())
                .setParameter("status", taskUpdate.getStatus())
                .executeUpdate();
        transaction.commit();
        session.close();
        return taskUpdate.getId();
    }

    @Override
    public void delete(Long taskId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.createQuery("delete from Task t where t.id = :id")
                .setParameter("id", taskId)
                .executeUpdate();

        transaction.commit();
        session.close();
    }
}
