package com.example.pr30_sviderskii_vishnin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SECONDPROJECT extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondproject);
    }
    public void onClickStart(View v) {
        startService(new Intent(this, MyService3.class).putExtra("time", 7));
        startService(new Intent(this, MyService3.class).putExtra("time", 2));
        startService(new Intent(this, MyService3.class).putExtra("time", 4));
    }
}