package com.example.pr30_sviderskii_vishnin;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdClass extends Activity {

    private TextView statusTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thirdclass);

        statusTextView = findViewById(R.id.statusTextView);

        Button startServiceButton = findViewById(R.id.startServiceButton);
        startServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService();
            }
        });
    }

    private void startService() {
        // Создаем PendingIntent для связи с этим Activity
        Intent intent = new Intent(this, MyService4.class);
        PendingIntent pendingIntent = createPendingResult(1, intent, 0);

        // Передаем PendingIntent в сервис для обработки
        Intent serviceIntent = new Intent(this, MyService4.class);
        serviceIntent.putExtra("pendingIntent", pendingIntent);
        startService(serviceIntent);
    }

    // Получаем результаты из сервиса через метод onActivityResult
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK && data != null) {
                String result = data.getStringExtra("result");
                statusTextView.setText(result);
            }
        }
    }
}
