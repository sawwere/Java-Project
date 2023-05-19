package com.javaproject.allUp.dao;

import com.javaproject.allUp.models.Reply;
import com.javaproject.allUp.models.Topic;
import com.javaproject.allUp.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TopicDao {
    public Topic findById(long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Topic.class, id);
    }

    public void save(Topic topic) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(topic);
        tx1.commit();
        session.close();
    }

    public void update(Topic topic) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.merge(topic);
        tx1.commit();
        session.close();
    }

    public void delete(Topic topic) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(topic);
        tx1.commit();
        session.close();
    }

    public Reply findReplyById(long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Reply.class, id);
    }

    public void updateReply(Reply reply) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.merge(reply);
        tx1.commit();
        session.close();
    }

    public List<Topic> findAll() {
        List<Topic> topics = (List<Topic>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Topic").list();
        return topics;
    }
}
