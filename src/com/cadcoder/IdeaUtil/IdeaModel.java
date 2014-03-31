package com.cadcoder.IdeaUtil;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Basic IdeaModel class
 */
public class IdeaModel extends DatabaseModel implements Parcelable {

    private String _title;
    private String _description;

    public IdeaModel() {
        super();
    }

    public IdeaModel(String title) {
        super();
        setTitle(title);
    }

    public IdeaModel(Parcel parcel) {
        setId(parcel.readLong());
        setTitle(parcel.readString());
        setDescription(parcel.readString());
        setCreated(parcel.readString());
        setModified(parcel.readString());
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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(getId());
        parcel.writeString(getTitle());
        parcel.writeString(getDescription());
        parcel.writeString(getCreatedString());
        parcel.writeString(getModifiedString());
    }

    public static final Creator<IdeaModel> CREATOR = new Creator<IdeaModel>() {
        @Override
        public IdeaModel createFromParcel(Parcel parcel) {
            return new IdeaModel(parcel);
        }

        @Override
        public IdeaModel[] newArray(int i) {
            return new IdeaModel[i];
        }
    };
}
