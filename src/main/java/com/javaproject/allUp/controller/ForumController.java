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
public class ForumController {
    @Autowired
    private TopicService topicService;

    @GetMapping("/forum")
    public ModelAndView home() {
        List<Topic> topics = topicService.findAllTopics();
        ModelAndView mav = new ModelAndView("forum");
        Topic newTopic = new Topic();
        mav.addObject("topics", topics);
        mav.addObject("newTopic", newTopic);
        mav.setViewName("forum");
        return mav;
    }

    @PostMapping("/forum/createTopic")
    public String createTopic(Topic topic) {
        topicService.saveTopic(topic);
        System.out.println("666666666666666");
        return "redirect:/forum";
    }

    @PostMapping("/forum/topic/{id}/reply")
    public String createReply(@PathVariable Long id, Reply reply) {
        Topic topic = topicService.findTopic(id);
        topic.addReply(reply);
        reply.setTopic(topic);
        topicService.updateTopic(topic);
        return "redirect:/forum/topic/"+id;
    }
    @GetMapping("/forum/topic/{id}")
    public ModelAndView topicPage(@PathVariable Long id) {
        Topic topic = topicService.findTopic(id);
        ModelAndView mav = new ModelAndView("topic");
        Reply reply = new Reply();
        mav.addObject("topic", topic);
        mav.addObject("reply", reply);
        mav.setViewName("topic_page");
        return mav;
    }

    @PostMapping("/forum/topic/{id}/{reaction}")
    public String topicReaction(@PathVariable Long id, @PathVariable String reaction) {
        Topic topic = topicService.findTopic(id);
        switch (reaction) {
            case "like" -> {
                topic.setRating(topic.getRating() + 1);
            }
            case "dislike" -> {
                topic.setRating(topic.getRating() - 1);
            }
            default -> System.out.println("ERROR");
        }
        topicService.updateTopic(topic);
        return "redirect:/forum";
    }

    @PostMapping("/forum/topic/{topicId}/reply/{replyId}/{reaction}")
    public String replyReaction(@PathVariable Long topicId, @PathVariable Long replyId, @PathVariable String reaction) {
        Reply reply= topicService.findReplyById(replyId);
        switch (reaction) {
            case "like" -> {
                reply.setLike_count(reply.getLike_count() + 1);
            }
            case "dislike" -> {
                reply.setDislike_count(reply.getDislike_count() + 1);
            }
            default -> System.out.println("ERROR");
        }
        topicService.updateReply(reply);
        return "redirect:/forum/topic/"+topicId;
    }
}
