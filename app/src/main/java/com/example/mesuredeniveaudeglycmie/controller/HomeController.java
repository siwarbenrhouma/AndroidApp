package com.example.mesuredeniveaudeglycmie.controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.EditText;

import com.example.mesuredeniveaudeglycmie.Model.Patient;
import com.example.mesuredeniveaudeglycmie.Model.User;

public class HomeController {
    public static User getUser() {
        return user;
    }

    private static User user;
    private static final String SHARED_PREFS = "HomeActivitySharedPrefs";
    private static HomeController instance =null;
    private HomeController(){
        super();
    }
    public static final HomeController getInstance(Context context){
        if(instance==null){
            instance = new HomeController();
            recapUser(context);
        }
        return instance;

    }
    public void createUser(String email, String password, Context context){
        SharedPreferences sharedPreferences= context.getSharedPreferences(SHARED_PREFS,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        user= new User(email, password);
        editor.putString("email",email);
        editor.putString("password",password);
        editor.apply();
    }
    public static void recapUser(Context context){
        SharedPreferences sharedPreferences= context.getSharedPreferences(SHARED_PREFS,Context.MODE_PRIVATE);
        String email = sharedPreferences.getString("email","");
        String password =sharedPreferences.getString("password","");
        user =new User(email,password);

    }
}
