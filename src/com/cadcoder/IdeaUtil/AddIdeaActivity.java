package com.cadcoder.IdeaUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddIdeaActivity extends Activity {
    SQLiteIdeaDAO _dao;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_idea);
        _dao = SQLiteIdeaDAO.getInstance(this);
    }

    public void saveTask(View view) {
        EditText titleView = (EditText) findViewById(R.id.titleEdit);
        EditText descriptionView = (EditText) findViewById(R.id.descriptionEdit);


        if (!titleView.getText().toString().equals("")) {
            IdeaModel model = new IdeaModel(titleView.getText().toString());
            model.setDescription(descriptionView.getText().toString());

            _dao.create(model);

            Intent intent = new Intent();
            setResult(RESULT_OK, intent);
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_CANCELED);
        super.onBackPressed();
    }
}