package com.example.admin.math123.core;

import java.util.Random;

public class lonbe {
    int a, a1, a2;
    int b, b1, b2;
    Random rd=new Random();
    String Sign1, Sign2;
    int x = rd.nextInt((1-0+1)+0);
    int S = rd.nextInt((3-0+1)+0);

    public void setData(){
        x = rd.nextInt((1-0+1)+0);
        S = rd.nextInt((3-0+1)+0);
        if(x == 0){
            a = rd.nextInt((1000-0+1)+0);
            b = rd.nextInt((1000-0+1)+0);
        }else if(x == 1 && S == 0){
            a1 = rd.nextInt((50-0+1)+0);
            a2 = rd.nextInt((50-0+1)+0);
            a = a1 + a2;
            b1 = rd.nextInt((50-0+1)+0);
            b2 = rd.nextInt((50-0+1)+0);
            b = b1 + b2;
        }else if(x == 1 && S == 1){
            a1 = rd.nextInt((50-0+1)+0);
            a2 = rd.nextInt((50-0+1)+0);
            a = a1 + a2;
            b1 = rd.nextInt((50-0+1)+0);
            b2 = rd.nextInt((50-0+1)+0);
            while(b2 > b1)
                b2 = rd.nextInt((50-0+1)+0);
            b = b1 - b2;
        }else if(x == 1 && S == 2) {
            a1 = rd.nextInt((50 - 0 + 1) + 0);
            a2 = rd.nextInt((50 - 0 + 1) + 0);
            while (a2 > a1)
                a2 = rd.nextInt((50 - 0 + 1) + 0);
            a = a1 - a2;
            b1 = rd.nextInt((50 - 0 + 1) + 0);
            b2 = rd.nextInt((50 - 0 + 1) + 0);
            b = b1 + b2;
        }else if(x == 1 && S == 3) {
            a1 = rd.nextInt((50 - 0 + 1) + 0);
            a2 = rd.nextInt((50 - 0 + 1) + 0);
            while (a2 > a1)
                a2 = rd.nextInt((50 - 0 + 1) + 0);
            a = a1 - a2;
            b1 = rd.nextInt((50 - 0 + 1) + 0);
            b2 = rd.nextInt((50 - 0 + 1) + 0);
            while(b2 > b1)
                b2 = rd.nextInt((50-0+1)+0);
            b = b1 - b2;
        }
    }

    public int Type(){
        return x;
    }

    public String getSign1(){
        switch (S){
            case 0:
                Sign1 = "+";
                break;
            case 1:
                Sign1 = "+";
                break;
            case 2:
                Sign1 = "-";
                break;
            case 3:
                Sign1 = "-";
                break;
        }
        return Sign1;
    }
    public String getSign2(){
        switch (S){
            case 0:
                Sign2 = "+";
                break;
            case 1:
                Sign2 = "-";
                break;
            case 2:
                Sign2 = "+";
                break;
            case 3:
                Sign2 = "-";
                break;
        }
        return Sign2;
    }

    public String getA() {

        return String.valueOf(a);
    }
    public String getA1() {

        return String.valueOf(a1);
    }
    public String getA2() {

        return String.valueOf(a2);
    }

    public String getB() {
        return String.valueOf(b);
    }
    public String getB1() {
        return String.valueOf(b1);
    }
    public String getB2() {
        return String.valueOf(b2);
    }

    public int result()
    {
        if(a > b) return 0;
        if(a == b) return 1;
        if(a < b) return 2;
        return 3;
    }
}
