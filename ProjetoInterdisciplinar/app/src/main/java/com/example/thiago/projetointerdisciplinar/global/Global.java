package com.example.thiago.projetointerdisciplinar.global;

import android.app.Application;

import com.example.thiago.projetointerdisciplinar.model.User;

public class Global extends Application {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}