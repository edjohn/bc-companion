package com.bakersfieldcollege.bc_companion;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;

public class StudentInfo
{
    private String studentInfoKey;
    private String studentIdKey;
    private String studentNameKey;
    private String studentEmailKey;

    private String studentId;
    private String studentName;
    private String studentEmail;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Resources resources;

    StudentInfo(Context context)
    {
        resources = context.getResources();
        sharedPreferences = context.getSharedPreferences(studentInfoKey, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        setKeys();
        setValues();
    }

    private void setKeys()
    {
        studentInfoKey = resources.getString(R.string.student_info_key);
        studentIdKey = resources.getString(R.string.student_id_key);
        studentNameKey = resources.getString(R.string.student_name_key);
        studentEmailKey = resources.getString(R.string.student_email_key);
    }

    private void setValues()
    {
        studentId = sharedPreferences.getString(studentIdKey, "");
        studentName = sharedPreferences.getString(studentNameKey, "");
        studentEmail = sharedPreferences.getString(studentEmailKey, "");
    }

    public String getStudentId()
    {
        return studentId;
    }

    public String getStudentName()
    {
        return studentName;
    }

    public String getStudentEmail()
    {
        return studentEmail;
    }

    public void setStudentId(String studentId)
    {
        editor.putString(studentIdKey, studentId).apply();
        studentId = sharedPreferences.getString(studentIdKey, "");
    }

    public void setStudentName(String studentName)
    {
        editor.putString(studentNameKey, studentName).apply();
        studentName = sharedPreferences.getString(studentNameKey, "");
    }

    public void setStudentEmail(String studentEmail)
    {
        editor.putString(studentEmailKey, studentEmail).apply();
        studentEmail = sharedPreferences.getString(studentEmailKey, "");
    }
}
