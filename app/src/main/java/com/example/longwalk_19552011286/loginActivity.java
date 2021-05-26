package com.example.longwalk_19552011286;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity implements View.OnClickListener {
    private Button nextBtn;
    private EditText firstName;
    private EditText lastName;
    public String strFirstName, strLastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        //Get Element
        nextBtn = (Button)findViewById(R.id.login__btnNext);
        nextBtn.setOnClickListener(loginActivity.this);
        firstName = (EditText)findViewById(R.id.login__inputFirstName);
        lastName = (EditText)findViewById(R.id.login__inputLastName);

        firstName.addTextChangedListener(nameTextWatch);
        lastName.addTextChangedListener(nameTextWatch);
    }

    private TextWatcher nameTextWatch = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            strFirstName = firstName.getText().toString().trim();
            strLastName = lastName.getText().toString().trim();
            if(!strFirstName.isEmpty() && !strLastName.isEmpty()){
                nextBtn.setEnabled(true);
            } else {
                nextBtn.setEnabled(false);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    @Override
    public void onClick(View v){
        if(strFirstName.length() > 10 || strLastName.length() > 10){
            Toast.makeText(this, "Name too long! Maximum 10 character!", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!strFirstName.matches("[A-Za-z]+") || !strLastName.matches("[A-Za-z]+")) {
            Toast.makeText(this, "Name contain number!", Toast.LENGTH_SHORT).show();
            return;
        }
        String passFullName = strFirstName + " " + strLastName;
        Intent homeIntent = new Intent(loginActivity.this, homeActivity.class);
        homeIntent.putExtra("fullName", passFullName);
        startActivity(homeIntent);
        finish();
    }
}