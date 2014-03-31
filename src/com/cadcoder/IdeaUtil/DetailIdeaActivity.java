package com.cadcoder.IdeaUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DetailIdeaActivity extends Activity {
    SQLiteIdeaDAO _dao;

    private boolean _isEditing = false;
    private IdeaModel _model;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idea_detail);
        _dao = SQLiteIdeaDAO.getInstance(this);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        _isEditing = false;
        if (bundle != null && bundle.containsKey("idea")) {
            _model = bundle.getParcelable("idea");
            setEditingMode();
        }
    }

    private void setEditingMode() {
        _isEditing = true;
        TextView heading = (TextView) findViewById(R.id.headingLabel);
        heading.setText("Editing Idea");

        Button b = (Button) findViewById(R.id.saveButton);
        b.setText("Save Changes");

        Button d = (Button) findViewById(R.id.deleteButton);
        d.setVisibility(View.VISIBLE);

        EditText titleView = (EditText) findViewById(R.id.titleEdit);
        titleView.setText(_model.getTitle());
        EditText descriptionView = (EditText) findViewById(R.id.descriptionEdit);
        descriptionView.setText(_model.getDescription());
    }

    public void saveTask(View view) {
        if (!_isEditing) {
            EditText titleView = (EditText) findViewById(R.id.titleEdit);
            EditText descriptionView = (EditText) findViewById(R.id.descriptionEdit);


            if (!titleView.getText().toString().equals("")) {
                IdeaModel model = new IdeaModel(titleView.getText().toString());
                model.setDescription(descriptionView.getText().toString());

                _dao.create(model);
            }
        } else {
            EditText titleView = (EditText) findViewById(R.id.titleEdit);
            EditText descriptionView = (EditText) findViewById(R.id.descriptionEdit);


            if (!titleView.getText().toString().equals("")) {
                _model.setTitle(titleView.getText().toString());
                _model.setDescription(descriptionView.getText().toString());

                _dao.update(_model);
            }
        }

        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        finish();

    }

    public void deleteTask(View view) {
        _dao.delete(_model);
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_CANCELED);
        super.onBackPressed();
    }
}