package com.example.proyectosemestral.presenters;


import android.os.Bundle;

import com.example.proyectosemestral.R;

public class HomeActivity extends BasePresenter {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        lvItems = findViewById(R.id.lvItems);

        SetCurrentUserIfexist();
        footer();

    }
}