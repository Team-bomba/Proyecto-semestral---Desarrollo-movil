package com.example.proyectosemestral.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBSQLiteHelper extends SQLiteOpenHelper {

    public DBSQLiteHelper(Context contexto, String nombre, CursorFactory factory, int version) {
        super(contexto,nombre,factory,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        crear_db(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        crear_db(db);
    }

    private void crear_db(SQLiteDatabase db){
        // crear tabla sessions y dropear si existe
        db.execSQL("DROP TABLE IF EXISTS sessions");
        db.execSQL("CREATE TABLE sessions (user_id integer not null)");

        // Que conste, usamos db e.e
    }
}
