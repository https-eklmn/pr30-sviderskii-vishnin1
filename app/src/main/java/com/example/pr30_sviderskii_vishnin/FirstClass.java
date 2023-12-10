package com.example.pr30_sviderskii_vishnin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FirstClass extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickStart(View v) {
        startService(new Intent(this, MyService2.class));
    }

    public void onClickStop(View v) {
        stopService(new Intent(this, MyService2.class));
    }
}
