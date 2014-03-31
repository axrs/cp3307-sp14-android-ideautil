package com.cadcoder.IdeaUtil;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;

public class IdeaListViewAdapter extends BaseAdapter {
    private Context _context;


    SQLiteIdeaDAO _dao;

    public IdeaListViewAdapter(Context _context) {
        this._context = _context;
        _dao = SQLiteIdeaDAO.getInstance(_context);
    }

    @Override
    public int getCount() {
        return _dao.getAll().size();
    }

    @Override
    public Object getItem(int i) {
        return _dao.getAll().get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = ((Activity) _context).getLayoutInflater();
            convertView = inflater.inflate(R.layout.partial_idea_master, parent, false);
        }

        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView description = (TextView) convertView.findViewById(R.id.description);
        TextView created = (TextView) convertView.findViewById(R.id.created);

        IdeaModel model = (IdeaModel) getItem(position);

        title.setText(model.getTitle());
        description.setText(model.getDescription());
        created.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(model.getCreated()));
        return convertView;
    }
}