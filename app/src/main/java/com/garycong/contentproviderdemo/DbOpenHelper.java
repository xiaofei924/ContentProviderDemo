package com.garycong.contentproviderdemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbOpenHelper extends SQLiteOpenHelper {
    /**news db名字*/
    private static final String DB_NAME = "news_provider.db";
    /**news的表名*/
    public static final String NEWS_TABLE_NAME = "news";
    /**版本号*/
    private static final int DB_VERSION = 1;
    /**建表SQL语句*/
    private static final String CREATE_NEWS_TABLE = "CREATE TABLE IF NOT EXISTS "
            + NEWS_TABLE_NAME
            + "(_id INTEGER PRIMARY KEY,"
            + "time TEXT,"
            + "content TEXT)";

    public DbOpenHelper(Context context) {
        this(context, DB_NAME, null, DB_VERSION);
    }
    public DbOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_NEWS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
