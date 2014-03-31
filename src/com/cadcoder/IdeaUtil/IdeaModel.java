package com.cadcoder.IdeaUtil;

/**
 * Basic IdeaModel class
 */
public class IdeaModel extends DatabaseModel {

    private String _title;
    private String _description;

    public IdeaModel() {
        super();
    }

    public IdeaModel(String title) {
        super();
        setTitle(title);
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
}
