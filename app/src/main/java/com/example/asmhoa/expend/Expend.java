package com.example.asmhoa.expend;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "expend")
public class Expend {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "des")
    public String des;

    @ColumnInfo(name = "detail")
    public String detail;

    @ColumnInfo(name = "amount")
    public String amount;

    @ColumnInfo(name = "date")
    public String date;

    @ColumnInfo(name = "category")
    public String category;

}
