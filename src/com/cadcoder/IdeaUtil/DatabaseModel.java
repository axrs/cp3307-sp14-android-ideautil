package com.cadcoder.IdeaUtil;

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

    public void setCreated(Date created) {
        this._created = created;
    }

    public Date getModified() {
        return _modified;
    }

    public void setModified() {
        this._modified = new Date();
        _isDirty = true;
    }

    public void setModified(Date created) {
        this._modified = created;
    }

    public Boolean isDirty() {
        return _isDirty;
    }

}
