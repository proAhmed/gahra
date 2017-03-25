package com.gahra.ahmed.gahra.start;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.TextView;

import com.gahra.ahmed.gahra.R;
import com.mikhaellopez.circularimageview.CircularImageView;

public class BusniessAccount extends AppCompatActivity {
    RecyclerView reBusniess;
    TextView tvNumFeatured,tvNumLatest,tvNumFollowers;
    Button btnEdit;
    CircularImageView busniessImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busniess_account);
        declare();
    }

    private void declare(){
        btnEdit = (Button) findViewById(R.id.btnEdit);
        tvNumFeatured = (TextView) findViewById(R.id.tvNumFeatured);
        tvNumLatest = (TextView) findViewById(R.id.tvNumLatest);
        tvNumFollowers = (TextView) findViewById(R.id.tvNumFollowers);
        busniessImage = (CircularImageView) findViewById(R.id.busniessImage);
        reBusniess = (RecyclerView) findViewById(R.id.reBusniess);
        reBusniess.setLayoutManager(new LinearLayoutManager(this));
    }

    private void addData(){

    }
}
