package com.example.msa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.msa.Model.DBHelper;
import com.example.msa.Model.User;

import java.util.ArrayList;

public class LoginScreen extends AppCompatActivity {

    private ArrayList<User> current_users;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
    }

    public void onLogin(View view) {
        /* Check login credentials */
        EditText login_user = findViewById(R.id.luserinput);
        EditText login_pass = findViewById(R.id.lpassinput);
        String u_name = login_user.getText().toString();
        String u_pass = login_pass.getText().toString();

        if (u_name.isEmpty() || u_pass.isEmpty())
            Toast.makeText(this, "All input fields need to be filled", Toast.LENGTH_LONG).show();
        else {
            if (checkIfValidLogin(u_name, u_pass) == 0) {
                if(user.getIsAdmin() == 0) {
                    startActivity(new Intent(this, StudentPane.class));
                    Toast.makeText(this, "Logged in", Toast.LENGTH_LONG).show();
                }
                if(user.getIsAdmin() == 1){
                    startActivity(new Intent(this, AdminPane.class));
                    Toast.makeText(this, "Logged in", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(this, "Invalid login credentials", Toast.LENGTH_LONG).show();
            }
        }
    }

    // return 0: login combination valid
    private int checkIfValidLogin(String u_name, String u_pass) {
        current_users = new DBHelper(this).get_userList();
        for (User u : current_users) {
            if (u.getLoginName().equals(u_name) && u.getPassword().equals(u_pass)) {
                user = u;
                return 0;
            }
        }
        return -1;
    }
}