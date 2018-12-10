package com.example.thiago.projetointerdisciplinar.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.thiago.projetointerdisciplinar.model.Friend;

@Dao
public interface FriendDAO {

    @Insert
    void insert(Friend friend);

    @Query("DELETE FROM friend where friend.ID == :id")
    void delete(long id);

}
