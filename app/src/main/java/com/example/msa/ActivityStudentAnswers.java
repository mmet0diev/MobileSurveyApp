package com.example.msa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.msa.Model.Answer;
import com.example.msa.Model.DBHelper;
import com.example.msa.Model.DBModel;

import java.util.ArrayList;
import java.util.List;

public class ActivityStudentAnswers extends AppCompatActivity {

    private ArrayList<Answer> answers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_answers_listview);

        answers = new DBHelper(this).get_answerList();

        ListView answerListView = findViewById(R.id.answerlistview);
        SurveyAnswerAdapter adapter = new SurveyAnswerAdapter(this, answers);
        answerListView.setAdapter(adapter);
    }

    public class SurveyAnswerAdapter extends ArrayAdapter<Answer> {

        public SurveyAnswerAdapter(Context context, ArrayList<Answer> answers) {
            super(context, 0, answers);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Get the data item for this position
//            Answer answer = getItem(position);

            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_student_answers_rows, parent, false);
            }

            // Lookup views for data population
            TextView[] answerTextViews = new TextView[10];
            answerTextViews[0] = convertView.findViewById(R.id.answer1);
            answerTextViews[1] = convertView.findViewById(R.id.answer2);
            answerTextViews[2] = convertView.findViewById(R.id.answer3);
            answerTextViews[3] = convertView.findViewById(R.id.answer4);
            answerTextViews[4] = convertView.findViewById(R.id.answer5);
            answerTextViews[5] = convertView.findViewById(R.id.answer6);
            answerTextViews[6] = convertView.findViewById(R.id.answer7);
            answerTextViews[7] = convertView.findViewById(R.id.answer8);
            answerTextViews[8] = convertView.findViewById(R.id.answer9);
            answerTextViews[9] = convertView.findViewById(R.id.answer10);

            // Populate the data into the template views using the data object
            if (answers != null && answers.size() > 0) {
                int endIndex = Math.min(answers.size(), answerTextViews.length);
                for (int i = endIndex - 1, j = 0; i >= 0 && j < answerTextViews.length; i--, j++) {
                    answerTextViews[j].setText(answers.get(i).toString());
                }
            } else {
                for (TextView answerTextView : answerTextViews) {
                    answerTextView.setText("No answers yet");
                }
            }

            // Return the completed view to render on screen
            return convertView;
        }
    }
}

