package com.example.proyectosemestral.models;

import java.util.Date;

public class Comment {
    private int id;
    private String body;
    private int user_id;
    private String username;
    private String commentable_type;
    private int commentable_id;
    private Date created_at;
    private Date updated_at;

    public int getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getCommentable_type() {
        return commentable_type;
    }

    public int getCommentable_id() {
        return commentable_id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public String getUsername() {
        return username;
    }
}
