package com.garycong.contentproviderdemo;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class MyContentProvider extends ContentProvider {
    private SQLiteDatabase mDb;
    public MyContentProvider() {
    }

    @Override
    public boolean onCreate() {
        mDb = new DbOpenHelper(getContext()).getWritableDatabase();
        initDbData();
        return true;
    }

    private void initDbData() {
//        if () {
//        }
//        mDb.execSQL("insert into " + DbOpenHelper.NEWS_TABLE_NAME + " values (0, '11:11', '习大大祝广大单身狗光棍节快乐！！！\n');");
//        mDb.execSQL("insert into " + DbOpenHelper.NEWS_TABLE_NAME + " values (1, '09:24', '生日快乐！！！\n');");
//        mDb.execSQL("insert into " + DbOpenHelper.NEWS_TABLE_NAME + " values (2, '06:01','儿童节快乐！！！\n');");
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
//        throw new UnsupportedOperationException("Not yet implemented");
        return mDb.delete(DbOpenHelper.NEWS_TABLE_NAME, selection, selectionArgs);
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
//        throw new UnsupportedOperationException("Not yet implemented");


//        throw new UnsupportedOperationException("Not yet implemented");
        mDb.insert(DbOpenHelper.NEWS_TABLE_NAME, null, values);
        getContext().getContentResolver().notifyChange(uri, null);
        return uri;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        Cursor cursor = mDb.query(DbOpenHelper.NEWS_TABLE_NAME, projection, selection, selectionArgs,
                null, null, sortOrder, null);
        return cursor;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
//        // TODO: Implement this to handle requests to update one or more rows.
        int id = mDb.update(DbOpenHelper.NEWS_TABLE_NAME, values, selection, selectionArgs);
//        if (id > 0) {

            return id;
//        }
    }
}
