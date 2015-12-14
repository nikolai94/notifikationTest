package com.example.nikolai.notifications_test;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClickButton(View view){
        //(MainActivity.class) - åbner appen hvis du klikker på notifikationer
        Intent intent = new Intent(this,MainActivity.class);
        //Intent intent = new Intent();

        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,0);

        //setSmallIcon skal være 18*18 pixels
        Notification noti = new Notification.Builder(this)
        .setTicker("Vigtig vigtig")
        .setContentTitle("Husk der er Brøndby kamp")
        .setContentText("Dette er meget vigtigt!")
        .setSmallIcon(R.drawable.bif)
        .setContentIntent(pendingIntent).getNotification();
        noti.flags = Notification.FLAG_AUTO_CANCEL;

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0,noti);

    }

}
