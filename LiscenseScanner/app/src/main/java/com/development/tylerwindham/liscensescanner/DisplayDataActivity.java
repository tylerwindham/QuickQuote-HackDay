package com.development.tylerwindham.liscensescanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DisplayDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);

        Intent intent = getIntent();
        //String data = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);


        TextView textView = (TextView) findViewById(R.id.license_data);
        //textView.setText(data);
    }

    public void onGoTakePicture(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
