package com.example.spotifyloginui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText memail,mpassword;
    ImageButton eyetoggle;
    android.widget.Button mlogin,mloginwithoutpassword;

    boolean show=true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getSupportActionBar().setElevation(0);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ColorDrawable colorDrawable=new ColorDrawable(Color.parseColor("#121212"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#121212'></font>"));




        memail=findViewById(R.id.mail_edit_text);
        mpassword=findViewById(R.id.password_edit_text);
        eyetoggle=findViewById(R.id.passwordtoggle);
        mlogin=findViewById(R.id.loginbtn);
        mloginwithoutpassword=findViewById(R.id.loginwithoutbtn);



        eyetoggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(show)
                {
                    show=false;
                    eyetoggle.setImageResource(R.drawable.ic_baseline_visibility_off_24);
                    mpassword.setTransformationMethod(new PasswordTransformationMethod());
                }
                else
                {
                    show=true;
                    eyetoggle.setImageResource(R.drawable.ic_baseline_visibility_24);
                    mpassword.setTransformationMethod(null);
                }
            }
        });


        mlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Login Done",Toast.LENGTH_SHORT).show();
            }
        });

        mloginwithoutpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Login Without Password is Clicked",Toast.LENGTH_SHORT).show();
            }
        });


        memail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus)
                {
                    memail.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.edittextfocus));
                    mpassword.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.edittextbg));

                }
            }
        });


        mpassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus)
                {
                    memail.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.edittextbg));
                    mpassword.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.edittextfocus));

                }
            }
        });


        mpassword.addTextChangedListener(loginTextWatcher);
        memail.addTextChangedListener(loginTextWatcher);


    }


    private TextWatcher loginTextWatcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            String emailinput,passwordinput;
            emailinput=memail.getText().toString().trim();
            passwordinput=mpassword.getText().toString().trim();

            if(!emailinput.isEmpty() && !passwordinput.isEmpty())
            {
                mlogin.setEnabled(true);
                mlogin.setClickable(true);
                mlogin.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.loginenabled));

            }
            else
            {
                mlogin.setEnabled(false);
                mlogin.setClickable(false);
                mlogin.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.logindisabled));


            }

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };



}

