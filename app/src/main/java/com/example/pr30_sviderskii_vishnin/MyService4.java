package com.example.pr30_sviderskii_vishnin;

import android.content.Intent;
import android.app.IntentService;
import android.app.PendingIntent;

public class MyService4 extends IntentService {

    public MyService4() {
        super("MyService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        PendingIntent pendingIntent = intent.getParcelableExtra("pendingIntent");
        if (pendingIntent != null) {
            // Имитация выполнения задачи в сервисе
            try {
                Thread.sleep(3000); // Задержка в 3 секунды для имитации работы
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Отправляем результаты работы сервиса обратно в активность
            Intent resultIntent = new Intent();
            resultIntent.putExtra("result", "Task completed successfully");
            try {
                pendingIntent.send(this, ThirdClass.RESULT_OK, resultIntent);
            } catch (PendingIntent.CanceledException e) {
                e.printStackTrace();
            }
        }
    }
}