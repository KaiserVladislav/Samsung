package com.example.notification;

import android.graphics.Bitmap;

public class Base {

    int a;
    int b;
    String c;

    private Base(){

    }

    static class Builder{
        private Base base;
        public Builder(){
            base = new Base();

        }

        public Builder setA(int a){
            base.a=a;
            return this;
        }

        public Builder setB(int b){
            base.b=b;
            return this;
        }

        public Builder setC(String c){
            base.c=c;
            return this;
        }
        public Base build(){
            return base;
        }

    }
}
