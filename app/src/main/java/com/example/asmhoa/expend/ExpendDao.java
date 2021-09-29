package com.example.asmhoa.expend;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ExpendDao {
    @Insert
    long insertExpend(Expend expend);

    @Update
    int updateExpend(Expend expend);

    @Delete
    int deleteExpend(Expend expend);

    @Query("Select * from expend where id = :id")
    Expend findExpend(int id);

    @Query("Select * from expend")
    List<Expend> getAllExpend();
}
