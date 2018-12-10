package com.example.thiago.projetointerdisciplinar.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.thiago.projetointerdisciplinar.model.Group;

import java.util.List;

@Dao
public interface GroupDAO {

    @Insert
    void insert(Group group);

    @Update
    void update(Group group);

    @Query("DELETE FROM group_table where group_table.ID == :id")
    void delete(long id);

    @Query("SELECT group_table.ID, group_table.group_name, group_table.type, group_table.user_id  from group_table INNER JOIN user_table ON group_table.user_id = user_table.ID AND user_table.ID = :id ")
    List<Group> loadGroupByUser(Long id);

}
