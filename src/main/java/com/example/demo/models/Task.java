package com.example.demo.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private String title;

    private String content;

    private Date endAt;

    private String status;

    @ManyToOne
    private User user;

    public Task(long id, String title, String content, Date endAt, String status, User user) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.endAt = endAt;
        this.status = status;
        this.user = user;
    }

    public Task(String title, String content, Date endAt, String status, User user) {
        this.title = title;
        this.content = content;
        this.endAt = endAt;
        this.status = status;
        this.user = user;
    }

    public Task() {

    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getEndAt() {
        return endAt;
    }

    public void setEndAt(Date endAt) {
        this.endAt = endAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", endAt=" + endAt +
                ", status='" + status + '\'' +
                ", user=" + user +
                '}';
    }
}
