package com.bhadresh.navigationappdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class OverPeding extends AppCompatActivity {
//    private Button move;
    ImageView btnB;
    ImageView btnF;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_over_peding);

        btnB=findViewById(R.id.btnIvOCam);


//        move=findViewById(R.id.btnOverCam);
        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OverPeding.this, CameraActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.right_to_left,R.anim.slide_out_right);

            }
        });

        btnF=findViewById(R.id.btnIvOtoMain);
        btnF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OverPeding.this,MainActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);            }
        });
    }
}