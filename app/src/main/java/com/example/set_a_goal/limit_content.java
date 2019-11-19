package com.example.set_a_goal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class limit_content extends AppCompatActivity {
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_limit_content);

        Button b1=findViewById(R.id.back);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(limit_content.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
