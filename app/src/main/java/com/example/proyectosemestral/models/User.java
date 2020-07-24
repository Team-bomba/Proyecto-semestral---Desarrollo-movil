package com.example.proyectosemestral.models;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.proyectosemestral.helpers.DBSQLiteHelper;

public class User {
    private int id;
    private String name;
    private String email;
    private String password;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public static int current_user(Context contexto) {
        int user_id;

        DBSQLiteHelper dbsqlite = new DBSQLiteHelper(contexto,"SessionsDB",null, 1);
        SQLiteDatabase db = dbsqlite.getWritableDatabase(); //get the database that was created in this instance
        Cursor c = db.rawQuery("select * from sessions where user_id > ? ;", new String[]{"0"});
        if (c.moveToLast()) {
            user_id = c.getInt(0);
            return user_id;
        }else {
            Log.e("error not found", "user can't be found or database empty");
            return 0;
        }

    }

    public static boolean destroy_current_user(Context contexto) {
        DBSQLiteHelper dbsqlite = new DBSQLiteHelper(contexto,"SessionsDB",null, 1);
        SQLiteDatabase db = dbsqlite.getWritableDatabase(); 
        if(db != null){

            db.execSQL("DELETE FROM sessions");

            db.close();
            return true;
        }
        return false;
    }

    public boolean save_current_user(Context contexto){
        DBSQLiteHelper dbsqlite = new DBSQLiteHelper(contexto,"SessionsDB",null, 1);
        SQLiteDatabase db = dbsqlite.getWritableDatabase();
        if(db != null){

            db.execSQL("DELETE FROM sessions");
            db.execSQL("INSERT INTO sessions (user_id) values ("+ this.id +")");

            db.close();
            return true;
        }
        return false;
    }
}
