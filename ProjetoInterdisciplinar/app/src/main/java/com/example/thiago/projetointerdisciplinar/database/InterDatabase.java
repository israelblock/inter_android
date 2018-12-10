package com.example.thiago.projetointerdisciplinar.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.thiago.projetointerdisciplinar.DAO.FriendDAO;
import com.example.thiago.projetointerdisciplinar.DAO.GroupDAO;
import com.example.thiago.projetointerdisciplinar.DAO.InterestDAO;
import com.example.thiago.projetointerdisciplinar.DAO.UserDAO;
import com.example.thiago.projetointerdisciplinar.model.Friend;
import com.example.thiago.projetointerdisciplinar.model.Group;
import com.example.thiago.projetointerdisciplinar.model.Interest;
import com.example.thiago.projetointerdisciplinar.model.User;

@Database(entities = {User.class, Friend.class, Group.class, Interest.class},version = 2)
public abstract class InterDatabase extends RoomDatabase {
    private static volatile InterDatabase INSTANCE;
    public abstract UserDAO UserDAO();
    public abstract FriendDAO FriendDAO();
    public abstract GroupDAO GroupDAO();
    public abstract InterestDAO InterestDAO();

    public static InterDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (InterDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),InterDatabase.class,"inter_database")
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
