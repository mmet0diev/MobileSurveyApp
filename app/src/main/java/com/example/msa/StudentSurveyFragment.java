package com.example.msa;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.msa.Model.DBHelper;
import com.example.msa.Model.Survey;

import java.util.ArrayList;


public class StudentSurveyFragment extends Fragment {
    private ArrayList<Survey> current_surveys;

    public StudentSurveyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_student_surveys, container, false);

        LinearLayout layoutSurveys = view.findViewById(R.id.layoutSurveys);
        current_surveys = new DBHelper(getActivity()).get_surveyList();

        for (Survey survey : current_surveys) {
            TextView textView = new TextView(getActivity());
            textView.setText(survey.toString());
            textView.setPadding(16, 16, 16, 16);
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
            textView.setOnClickListener(v -> {
                Intent intent = new Intent(getActivity(), ActiveSurvey.class);
                intent.putExtra("title", survey.getTitle());
                startActivity(intent);
            });
            layoutSurveys.addView(textView);
        }

        return view;
    }
}
