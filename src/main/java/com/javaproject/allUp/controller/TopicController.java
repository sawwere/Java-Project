package com.javaproject.allUp.controller;

import com.javaproject.allUp.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.javaproject.allUp.models.Reply;
import com.javaproject.allUp.models.Topic;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TopicController {
    @Autowired
    private TopicService topicService;

    @GetMapping("/")
    public ModelAndView home() {
        List<Topic> topics = topicService.findAllTopics();
        ModelAndView mav = new ModelAndView("index");
        Topic newTopic = new Topic();
        mav.addObject("topics", topics);
        mav.addObject("newTopic", newTopic);
        mav.setViewName("index");
        return mav;
    }

    @PostMapping("/createTopic")
    public String createTopic(Topic topic) {
        topicService.saveTopic(topic);
        return "redirect:/";
    }
    @GetMapping("topic/{id}")
    public ModelAndView topicPage(@PathVariable Long id) {
        Topic topic = topicService.findTopic(id);
        ModelAndView mav = new ModelAndView("topic");
        Reply reply = new Reply();
        mav.addObject("topic", topic);
        mav.addObject("reply", reply);
        mav.setViewName("topic_page");
        return mav;
    }

    @PostMapping("topic/{id}/reply")
    public String createReply(@PathVariable Long id, Reply reply) {
        Topic topic = topicService.findTopic(id);
        topic.addReply(reply);
        reply.setTopic(topic);
        topicService.updateTopic(topic);
        return "redirect:/";
    }
}
