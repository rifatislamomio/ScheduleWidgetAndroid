package com.example.mywidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.widget.RemoteViews;

import java.util.Calendar;


public class WidgetProvied extends AppWidgetProvider {
    Calendar calendar ;

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds)
        {
            calendar = Calendar.getInstance();


            Intent intent = new Intent(context,MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context,0,intent,0);
            RemoteViews views = new RemoteViews(context.getPackageName(),R.layout.widget_layout);
            views.setOnClickPendingIntent(R.id.gonext,pendingIntent);
            int day = calendar.get(Calendar.DAY_OF_WEEK);
            if(day==Calendar.SATURDAY || day == Calendar.THURSDAY)
            {
                views.setInt(R.id.ben,"setTextColor", Color.parseColor("#FF1744")); //today
            }
            else if (day==Calendar.FRIDAY || day == Calendar.WEDNESDAY)
            {
                views.setInt(R.id.ben,"setTextColor",Color.parseColor("#FFEA00")); //tom
            }
            else
            {
                views.setInt(R.id.ben,"setTextColor",Color.WHITE);
            }

            if (day==Calendar.THURSDAY)
            {
                views.setInt(R.id.androlab,"setTextColor", Color.parseColor("#FF1744"));
            }
            else if(day==Calendar.WEDNESDAY)
            {
                views.setInt(R.id.androlab,"setTextColor",Color.parseColor("#FFEA00"));
            }
            else
            {
                views.setInt(R.id.androlab,"setTextColor",Color.WHITE);
            }

            if(day==Calendar.MONDAY || day == Calendar.WEDNESDAY)
            {
                views.setInt(R.id.andro,"setTextColor", Color.parseColor("#FF1744")); //today
            }
            else if (day==Calendar.SUNDAY || day == Calendar.TUESDAY)
            {
                views.setInt(R.id.andro,"setTextColor",Color.parseColor("#FFEA00")); //tom
            }
            else
            {
                views.setInt(R.id.andro,"setTextColor",Color.WHITE);
            }


            if (day==Calendar.MONDAY)
            {
                views.setInt(R.id.jrdes,"setTextColor", Color.parseColor("#FF1744"));
            }
            else if(day==Calendar.SUNDAY)
            {
                views.setInt(R.id.jrdes,"setTextColor",Color.parseColor("#FFEA00"));
            }
            else
            {
                views.setInt(R.id.jrdes,"setTextColor",Color.WHITE);
            }

            appWidgetManager.updateAppWidget(appWidgetId,views);
        }
    }
}
