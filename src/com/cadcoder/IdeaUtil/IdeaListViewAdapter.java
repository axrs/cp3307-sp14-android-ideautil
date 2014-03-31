package com.cadcoder.IdeaUtil;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class IdeaListViewAdapter extends BaseAdapter {
    private Context _context;

    List<IdeaModel> _models;

    public IdeaListViewAdapter(Context _context, List<IdeaModel> _models) {
        this._context = _context;
        this._models = _models;
    }

    public void setModels(List<IdeaModel> models) {
        _models = models;
    }

    @Override
    public int getCount() {
        return _models.size();
    }

    @Override
    public Object getItem(int i) {
        return _models.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = ((Activity) _context).getLayoutInflater();
            convertView = inflater.inflate(R.layout.fragment_idea_master, parent, false);
        }

        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView description = (TextView) convertView.findViewById(R.id.description);
        IdeaModel model = (IdeaModel) getItem(position);

        title.setText(model.getTitle());
        description.setText(model.getDescription());
        return convertView;
    }
}