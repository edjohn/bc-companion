package com.bakersfieldcollege.bc_companion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openStudentIdView(View view)
    {
        Intent studentIdIntent = new Intent(this, StudentIdActivity.class);
        startActivity(studentIdIntent);
    }

    public void openClassScheduleView(View view)
    {
        Intent classScheduleIntent = new Intent(this, ClassScheduleActivity.class);
        startActivity(classScheduleIntent);
    }

    public void openCourseHistoryView(View view)
    {
        Intent courseHistoryIntent = new Intent(this, CourseHistoryActivity.class);
        startActivity(courseHistoryIntent);
    }

    public void openEventCalendarView(View view)
    {
        Intent eventCalendarIntent = new Intent(this, EventCalendarActivity.class);
        startActivity(eventCalendarIntent);
    }

    public void openOnlineResourcesView(View view)
    {
        Intent onlineResourcesIntent = new Intent(this, OnlineResourcesActivity.class);
        startActivity(onlineResourcesIntent);
    }

    public void openMapView(View view)
    {
        Intent openMapIntent = new Intent(this, MapActivity.class);
        startActivity(openMapIntent);
    }

}