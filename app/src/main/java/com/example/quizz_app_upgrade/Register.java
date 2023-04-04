package com.example.quizz_app_upgrade;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.ktx.Firebase;

public class Register extends AppCompatActivity {

    TextInputEditText registernick, registeremail, registerpassword;
    Button Registerbutt;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        EditText registernick = findViewById(R.id.nickname);
        EditText registerpassword = findViewById(R.id.registerpassword);
        EditText registeremail = findViewById(R.id.registeremail);
        Button Registerbutt = findViewById(R.id.registration_button);
        Button To_login = findViewById(R.id.to_login);
        String email, password, nick;

        email = registeremail.getText().toString();
        password = registerpassword.getText().toString();
        nick = registernick.getText().toString();

        To_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent switchActivityIntent = new Intent(Register.this, Login.class);
                startActivity(switchActivityIntent);
            }
        });

        Registerbutt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
               if(TextUtils.isEmpty(email) || TextUtils.isEmpty(nick) || TextUtils.isEmpty(password)) {
                    Toast.makeText(Register.this,  "enter data", Toast.LENGTH_LONG).show();
                }

                mAuth.createUserWithEmailAndPassword(registeremail.getText().toString(), registerpassword.getText().toString())
                        .addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Toast.makeText(Register.this, "Authentication succes.",
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(Register.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });

            }
        });
    }
}