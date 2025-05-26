package com.lesson49.dao;

import com.lesson49.entity.Bankuser;
import com.lesson49.entity.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getAllUser() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<User> allUser = session.createQuery("from User", User.class).list();
        System.out.println(allUser);
        transaction.commit();
        session.close();
        return allUser;
    }

    public List<Bankuser> getBankUSer() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            List<Bankuser> bankusers = session.createQuery("from Bankuser", Bankuser.class).list();

            if (bankusers.isEmpty()) {
                System.out.println("Нет пользователей в базе!");
                return bankusers;
            }

            // Явная загрузка ленивой коллекции
            Hibernate.initialize(bankusers.get(0).getUsercard());

            // Безопасный вывод (без рекурсии)
            System.out.println("Карты первого пользователя: " + bankusers.get(1).getUsercard().size());

            transaction.commit();
            return bankusers;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException("Ошибка при загрузке пользователей", e);
        } finally {
            session.close();
        }
    }


    public User getUserById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, id);
        System.out.println(user);
        transaction.commit();
        session.close();
        return user;
    }

    public void userSave(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(user);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteUser(int id) {
        Session session = sessionFactory.openSession();
        User person = session.getReference(User.class, id);
        Transaction t = session.beginTransaction();
        session.remove(person);
        t.commit();
        session.close();
    }
}