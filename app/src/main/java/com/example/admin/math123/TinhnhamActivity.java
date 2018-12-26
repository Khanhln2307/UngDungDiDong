package com.example.admin.math123;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.admin.math123.core.CustomDialogResult;
import com.example.admin.math123.core.tinhnham;

import static com.example.admin.math123.settingActivity.musicEffectChecked;
import static com.example.admin.math123.settingActivity.musicfail;
import static com.example.admin.math123.settingActivity.musicsuccess;

public class TinhnhamActivity extends AppCompatActivity {

    tinhnham TinhNham = new tinhnham();
    int result = 1;
    int count = 1;
    int point = 0;
    int Layout = 4;
    boolean istest = false;
    TextView numbera;
    TextView countview;
    TextView pointView;
    Button btnDapAnA;
    Button btnDapAnB;
    Button btnDapAnC;
    Button btnDapAnD;
    Button btnnext;
    int type = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinhnham);
        Intent intenttest = getIntent();
        count = intenttest.getIntExtra("count",1);
        point = intenttest.getIntExtra("point",0);
        Layout = intenttest.getIntExtra("LayoutBaiTap",4);
        istest=intenttest.getBooleanExtra("istest",false);
        numbera = (TextView)findViewById(R.id.numbera);
        btnDapAnA = (Button)findViewById(R.id.btnDapAnA);
        btnDapAnB = (Button)findViewById(R.id.btnDapAnB);
        btnDapAnC = (Button)findViewById(R.id.btnDapAnC);
        btnDapAnD = (Button)findViewById(R.id.btnDapAnD);
        btnnext = (Button)findViewById(R.id.btnNext);
        pointView = (TextView)findViewById(R.id.pointTinhNham);
        countview = (TextView)findViewById(R.id.countTinhnham);
        countview.setText(String.valueOf("Câu " + count));
        pointView.setText(String.valueOf(point));
        randomType(type);
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count==10)
                {
                    Intent intent = new Intent(TinhnhamActivity.this,ResultActivity.class);
                    intent.putExtra("point",String.valueOf(point));
                    intent.putExtra("LayoutBaiTap",String.valueOf(Layout));
                    startActivity(intent);
                }
                else {
                    if(count==6&&istest)
                    {
                        Intent intent = new Intent(TinhnhamActivity.this, ToandoActivity.class);
                        intent.putExtra("point", point);
                        intent.putExtra("count", count + 1);
                        intent.putExtra("istest", istest);
                        startActivity(intent);
                    }
                    count = count + 1;
                    countview.setText(String.valueOf("Câu " + count));
                    activeButton(View.VISIBLE, View.INVISIBLE);
                    randomType(type);
                }
            }
        });
    }
    public void onButtonClick(View v){
        if(type != 3)
            switch (v.getId()){
                case R.id.btnDapAnA:
                    if(result == 0) {
                        setReultWhenTrue();
                    }
                    else
                        setResultWhenFalse();
                    setResultContent();
                    activeButton(View.INVISIBLE,View.VISIBLE);
                    result=4;
                    break;
                case R.id.btnDapAnB:
                    if(result==1) {
                        setReultWhenTrue();
                    }
                    else
                        setResultWhenFalse();
                    setResultContent();
                    activeButton(View.INVISIBLE,View.VISIBLE);
                    result=4;
                    break;
                case R.id.btnDapAnC:
                    if(result==2) {
                        setReultWhenTrue();
                    }
                    else
                        setResultWhenFalse();
                    setResultContent();
                    activeButton(View.INVISIBLE,View.VISIBLE);
                    result=4;
                    break;
                case R.id.btnDapAnD:
                    if(result==3) {
                        setReultWhenTrue();
                    }
                    else
                        setResultWhenFalse();
                    setResultContent();
                    activeButton(View.INVISIBLE,View.VISIBLE);
                    result=4;
                    break;
            }
        else
            switch (v.getId()){
                case R.id.btnDapAnA:
                    if(result == 0)
                        setReultWhenTrue();
                    else
                        setResultWhenFalse();
                    setResultContent();
                    activeButton(View.INVISIBLE,View.VISIBLE);
                    result=4;
                    break;
                case R.id.btnDapAnB:
                    if(result == 1) {
                        setReultWhenTrue();
                    }
                    else
                        setResultWhenFalse();
                    setResultContent();
                    activeButton(View.INVISIBLE,View.VISIBLE);
                    result=4;
                    break;
                case R.id.btnDapAnC:
                    if(result == 2)
                        setReultWhenTrue();
                    else
                        setResultWhenFalse();
                    setResultContent();
                    activeButton(View.INVISIBLE,View.VISIBLE);
                    result=4;
                    break;
                case R.id.btnDapAnD:
                    if(result == 3) {
                        setReultWhenTrue();
                    }
                    else
                        setResultWhenFalse();
                    setResultContent();
                    activeButton(View.INVISIBLE,View.VISIBLE);
                    result=4;
                    break;
            }
    }

    public void setReultWhenTrue()
    {
        point +=10;
        pointView.setText(String.valueOf(point));
        if(musicEffectChecked)
        {
            musicsuccess.start();
        }
        CustomDialogResult dialog = new CustomDialogResult(TinhnhamActivity.this,true);
        dialog.showdialog();
    }

    public void setResultWhenFalse()
    {
        if(musicEffectChecked)
        {
            musicfail.start();
        }
        CustomDialogResult dialog = new CustomDialogResult(TinhnhamActivity.this,false);
        dialog.showdialog();
    }
    public void activeButton(int enable,int visible)
    {
        btnDapAnA.setVisibility(enable);
        btnDapAnB.setVisibility(enable);
        btnDapAnC.setVisibility(enable);
        btnDapAnD.setVisibility(enable);
        btnnext.setVisibility(visible);
    }

    public void randomType(int Type)
    {
        TinhNham = new tinhnham();
        numbera.setText("");
        btnDapAnA.setText("");
        btnDapAnB.setText("");
        btnDapAnC.setText("");
        btnDapAnD.setText("");
        TinhNham.setData();
        TinhNham.setSign();
        TinhNham.randomResult();
        result= TinhNham.getResult();
        Type= TinhNham.getType();
        type = Type;

        TinhNham.setResultToButton(btnDapAnA,btnDapAnB,btnDapAnC,btnDapAnD);
        switch (Type){
            case 0:
                numbera.setText(TinhNham.getA() + " " + TinhNham.getSign() + " " + TinhNham.getB() + "\n= ?");
                btnDapAnD.setVisibility(View.VISIBLE);
                break;
            case 1:
                numbera.setText("? " + TinhNham.getSign() + " " + TinhNham.getB() + "\n= " + TinhNham.getC());
                btnDapAnD.setVisibility(View.VISIBLE);
                break;
            case 2:
                numbera.setText(TinhNham.getA() + " " + TinhNham.getSign() + " ?" + "\n= " + TinhNham.getC());
                btnDapAnD.setVisibility(View.VISIBLE);
                break;
            case 3:
                numbera.setText(TinhNham.getA() + " ?" + " " + TinhNham.getB() + "\n= " + TinhNham.getC());
                btnDapAnD.setVisibility(View.INVISIBLE);
                break;
        }
    }

    public void setResultContent(){
        numbera.setText(TinhNham.getA() + " " + TinhNham.getSign() + " " + TinhNham.getB() + "\n= " + TinhNham.getC());
    }
}
