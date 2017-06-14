package com.development.tylerwindham.liscensescanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class EntryPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_page);
    }

    public void onGoTakePicture(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
