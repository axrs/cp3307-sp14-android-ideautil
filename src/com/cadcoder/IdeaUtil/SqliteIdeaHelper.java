package com.cadcoder.IdeaUtil;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqliteIdeaHelper extends SQLiteOpenHelper {

    public SqliteIdeaHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public static final String TABLE_NAME = "ideas";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_DESCRIPTION = "desc";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_CREATED = "created";
    public static final String COLUMN_MODIFIED = "modified";

    private static final String DATABASE = "ideas.db";
    private static final int DATABASE_VERSION = 1;

    private static final String CREATION_SQL =
            "CREATE TABLE " + TABLE_NAME + "(" +
                    COLUMN_ID + " integer primary key autoincrement," +
                    COLUMN_TITLE + " text not null," +
                    COLUMN_DESCRIPTION + " text, " +
                    COLUMN_CREATED + " text not null, " +  //Will store dates as ISO formatted string.
                    COLUMN_MODIFIED + " text not null);";  //Will store dates as ISO formatted string.

    /**
     * Method used to create the database table
     *
     * @param sqLiteDatabase SQLite Database
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATION_SQL);
    }

    /**
     * Method used to upgrade the database
     *
     * @param sqLiteDatabase SQLite Database
     * @param oldVersion     Old Version
     * @param newVersion     New Version
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        //ToDo for Version 2.
    }
}
