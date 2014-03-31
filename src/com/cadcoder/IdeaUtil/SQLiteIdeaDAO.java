package com.cadcoder.IdeaUtil;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class SQLiteIdeaDAO {

    private SQLiteDatabase _db;
    private SQLiteIdeaHelper _helper;
    private String[] _columns = {
            SQLiteIdeaHelper.COLUMN_ID,
            SQLiteIdeaHelper.COLUMN_TITLE,
            SQLiteIdeaHelper.COLUMN_DESCRIPTION,
            SQLiteIdeaHelper.COLUMN_CREATED,
            SQLiteIdeaHelper.COLUMN_MODIFIED
    };

    public SQLiteIdeaDAO(Context context) {
        _helper = new SQLiteIdeaHelper(context);
    }

    public void open() throws SQLException {
        _db = _helper.getWritableDatabase();
    }

    public void close() {
        _db.close();
    }


    public List<IdeaModel> getAll() {
        List<IdeaModel> models = new ArrayList<IdeaModel>();

        Cursor c = _db.query(SQLiteIdeaHelper.TABLE_NAME, _columns, null, null, null, null, null);
        c.moveToFirst();
        while (!c.isAfterLast()) {
            models.add(createFromRecord(c));
            c.moveToNext();
        }
        c.close();
        return models;
    }

    public IdeaModel create(IdeaModel inModel) {

        ContentValues values = new ContentValues();
        values.put(SQLiteIdeaHelper.COLUMN_TITLE, inModel.getTitle());
        values.put(SQLiteIdeaHelper.COLUMN_DESCRIPTION, inModel.getDescription());
        values.put(SQLiteIdeaHelper.COLUMN_CREATED, formatDate(inModel.getCreated()));
        values.put(SQLiteIdeaHelper.COLUMN_MODIFIED, formatDate(inModel.getModified()));

        long insertedId = _db.insert(SQLiteIdeaHelper.TABLE_NAME, null, values);

        Cursor cursor = _db.query(SQLiteIdeaHelper.TABLE_NAME, _columns, SQLiteIdeaHelper.COLUMN_ID + "=" + insertedId, null, null, null, null);

        IdeaModel outModel = createFromRecord(cursor);
        cursor.close();
        return outModel;
    }

    public void delete(IdeaModel inModel) {
        _db.delete(SQLiteIdeaHelper.TABLE_NAME, SQLiteIdeaHelper.COLUMN_ID + "=" + inModel.getId(), null);
    }

    private IdeaModel createFromRecord(Cursor cursor) {
        IdeaModel model = new IdeaModel();

        model.setId(cursor.getInt(0));
        model.setTitle(cursor.getString(1));
        model.setDescription(cursor.getString(2));
        model.setCreated(formatDate(cursor.getString(3)));
        model.setModified(formatDate(cursor.getString(4)));

        return model;
    }

    private String formatDate(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }

    private Date formatDate(String value) {
        Date d = new Date();
        try {
            d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(value);
        } catch (ParseException ex) {
            Log.e("SQLiteIdeaDAO", ex.toString());
        }
        return d;
    }
}
