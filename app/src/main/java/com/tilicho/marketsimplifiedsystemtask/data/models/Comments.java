package com.tilicho.marketsimplifiedsystemtask.data.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "comments")
public class Comments {

    @PrimaryKey
    public Long id;

    @ColumnInfo(name = "nodeId")
    public String nodeId;

    @ColumnInfo(name = "comment")
    public String comment;

}
