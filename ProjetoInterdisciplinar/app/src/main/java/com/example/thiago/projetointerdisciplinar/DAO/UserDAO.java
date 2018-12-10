package com.example.thiago.projetointerdisciplinar.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.thiago.projetointerdisciplinar.model.Friend;
import com.example.thiago.projetointerdisciplinar.model.User;

import java.util.List;

@Dao
public interface UserDAO {

    @Insert
    void insert(User user);

    @Update
    void update(User user);

    @Query("SELECT * FROM user_table WHERE user_table.ID == :id")
    User loadUserByID(Long id);

    @Query("SELECT * FROM user_table WHERE user_table.email == :email AND user_table.pass == :pass ")
    User login(String email, String pass);

    @Query("DELETE FROM user_table where user_table.ID == :id")
    void delete(long id);

    @Query("SELECT * from user_table ORDER BY name")
    List<User> loadUsers();

    //@Query("SELECT * from friend WHERE user_id = :id")
    @Query("SELECT friend.* from friend INNER JOIN user_table ON friend.user_id = user_table.ID AND user_table.ID = :id ")
    List<Friend> loadFriend(long id);

    @Query("SELECT email from user_table")
    List<String> loadUserNames();

    @Query("SELECT email from user_table WHERE email == :email")
    String checkEmail(String email);
}
