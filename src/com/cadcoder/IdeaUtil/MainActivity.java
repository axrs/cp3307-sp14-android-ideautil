package com.cadcoder.IdeaUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends Activity {
    private static final int IDEA_SAVED = 1;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IdeaListViewAdapter adapter = new IdeaListViewAdapter(this);
        final ListView modelView = (ListView) findViewById(R.id.modelView);
        modelView.setAdapter(adapter);

        modelView.setClickable(true);
        modelView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                IdeaModel model = (IdeaModel) modelView.getItemAtPosition(i);
                Intent intent = new Intent(modelView.getContext(), DetailIdeaActivity.class);
                intent.putExtra("idea", model);
                startActivityForResult(intent, IDEA_SAVED);
            }
        });
    }

    private void refreshListView() {
        ListView modelView = (ListView) findViewById(R.id.modelView);
        ((IdeaListViewAdapter) modelView.getAdapter()).notifyDataSetChanged();
        Log.e("HERE", "update");
    }

    public void createNewTask(View view) {
        Intent intent = new Intent(this, DetailIdeaActivity.class);
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
