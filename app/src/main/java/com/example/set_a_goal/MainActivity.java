package com.example.set_a_goal;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Telephony;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.*;
import java.text.SimpleDateFormat;

import static android.provider.Telephony.*;

public class MainActivity extends AppCompatActivity {
    private Button mBtnaddgoal;
    private  TextView textView;
    private Handler handler;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnaddgoal=findViewById(R.id.btn_add_goal);
        mBtnaddgoal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(MainActivity.this,AddContent.class);
                startActivity(intent);
            }
        });
        //获取时间日期
        textView=(TextView)findViewById(R.id.tv_time);

        handler=new Handler(){
            public void handleMessage(Message msg) {
                textView.setText((String) msg.obj);
            }
        };
        Threads thread=new Threads();
        thread.start();
    }
    class  Threads extends Thread{
        @Override
        public  void run(){
            try{
                while(true){
                    SimpleDateFormat sdf=new SimpleDateFormat("YYYY年MM月dd日   HH:mm:ss   EEEE",Locale.CHINA);
                    sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));//格林尼治时间，北京东八区
                    String str=sdf.format(new Date());
                    handler.sendMessage(handler.obtainMessage(100,str));
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }    //获取时间日期结束





        }
    }













}


