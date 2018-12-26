package com.example.admin.math123;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.admin.math123.core.CustomDialogResult;
import com.example.admin.math123.core.lonbe;

import java.util.Random;

import static com.example.admin.math123.settingActivity.musicEffectChecked;
import static com.example.admin.math123.settingActivity.musicfail;
import static com.example.admin.math123.settingActivity.musicsuccess;

public class LonbeActivity extends AppCompatActivity {
    lonbe Lonbe = new lonbe();
    int result = 3;
    int count = 1;
    int point = 0;
    int Layout = 2;
    boolean istest= false;
    TextView signview;
    TextView numbera;
    TextView numberb;
    Button btnless;
    Button btnequal;
    Button btngreater;
    Button btnnext;
    TextView countview;
    TextView pointView;
    Random rd=new Random();
    int type = rd.nextInt((1-0+1)+0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lonbe);
        Intent intenttest = getIntent();
        count = intenttest.getIntExtra("count",1);
        point = intenttest.getIntExtra("point",0);
        Layout = intenttest.getIntExtra("LayoutBaiTap",2);
        istest=intenttest.getBooleanExtra("istest",false);
        signview = (TextView)findViewById(R.id.SignView);
        numbera = (TextView)findViewById(R.id.numbera);
        numberb = (TextView)findViewById(R.id.numberb);
        btnless = (Button)findViewById(R.id.btnLesssign);
        btnequal = (Button)findViewById(R.id.btnEqualsign);
        btngreater = (Button)findViewById(R.id.btnGreatersign);
        btnnext = (Button)findViewById(R.id.btnNext);
        countview = (TextView)findViewById(R.id.countLonbe);
        countview.setText(String.valueOf(count));
        pointView = (TextView)findViewById(R.id.pointLonbe);
        countview.setText(String.valueOf("Câu "+count));
        pointView.setText(String.valueOf(point));
        randomType(type);
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count==10)
                {
                    Intent intent = new Intent(LonbeActivity.this,ResultActivity.class);
                    intent.putExtra("point",String.valueOf(point));
                    intent.putExtra("LayoutBaiTap",String.valueOf(Layout));
                    startActivity(intent);
                }
                else {
                    if(count==4&&istest)
                    {
                        Intent intent = new Intent(LonbeActivity.this, TinhnhamActivity.class);
                        intent.putExtra("point", point);
                        intent.putExtra("count", count + 1);
                        intent.putExtra("istest", istest);
                        startActivity(intent);
                    }
                    count = count + 1;
                    countview.setText(String.valueOf("Câu " + count));
                    activeButton(View.VISIBLE, View.INVISIBLE);
                    signview.setText("?");
                    randomType(type);
                }
            }
        });
    }

    public void onButtonClick(View v){
        switch (v.getId()){
            case R.id.btnLesssign:
                if(result==2) {
                    setReultWhenTrue();
                    signview.setText("<");
                }
                else
                    setResultWhenFalse();
                activeButton(View.INVISIBLE,View.VISIBLE);
                result=3;
                break;
            case R.id.btnEqualsign:
                if(result==1) {
                    setReultWhenTrue();
                    signview.setText("=");
                }
                else
                    setResultWhenFalse();
                activeButton(View.INVISIBLE,View.VISIBLE);
                result=3;
                break;
            case R.id.btnGreatersign:
                if(result==0) {
                    setReultWhenTrue();
                    signview.setText(">");
                }
                else
                    setResultWhenFalse();
                activeButton(View.INVISIBLE,View.VISIBLE);
                result=3;
                break;
        }
    }
    public void setResultWhenFalse()
    {
        if(result==0) signview.setText(">");
        if(result==1) signview.setText("=");
        if(result==2) signview.setText("<");
        if(musicEffectChecked)
        {
            musicfail.start();
        }
        CustomDialogResult dialog = new CustomDialogResult(LonbeActivity.this,false);
        dialog.showdialog();
    }
    public void setReultWhenTrue()
    {
        point +=10;
        pointView.setText(String.valueOf(point));
        if(musicEffectChecked)
        {
            musicsuccess.start();
        }
        CustomDialogResult dialog = new CustomDialogResult(LonbeActivity.this,true);
        dialog.showdialog();
    }
    public void activeButton(int enable,int visible)
    {
        btnless.setVisibility(enable);
        btnequal.setVisibility(enable);
        btngreater.setVisibility(enable);
        btnnext.setVisibility(visible);
    }

    public void randomType(int Type)
    {
        numbera.setText("");
        numberb.setText("");
        Lonbe.setData();
        result= Lonbe.result();
        type= Lonbe.Type();
        switch (Type){
            case 0:
                numbera.setText(Lonbe.getA());
                numberb.setText(Lonbe.getB());
                break;
            case 1:
                numbera.setText(Lonbe.getA1() + " " + Lonbe.getSign1() + " " + Lonbe.getA2());
                numberb.setText(Lonbe.getB1() + " " + Lonbe.getSign2() + " " + Lonbe.getB2());
        }
    }
}
