package org.den.krakens.ckbudet.main.models;

/**
 * Created by Mohru on 15.06.2018.
 */

public class Comment {
    private int id;
    private String content;
    private User user;

    public Comment(int id, String content, User user) {
        this.id = id;
        this.content = content;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUserId(User user) {
        this.user = user;
    }
}
