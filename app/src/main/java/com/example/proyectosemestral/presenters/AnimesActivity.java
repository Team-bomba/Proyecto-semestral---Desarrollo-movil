package com.example.proyectosemestral.presenters;

import android.os.Bundle;

import com.example.proyectosemestral.R;

public class AnimesActivity extends BasePresenter {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);

        lvItems = findViewById(R.id.lvItems);
        getAnimes();
        SetCurrentUserIfexist();
        footer();
    }
}