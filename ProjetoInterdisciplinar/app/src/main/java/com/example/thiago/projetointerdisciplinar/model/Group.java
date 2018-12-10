package com.example.thiago.projetointerdisciplinar.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "group_table",
        foreignKeys = @ForeignKey(entity = User.class,
                parentColumns = "ID",
                childColumns = "user_id"))
public class Group {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    private long id;

    @ColumnInfo(name = "group_name")
    private String groupName;
    private String type;

    @ColumnInfo(name = "user_id")
    private long userId;

    public Group() {
    }

    public Group(long id, String groupName, String type) {
        this.id = id;
        this.groupName = groupName;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
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
