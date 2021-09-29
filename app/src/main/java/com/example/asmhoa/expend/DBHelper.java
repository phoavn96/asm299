package com.example.asmhoa.expend;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.asmhoa.FAdd;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_Name = "EXPEND";
    public static final int DB_VERSION = 1;
    public static  String TABLE_NAME = "TBL_EXPEND";
    public static final String ID = "_id";
    public static final String NAME = "name";
    public static final String DES = "des";
    public static final String INFOR = "infor";
    public static final String AMOUNT = "amount";
    public static final String DATE = "date";
    public static final String CATEGORY = "category";

    public DBHelper(Context context){
        super(context,DB_Name,null,DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_NAME +"("+
                ID+" INTEGER PRIMARY KEY, " +
                NAME + "TEXT, "+
                DES + "TEXT, "+
                INFOR + "TEXT, "+
                AMOUNT + "TEXT, "+
                DATE + "TEXT, "+
                CATEGORY + " TEXT)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS "+ TABLE_NAME;
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);

    }


    public String addExpenses(String expend , String infor , String des,String amount, String date,String category){
        SQLiteDatabase  db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME,expend);
        contentValues.put(INFOR,infor);
        contentValues.put(DES,des);
        contentValues.put(AMOUNT,amount);
        contentValues.put(DATE,date);
        contentValues.put(CATEGORY,category);
        long isAdd = db.insert(TABLE_NAME,null,contentValues);
        if (isAdd == -1){
            return "ADD Fail";
        }
        db.close();
        return "Add Success";
    }






    public String deleteUser(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        int isDelete = db.delete(TABLE_NAME,ID+" = ? ",new String[] {id+""});
        if (isDelete > 0){
            return "delete success";
        }
        db.close();
        return "delete fail";
    }
    public Cursor getAllUser(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String sql = "SELECT * FROM "+ TABLE_NAME;
        Cursor c = sqLiteDatabase.rawQuery(sql,null);
        return c;
    }



}
