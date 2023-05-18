package com.javaproject.allUp.services;

import com.javaproject.allUp.DAO.TopicDao;
import com.javaproject.allUp.models.Reply;
import com.javaproject.allUp.models.Topic;

import java.util.List;

public class TopicService {
    private TopicDao topicDao = new TopicDao();

    public TopicService() {
    }

    public Topic findTopic(long id) {
        return topicDao.findById(id);
    }

    public void saveTopic(Topic topic) {
        topicDao.save(topic);
    }

    public void deleteTopic(Topic topic) {
        topicDao.delete(topic);
    }

    public void updateTopic(Topic topic) {
        topicDao.update(topic);
    }

    public List<Topic> findAllTopics() {
        return topicDao.findAll();
    }

    public Reply findReplyById(long id) {
        return topicDao.findReplyById(id);
    }


}