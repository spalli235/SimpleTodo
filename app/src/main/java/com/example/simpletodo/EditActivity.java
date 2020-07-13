package com.example.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    // get handle on views from activity_edit
    EditText etItem;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        // define what each member variable is (grab references to views in layout)
        etItem = findViewById(R.id.etItem);
        btnSave = findViewById(R.id.btnSave);

        // make title of activity more descriptive
        getSupportActionBar().setTitle("Edit item");

        // retrieve data from MainActivity to prepopulate
        etItem.setText(getIntent().getStringExtra(MainActivity.KEY_ITEM_TEXT));
        // When the user is done editing, they click the save button
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent which will contain the results (empty constructor b/c shell for passing data)
                Intent intent = new Intent();

                // Pass the data (results of editing)
                intent.putExtra(MainActivity.KEY_ITEM_TEXT, etItem.getText().toString());
                intent.putExtra(MainActivity.KEY_ITEM_POSITION, getIntent().getExtras().getInt(MainActivity.KEY_ITEM_POSITION));

                // Set the result of the intent
                setResult(RESULT_OK, intent);

                // Finish activity, close the screen and go back
                finish();
            }
        });
    }
}