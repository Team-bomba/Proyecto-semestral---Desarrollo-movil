package com.example.proyectosemestral.presenters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.proyectosemestral.R;


public abstract class BasePresenter extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
