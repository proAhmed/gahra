package com.gahra.ahmed.gahra.start;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.gahra.ahmed.gahra.R;

public class MapActivity extends AppCompatActivity {

    RelativeLayout reMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        reMap = (RelativeLayout) findViewById(R.id.reSelectCity);
        reMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
