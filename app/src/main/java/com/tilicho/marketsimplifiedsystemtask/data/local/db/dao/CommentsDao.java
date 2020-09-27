package com.tilicho.marketsimplifiedsystemtask.data.local.db.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.tilicho.marketsimplifiedsystemtask.data.models.Comments;

import io.reactivex.Single;

@Dao
public interface CommentsDao {

    @Query("SELECT * FROM comments WHERE nodeId LIKE :nodeIdentifier")
    Single<Comments> findByName(String nodeIdentifier);

}
