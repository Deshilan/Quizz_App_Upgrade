package com.example.quizz_app_upgrade;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main_menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Button main_menu_to_do_quiz = findViewById(R.id.main_menu_to_do_quiz);
        Button main_menu_to_make_quiz = findViewById(R.id.main_menu_to_make_quiz);
        Button main_menu_log_out = findViewById(R.id.main_menu_log_out);

        main_menu_log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}