package com.cadcoder.IdeaUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends Activity {
    private SQLiteIdeaDAO _dao;
    private static final int IDEA_SAVED = 1;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _dao = new SQLiteIdeaDAO(this);
        _dao.open();

        List<IdeaModel> modelList = _dao.getAll();
        IdeaListViewAdapter adapter = new IdeaListViewAdapter(this, modelList);
        ListView modelView = (ListView) findViewById(R.id.modelView);
        modelView.setAdapter(adapter);
    }

    private void refreshListView() {
        ListView modelView = (ListView) findViewById(R.id.modelView);
        ((IdeaListViewAdapter) modelView.getAdapter()).setModels(_dao.getAll());
        ((IdeaListViewAdapter) modelView.getAdapter()).notifyDataSetChanged();
        Log.e("HERE", "update");
    }

    public void createNewTask(View view) {
        Intent intent = new Intent(this, AddIdeaActivity.class);
        startActivityForResult(intent, IDEA_SAVED);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        switch (requestCode) {
            case IDEA_SAVED:
                if (resultCode == RESULT_OK) {
                    refreshListView();
                }
                break;
        }

    }
}
