package com.example.thiago.projetointerdisciplinar.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Update;

import com.example.thiago.projetointerdisciplinar.model.Interest;

@Dao
public interface InterestDAO {

    @Insert
    void insert(Interest interest);

    @Update
    void update(Interest interest);
}
