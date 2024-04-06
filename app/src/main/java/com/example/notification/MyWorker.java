package com.example.notification;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.example.notification.utils.NotificationUtil;

/**
 * переодические уведомления
 * */
public class MyWorker extends Worker {

    public MyWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        NotificationUtil
                .getInstance()
                .showNotification(getApplicationContext()
                ,"Time to have a cup of tea"
                , "innit");

        return Result.success();
    }


}
