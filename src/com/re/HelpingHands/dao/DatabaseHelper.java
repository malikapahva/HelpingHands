package com.re.HelpingHands.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "helpinghands.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        System.out.println("Running Query : " + PersonalDao.TABLE_CREATE);
        sqLiteDatabase.execSQL(PersonalDao.TABLE_CREATE);
        sqLiteDatabase.execSQL(ContactDao.TABLE_CREATE);
        sqLiteDatabase.execSQL(NoteDao.TABLE_CREATE);
        System.out.println("Table has created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
        System.out.println("Running upgrade query");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + PersonalDao.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ContactDao.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + NoteDao.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
