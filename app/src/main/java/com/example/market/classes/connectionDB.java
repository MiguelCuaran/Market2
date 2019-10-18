package com.example.market.classes;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class connectionDB extends SQLiteOpenHelper {
    public connectionDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase market) {
        //Create table(s)
        market.execSQL("create table users(" +
                "id integer primary key autoincrement not null," +
                "firstname text not null," +
                "lastname text not null," +
                "email text not null," +
                "password text not null)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public Cursor SelectUsersData(){
        SQLiteDatabase market = this.getReadableDatabase();
        Cursor rows = market.rawQuery(
                "SELECT id, firstname || ' ' || lastname as name, email, password FROM users",null);
         return rows;
    }

}
