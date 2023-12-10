package com.example.pr30_sviderskii_vishnin;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

  final String LOG_TAG = "myLogs";

  final int TASK1_CODE = 1;
  final int TASK2_CODE = 2;
  final int TASK3_CODE = 3;

  public final static int STATUS_START = 100;
  public final static int STATUS_FINISH = 200;

  public final static String PARAM_TIME = "time";
  public final static String PARAM_PINTENT = "pendingIntent";
  public final static String PARAM_RESULT = "result";

  TextView tvTask1;
  TextView tvTask2;
  TextView tvTask3;
  private Button button1;
  private Button secondProjectButton;
  private Button thirdClassButton;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    tvTask1 = findViewById(R.id.tvTask1);
    tvTask1.setText("Task1");
    tvTask2 = findViewById(R.id.tvTask2);
    tvTask2.setText("Task2");
    tvTask3 = findViewById(R.id.tvTask3);
    tvTask3.setText("Task3");

    button1 = findViewById(R.id.button1);
    button1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, FirstClass.class);
        startActivity(intent);
      }
    });

    secondProjectButton = findViewById(R.id.secondProjectButton);
    secondProjectButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, SECONDPROJECT.class);
        startActivity(intent);
      }
    });

    thirdClassButton = findViewById(R.id.thirdClassButton);
    thirdClassButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, ThirdClass.class);
        startActivity(intent);
      }
    });
  }

  public void onClickStart(View v) {
    Intent intent = new Intent(this, MyService.class);

    PendingIntent pendingIntent1 = createPendingResult(TASK1_CODE, new Intent(), 0);
    intent.putExtra(PARAM_TIME, 7).putExtra(PARAM_PINTENT, pendingIntent1);
    startService(intent);

    PendingIntent pi;

    pi = createPendingResult(TASK2_CODE, new Intent(), 0);
    intent = new Intent(this, MyService.class)
            .putExtra(PARAM_TIME, 4)
            .putExtra(PARAM_PINTENT, pi);
    startService(intent);

    pi = createPendingResult(TASK3_CODE, new Intent(), 0);
    intent = new Intent(this, MyService.class)
            .putExtra(PARAM_TIME, 6)
            .putExtra(PARAM_PINTENT, pi);
    startService(intent);
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    Log.d(LOG_TAG, "requestCode = " + requestCode + ", resultCode = " + resultCode);

    if (resultCode == STATUS_START) {
      switch (requestCode) {
        case TASK1_CODE:
          tvTask1.setText("Task1 start");
          break;
        case TASK2_CODE:
          tvTask2.setText("Task2 start");
          break;
        case TASK3_CODE:
          tvTask3.setText("Task3 start");
          break;
      }
    }

    if (resultCode == STATUS_FINISH) {
      int result = data.getIntExtra(PARAM_RESULT, 0);
      switch (requestCode) {
        case TASK1_CODE:
          tvTask1.setText("Task1 finish, result = " + result);
          break;
        case TASK2_CODE:
          tvTask2.setText("Task2 finish, result = " + result);
          break;
        case TASK3_CODE:
          tvTask3.setText("Task3 finish, result = " + result);
          break;
      }
    }
  }
}
