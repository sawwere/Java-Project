package com.javaproject.allUp.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "topics")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "text")
    private String text;

    @Column(name = "rating")
    private int rating;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reply> replies;

    public long getId() {
        return id;
    }

    public void addReply(Reply reply) {
        reply.setTopic(this);
        replies.add(reply);
    }

    public void removeReply(Reply reply) {
        replies.remove(reply);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }

    public Topic() {}

    public Topic(String title, String text) {
        this.title = title;
        this.text = text;
        this.rating = 0;
        this.replies = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text=" + text +
                ", rating=" + rating +
                '}';
    }
}
