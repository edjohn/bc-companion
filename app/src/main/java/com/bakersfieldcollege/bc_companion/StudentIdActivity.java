package com.bakersfieldcollege.bc_companion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;


public class StudentIdActivity extends AppCompatActivity
{
    private TextView student_id_textview;
    private TextView student_name_textview;
    private TextView student_email_textview;
    private ImageView barcode_imageview;
    private ImageView avatar_imageview;

    private StudentInfo studentInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_id);
        studentInfo = new StudentInfo(this);

        findViews();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        studentInfo = new StudentInfo(this);

        setViews();
    }

    public void openStudentInfoSettings(View view)
    {
        Intent studentInfoSettingsIntent = new Intent(this, StudentInfoSettingsActivity.class);
        startActivity(studentInfoSettingsIntent);
    }

    private void findViews()
    {
        student_id_textview = findViewById(R.id.student_id_textview);
        student_name_textview = findViewById(R.id.student_name_textview);
        student_email_textview = findViewById(R.id.student_email_textview);
        barcode_imageview = findViewById(R.id.barcode_imageview);
        avatar_imageview = findViewById(R.id.avatar_imageview);
    }

    private void setViews()
    {
        String studentId = studentInfo.getStudentId();
        String studentName = studentInfo.getStudentName();
        String studentEmail = studentInfo.getStudentEmail();

        student_id_textview.setText("@" + studentId);
        student_name_textview.setText(studentName);
        student_email_textview.setText(studentEmail + "@email.bakersfieldcollege.edu");
        if (!studentId.isEmpty())
        {
            barcode_imageview.setImageBitmap(generateBarcodeBitmap(studentId));
        }
        avatar_imageview.setImageResource(R.drawable.person_icon);
    }


    private Bitmap generateBarcodeBitmap(String input)
    {
        int barcodeWidth = 300;
        int barcodeHeight = 100;

        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        BitMatrix bitMatrix = null;
        try
        {
            bitMatrix = multiFormatWriter.encode(input, BarcodeFormat.CODE_39, barcodeWidth, barcodeHeight);
        } 
        catch (WriterException e)
        {
            e.printStackTrace();
        }
        BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
        return barcodeEncoder.createBitmap(bitMatrix);
    }
}