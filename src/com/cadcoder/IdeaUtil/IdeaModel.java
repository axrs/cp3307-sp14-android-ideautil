package com.cadcoder.IdeaUtil;

import java.util.Date;

/**
 * Basic IdeaModel class
 */
public class IdeaModel {

    private String _title;
    private String _description;
    private Date _created = new Date();
    private Date _modified;

    private boolean _isDirty = false;

    public IdeaModel() {
        initTimeStamps();
    }

    public IdeaModel(String _title) {
        this._title = _title;
        initTimeStamps();
    }

    private void initTimeStamps() {
        Date d = new Date();
        _created = d;
        _modified = d;
    }

    public String getTitle() {
        if (_title == null) {
            _title = "Untitled";
        }
        return _title;
    }

    public void setTitle(String title) {
        if (!title.equals("")) {
            this._title = title;
            setModified();
        }
    }

    public String getDescription() {
        if (_description == null) {
            _description = "";
        }
        return _description;
    }

    public void setDescription(String description) {
        this._description = description;
        setModified();
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

    private void setModified() {
        _modified = new Date();
        _isDirty = true;
    }

    public boolean isDirty() {
        return _isDirty;
    }
}
