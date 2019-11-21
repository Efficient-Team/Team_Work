package com.example.set_a_goal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import java.util.Calendar;

public class TimePickerActivity extends AppCompatActivity  implements View.OnClickListener, TimePickerDialog.OnTimeSetListener{
    private TextView select_time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker);

        Button b1 = findViewById(R.id.back);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TimePickerActivity.this, AddContent.class);
                startActivity(intent);
            }
        });

        select_time = (TextView)findViewById(R.id.select_time);
        findViewById(R.id.btn_time).setOnClickListener(this);
    }

    public void onClick (View v){
        if (v.getId() == R.id.btn_time) {
            Calendar calendar = Calendar.getInstance();
            TimePickerDialog dialog = new TimePickerDialog(this, this, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true);
            dialog.show();
        }
    }

    @Override
    public void onTimeSet (TimePicker view,int hourOFDAY, int minute){
        String desc = String.format("您选择的时间是%d时%d分", hourOFDAY, minute);
        select_time.setText(desc);
    }

}




