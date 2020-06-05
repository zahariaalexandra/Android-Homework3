package com.example.homework3.Fragments;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;

import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.homework3.Entities.ToDo;
import com.example.homework3.R;
import com.example.homework3.Utils.AlarmBroadcast;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

public class NotificationFragment extends Fragment {

    private ToDo toDo;
    private DatePicker datePicker;
    private TimePicker timePicker;
    private Button btnSetAlarm;

    public NotificationFragment(ToDo toDo) {
        this.toDo = toDo;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification, container, false);

        datePicker = view.findViewById(R.id.datePicker);
        timePicker = view.findViewById(R.id.timePicker);
        timePicker.setIs24HourView(true);
        btnSetAlarm = view.findViewById(R.id.btnSetAlarm);

        btnSetAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int day = datePicker.getDayOfMonth();
                int month = datePicker.getMonth();
                int year = datePicker.getYear();
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month, day);
                Date date = calendar.getTime();

                int hour = timePicker.getCurrentHour();
                int minute = timePicker.getCurrentMinute();

            }
        });

        return view;
    }

    private void setAlarm (Notification notification , int delay) {
        Intent notificationIntent = new Intent( getActivity(), AlarmBroadcast.class) ;
        notificationIntent.putExtra(AlarmBroadcast. NOTIFICATION_ID , 1 ) ;
        notificationIntent.putExtra(AlarmBroadcast. NOTIFICATION , notification) ;
        PendingIntent pendingIntent = PendingIntent. getBroadcast ( getContext(), 0 , notificationIntent , PendingIntent. FLAG_UPDATE_CURRENT ) ;
        long futureInMillis = SystemClock. elapsedRealtime () + delay ;
        AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(Context. ALARM_SERVICE ) ;
        assert alarmManager != null;
        alarmManager.set(AlarmManager. ELAPSED_REALTIME_WAKEUP , futureInMillis , pendingIntent) ;
    }
}
