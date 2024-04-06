package com.example.notification;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.Operation;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.notification.utils.NotificationUtil;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        NotificationUtil.getInstance().increaseA();
        Log.d("A IS INCREASED", ""+NotificationUtil.getInstance().increaseA());
        Log.d("A IS INCREASED", ""+NotificationUtil.getInstance().increaseA());
        Log.d("A IS INCREASED", ""+NotificationUtil.getInstance().increaseA());
        Log.d("A IS INCREASED", ""+NotificationUtil.getInstance().increaseA());

         */

        /**
         * норм тема хорошее отступление от темы
         * **/
        Base base = new Base.Builder()
                .setA(1)
                .setB(2)
                .setC("3")
                .build();

        Button button = findViewById(R.id.button);
        /**
         * чтобы оно не создавалось несколько раз используем синглтон
         */
        NotificationUtil.getInstance().createNotificationChannel(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationUtil
                        .getInstance()
                        .showNotification(getApplicationContext(),
                                "Have you done your assignment?",
                                "JERK");

                PeriodicWorkRequest workRequest = new PeriodicWorkRequest
                        .Builder(MyWorker.class,30, TimeUnit.MINUTES)
                        .build();

                WorkManager workManager = WorkManager.getInstance(getApplicationContext());

                Operation enqueue = workManager
                        .enqueueUniquePeriodicWork("NOT"
                                , ExistingPeriodicWorkPolicy.REPLACE
                                , workRequest);


            }
        });

        askNotificationPermission();
        askVibratePermission();
        WorkManager.getInstance(getApplicationContext()).cancelAllWork();
    }

    /**
     *
     * */
    private final ActivityResultLauncher<String> requestPermissionLauncher =
            registerForActivityResult(new ActivityResultContracts.RequestPermission(),
                    isGranted -> {
                        if(isGranted){
                            Toast.makeText(this, "OKAY", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(this, "NOT OKAY", Toast.LENGTH_SHORT).show();
                        }
                    }
            );

    private void askNotificationPermission(){
        requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS);
    }

    private void askVibratePermission(){
        requestPermissionLauncher.launch(Manifest.permission.VIBRATE);
    }



}