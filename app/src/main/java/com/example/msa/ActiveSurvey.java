package com.example.msa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.msa.Model.Answer;
import com.example.msa.Model.DBHelper;
import com.example.msa.Model.DBModel;
import com.example.msa.Model.Question;

import java.util.ArrayList;

public class ActiveSurvey extends AppCompatActivity {

    /**
     * 1: strongly agree
     * 2: agree
     * 3: neither agree/disagree
     * 4: disagree
     * 5: strongly disagree
     */

    private int question_num = 1;
    private DBModel dbModel;
    private ArrayList<Question> questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_survey);

        dbModel = new DBModel(this);
        questions = new DBHelper(this).get_questionList();
        ((TextView) findViewById(R.id.questiontxt)).setText(questions.get(question_num - 1).toString());
        Bundle extras = getIntent().getExtras();
        ((TextView) findViewById(R.id.surveytitletxt)).setText(extras.getString("title"));
    }

    public void onNext(View view) {
        if (question_num < 10) {

            if (((RadioButton) findViewById(R.id.rb1)).isChecked()) {
                dbModel.addAnswer(new Answer(-1, 1));
                question_num++;
                ((TextView) findViewById(R.id.questiontxt)).setText(questions.get(question_num - 1).toString());
            } else if (((RadioButton) findViewById(R.id.rb2)).isChecked()) {
                dbModel.addAnswer(new Answer(-1, 2));
                question_num++;
                ((TextView) findViewById(R.id.questiontxt)).setText(questions.get(question_num - 1).toString());
            } else if (((RadioButton) findViewById(R.id.rb3)).isChecked()) {
                dbModel.addAnswer(new Answer(-1, 3));
                question_num++;
                ((TextView) findViewById(R.id.questiontxt)).setText(questions.get(question_num - 1).toString());
            } else if (((RadioButton) findViewById(R.id.rb4)).isChecked()) {
                dbModel.addAnswer(new Answer(-1, 4));
                question_num++;
                ((TextView) findViewById(R.id.questiontxt)).setText(questions.get(question_num - 1).toString());
            } else if (((RadioButton) findViewById(R.id.rb5)).isChecked()) {
                dbModel.addAnswer(new Answer(-1, 5));
                question_num++;
                ((TextView) findViewById(R.id.questiontxt)).setText(questions.get(question_num - 1).toString());
            } else {
                Toast.makeText(this, "No answer checked!", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, "Survey completed", Toast.LENGTH_LONG).show();
            finish();
            return;
        }
    }

    public void onPrev(View view) {
        Toast.makeText(this, "Question Already answered", Toast.LENGTH_LONG).show();
    }
}