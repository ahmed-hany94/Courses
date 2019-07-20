package com.arkdev.courses;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText emailEditText, passEditText;
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init UI Components
        initUI();

        // Todo: validate Input and Add Sign Up Activity

        loginBtn.setOnClickListener(this);
    }

    void initUI(){
        emailEditText = findViewById(R.id.email_edit_text);
        passEditText = findViewById(R.id.passwd_edit_text);
        loginBtn = findViewById(R.id.login_btn);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login_btn:
                /* Todo: Check if empty
                    Authenticate
                    SignUp activity + validate
                 */
                Intent intent = new Intent(this, CoursesListActivity.class);
                startActivity(intent);
        }
    }
}
