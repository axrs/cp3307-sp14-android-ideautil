package com.cadcoder.IdeaUtil;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DatabaseModel {
    private long _id = -1;
    private Date _created;
    private Date _modified;

    private boolean _isDirty = false;

    public DatabaseModel() {
        Date d = new Date();
        _created = d;
        _modified = d;
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        if (id >= 0) {
            _id = id;
        }
    }

    public Date getCreated() {
        return _created;
    }

    public String getCreatedString() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(getCreated());
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

    public void setCreated(Date created) {
        this._created = created;
    }

    public void setCreated(String date) {

        this._created = formatDate(date);
    }

    public Date getModified() {
        return _modified;
    }

    public String getModifiedString() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(getModified());
    }

    public void setModified() {
        this._modified = new Date();
        _isDirty = true;
    }

    public void setModified(String date) {

        this._modified = formatDate(date);
    }

    public void setModified(Date created) {
        this._modified = created;
    }

    public Boolean isDirty() {
        return _isDirty;
    }


}
