package com.tilicho.marketsimplifiedsystemtask.data.local.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.tilicho.marketsimplifiedsystemtask.data.local.db.dao.CommentsDao;
import com.tilicho.marketsimplifiedsystemtask.data.models.Comments;

@Database(entities = {Comments.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract CommentsDao optionDao();

}
