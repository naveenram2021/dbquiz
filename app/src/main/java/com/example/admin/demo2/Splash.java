package com.example.admin.demo2;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class Splash extends AppCompatActivity {
    TextView tv;
    Typeface typ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        tv=findViewById(R.id.textView);
        typ=Typeface.createFromAsset(getAssets(),"fonts/LobsterTwo-BoldItalic.otf");
        tv.setTypeface(typ);
        getSupportActionBar().hide();
        Logo logo=new Logo();
        logo.start();
    }
    private class Logo extends Thread{
        public void run(){
            try{
                sleep(3000);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
            Intent intent=new Intent(Splash.this, Home.class);
            startActivity(intent);
            Splash.this.finish();
        }
    }
}
