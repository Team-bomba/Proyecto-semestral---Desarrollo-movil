package com.example.proyectosemestral.presenters;

import android.os.Bundle;

import com.example.proyectosemestral.R;

public class PostsActivity extends BasePresenter {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.posts);

        lvItems= findViewById(R.id.lvItems);
        getPosts();
    }
}