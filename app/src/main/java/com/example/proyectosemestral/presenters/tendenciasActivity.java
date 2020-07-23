package com.example.proyectosemestral.presenters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.proyectosemestral.R;

public class tendenciasActivity extends BasePresenter {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tendencias);

        lvItems= findViewById(R.id.lvItems);
        getAnimeTendencias();
    }
}