package com.example.thiago.projetointerdisciplinar.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "friend",
        foreignKeys = @ForeignKey(entity = User.class,
                parentColumns = "ID",
                childColumns = "user_id"))
public class Friend {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    private long id;

    @ColumnInfo(name = "friend_name")
    private String friendName;

    @ColumnInfo(name = "user_id")
    private long userId;

    public Friend() {
    }

    public Friend(long id, String groupName) {
        this.id = id;
        this.friendName = friendName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    public long getUserId() { return userId; }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
