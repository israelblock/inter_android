package com.example.thiago.projetointerdisciplinar.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "interest",
        foreignKeys = @ForeignKey(entity = User.class,
                parentColumns = "ID",
                childColumns = "user_id"))
public class Interest {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    private long id;
    private String type;

    @ColumnInfo(name = "user_id")
    private long userId;

    public Interest() {
    }

    public Interest(long id, String type) {
        this.id = id;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getUserId() { return userId; }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
