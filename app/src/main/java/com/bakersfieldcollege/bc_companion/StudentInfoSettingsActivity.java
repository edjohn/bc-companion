package com.bakersfieldcollege.bc_companion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

public class StudentInfoSettingsActivity extends AppCompatActivity
{
    private String studentIdInput;
    private String studentNameInput;
    private String studentEmailInput;

    private EditText studentIdField;
    private EditText studentNameField;
    private EditText studentEmailField;

    private ImageView avatarImageView;

    StudentInfo studentInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info_settings);
        studentInfo = new StudentInfo(this);

        findViews();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        updateViews();
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        saveInput();
    }

    private void findViews()
    {
        studentIdField = findViewById(R.id.student_id_field);
        studentNameField = findViewById(R.id.student_name_field);
        studentEmailField = findViewById(R.id.student_email_field);
        avatarImageView = findViewById(R.id.avatar_imageview);
    }

    private void updateViews()
    {
        studentIdInput = studentInfo.getStudentId();
        studentNameInput = studentInfo.getStudentName();
        studentEmailInput = studentInfo.getStudentEmail();

        studentIdField.setText(studentIdInput);
        studentNameField.setText(studentNameInput);
        studentEmailField.setText(studentEmailInput);

        avatarImageView.setImageResource(R.drawable.person_icon);
    }

    private void saveInput()
    {
        studentIdInput = studentIdField.getText().toString();
        studentNameInput = studentNameField.getText().toString();
        studentEmailInput = studentEmailField.getText().toString();

        studentInfo.setStudentId(studentIdInput);
        studentInfo.setStudentName(studentNameInput);
        studentInfo.setStudentEmail(studentEmailInput);
    }
}