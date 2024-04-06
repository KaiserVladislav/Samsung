package com.example.notification.utils;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.notification.MainActivity;
import com.example.notification.R;

public class NotificationUtil {

    /** singleton - архитектурный паттерн
     * иногда нам нужен всего один объект класса а другие не появлялись
     * */
    private NotificationUtil() {

    }

    /**
     * там где используется static память выделяется в начале программы
     * */
    private static NotificationUtil instance;

    public static NotificationUtil getInstance() {
        if (instance == null) {
            instance = new NotificationUtil();
        }
        return instance;
    }

    public int a = 0;

    public int increaseA() {
        return ++a;
    }

    private static final String CHANNEL_ID = "NOT_ID";
    private static final String CHANNEL_NAME = "NOT_NAME";
    private static final int NOTIFICATION_ID = 1;

    /**
     * область памяти работующая с уведомлениями
     *
     * */
    public void createNotificationChannel(Context context) {
        NotificationManager notificationManager =
                (NotificationManager) context
                        .getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationChannel channel =
                new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_LOW);
        channel.enableVibration(true);
        channel.enableLights(true);
        notificationManager.createNotificationChannel(channel);
    }

    /**
     * пустой интент это тема
     * */
    public void showNotification(Context context, String title, String description) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra("text1", "AVIASALES - cheap tickets");
        PendingIntent pendingIntent = PendingIntent
                .getActivity(context, 0, intent, PendingIntent.FLAG_IMMUTABLE);
        /**
         * F1 колеса с синей полосочкой антидождевые
         * Builder вложенный класс для постепенного создания объекта по частям
         * для постепенной передачи аргументов
         * */


        /**
         * можно в notification пихнуть xml
         * */
        Notification notification = new Notification.Builder(context, CHANNEL_ID)
                .setContentTitle(title+" "+increaseA())
                .setContentText(description)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setPriority(Notification.PRIORITY_DEFAULT)
                .setCategory(NotificationCompat.CATEGORY_EVENT)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .setVibrate(new long[]{500,1000})
                .build(); // false - имба

        /**
         * помощник для менеджера
         * вызывает уведомление на экран
         */
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        notificationManagerCompat.notify(NOTIFICATION_ID, notification);
    }
}
