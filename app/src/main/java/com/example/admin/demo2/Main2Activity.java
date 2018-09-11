package com.example.admin.demo2;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    TextView tv;
    Typeface tyf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().hide();
        tv=findViewById(R.id.textView7);
        tyf=Typeface.createFromAsset(getAssets(),"fonts/LobsterTwo-BoldItalic.otf");
        tv.setTypeface(tyf);
    }

    public void partA(View view) {
        Intent intent=new Intent(Main2Activity.this,MainActivity.class);
        intent.putExtra("pas",0);
        startActivity(intent);
    }
    public void PartB(View view) {
        Intent intent=new Intent(Main2Activity.this,MainActivity.class);
        intent.putExtra("pas",1);
        startActivity(intent);
    }

    public void PartC(View view) {
        Intent intent=new Intent(Main2Activity.this,MainActivity.class);
        intent.putExtra("pas",2);
        startActivity(intent);
    }
}
