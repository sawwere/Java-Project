package com.javaproject.allUp;

import com.javaproject.allUp.models.Reply;
import com.javaproject.allUp.models.Topic;
import com.javaproject.allUp.services.TopicService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AllUpApplication {

	public static void main(String[] args) {
		SpringApplication.run(AllUpApplication.class, args);

//		TopicService topicService = new TopicService();
//		Topic topic = new Topic("Hello World!", "Greetings to everyone.");
//		topicService.saveTopic(topic);
//		Reply reply1 = new Reply("Hi");
//		reply1.setTopic(topic);
//		topic.addReply(reply1);
//		Reply reply2 = new Reply("GG");
//		reply2.setTopic(topic);
//		topic.addReply(reply2);
//		topicService.updateTopic(topic);
	}

}
