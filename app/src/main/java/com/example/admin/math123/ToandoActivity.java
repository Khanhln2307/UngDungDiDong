package com.example.admin.math123;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.admin.math123.core.CustomDialogResult;
import com.example.admin.math123.core.toando;

import java.util.Locale;
import java.util.Random;

import static com.example.admin.math123.settingActivity.musicEffectChecked;
import static com.example.admin.math123.settingActivity.musicSpeechChecked;
import static com.example.admin.math123.settingActivity.musicfail;
import static com.example.admin.math123.settingActivity.musicsuccess;

public class ToandoActivity extends AppCompatActivity {

    toando ToanDo = new toando();
    int result = 1;
    int count = 1;
    int point = 0;
    int Layout = 5;
    boolean istest = false;
    TextView ContentText;
    TextView countview;
    TextView pointView;
    TextView CachGiai;
    Button btnDapAnA;
    Button btnDapAnB;
    Button btnDapAnC;
    Button btnDapAnD;
    Button btnnext;
    TextToSpeech toSpeech;

    Random rd=new Random();
    int type = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toando);
        Intent intenttest = getIntent();
        count = intenttest.getIntExtra("count",1);
        point = intenttest.getIntExtra("point",0);
        Layout = intenttest.getIntExtra("LayoutBaiTap",5);
        istest=intenttest.getBooleanExtra("istest",false);
        ContentText = (TextView)findViewById(R.id.Content);
        btnDapAnA = (Button)findViewById(R.id.btnDapAnA);
        btnDapAnB = (Button)findViewById(R.id.btnDapAnB);
        btnDapAnC = (Button)findViewById(R.id.btnDapAnC);
        btnDapAnD = (Button)findViewById(R.id.btnDapAnD);
        btnnext = (Button)findViewById(R.id.btnNext);
        pointView = (TextView)findViewById(R.id.pointlogic);
        countview = (TextView)findViewById(R.id.countlogic);
        countview.setText(String.valueOf("Câu " + count));
        CachGiai = (TextView)findViewById(R.id.CachGiai);
        pointView.setText(String.valueOf(point));
        randomType(type);
        ContentText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(musicSpeechChecked)
                {
                    toSpeech = new TextToSpeech(ToandoActivity.this, new TextToSpeech.OnInitListener() {
                        @Override
                        public void onInit(int status) {
                            if(status != TextToSpeech.ERROR){
                                toSpeech.setLanguage(new Locale("vi","VN"));
                                toSpeech.speak(ContentText.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
                            }
                        }
                    });
                }
            }
        });
        CachGiai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(musicSpeechChecked)
                {
                    toSpeech = new TextToSpeech(ToandoActivity.this, new TextToSpeech.OnInitListener() {
                        @Override
                        public void onInit(int status) {
                            if(status != TextToSpeech.ERROR){
                                toSpeech.setLanguage(new Locale("vi","VN"));
                                toSpeech.speak(CachGiai.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
                            }
                        }
                    });
                }
            }
        });
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count==10)
                {
                    Intent intent = new Intent(ToandoActivity.this,ResultActivity.class);
                    intent.putExtra("point",String.valueOf(point));
                    intent.putExtra("LayoutBaiTap",String.valueOf(Layout));
                    startActivity(intent);
                }
                else {
                    if(count==8&&istest)
                    {
                        Intent intent = new Intent(ToandoActivity.this, testActivity.class);
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
            switch (v.getId()){
                case R.id.btnDapAnA:
                    if(result == 0) {
                        setReultWhenTrue();
                    }
                    else
                        setResultWhenFalse();
                    activeButton(View.INVISIBLE,View.VISIBLE);

                    result=4;
                    break;
                case R.id.btnDapAnB:
                    if(result==1) {
                        setReultWhenTrue();
                    }
                    else
                        setResultWhenFalse();
                    activeButton(View.INVISIBLE,View.VISIBLE);
                    result=4;
                    break;
                case R.id.btnDapAnC:
                    if(result==2) {
                        setReultWhenTrue();
                    }
                    else
                        setResultWhenFalse();
                    activeButton(View.INVISIBLE,View.VISIBLE);
                    result=4;
                    break;
                case R.id.btnDapAnD:
                    if(result==3) {
                        setReultWhenTrue();
                    }
                    else
                        setResultWhenFalse();
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
        CustomDialogResult dialog = new CustomDialogResult(ToandoActivity.this,true);
        dialog.showdialog();
    }

    public void setResultWhenFalse()
    {
        if(musicEffectChecked)
        {
            musicfail.start();
        }
        CustomDialogResult dialog = new CustomDialogResult(ToandoActivity.this,false);
        dialog.showdialog();
    }

    public void activeButton(int enable,int visible)
    {
        btnDapAnA.setVisibility(enable);
        btnDapAnB.setVisibility(enable);
        btnDapAnC.setVisibility(enable);
        btnDapAnD.setVisibility(enable);
        btnnext.setVisibility(visible);
        CachGiai.setVisibility(visible);
        ContentText.setVisibility(View.INVISIBLE);
    }

    public void randomType(int Type)
    {
        ToanDo = new toando();
        ContentText.setText("");
        btnDapAnA.setText("");
        btnDapAnB.setText("");
        btnDapAnC.setText("");
        btnDapAnD.setText("");
        ToanDo.setData();
        ToanDo.setMauCau();
        result= ToanDo.getResult();
        Type= ToanDo.getType();
        type = Type;

        ContentText.setText(ToanDo.getContent());
        ContentText.setVisibility(View.VISIBLE);

        CachGiai.setText(ToanDo.getCachGiai());

        ToanDo.setResultToButton(btnDapAnA,btnDapAnB,btnDapAnC,btnDapAnD);
    }
}
