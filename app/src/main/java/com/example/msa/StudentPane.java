package com.example.msa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.msa.Model.DBHelper;
import com.example.msa.Model.Survey;

import java.util.ArrayList;

public class StudentPane extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_pane);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.student_view_container, new StudentSurveyFragment())
                .commit();
    }

    public void viewAnswers(View view){
        Intent intent = new Intent(this, ActivityStudentAnswers.class);
        startActivity(intent);
    }

    public void logOut(View view){
        Toast.makeText(this, "Logged out", Toast.LENGTH_LONG).show();
        finish();
        return;
    }
}
