package com.example.proyectosemestral.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Post {
    private int id;
    private String title;
    private String body;
    private int user_id;
    private Date created_at;
    private Date updated_at;
    private int comments_count;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public int getUser_id() {
        return user_id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public int getComments_count() {
        return comments_count;
    }
}
