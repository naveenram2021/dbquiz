package com.example.admin.demo2;

import android.os.Handler;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int u =getIntent().getIntExtra("pas",0);
        switch (u){
            case 0:
                FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fram,new Part()).commit();
                break;
            case 1:
                FragmentTransaction ft2=getSupportFragmentManager().beginTransaction();
                ft2.replace(R.id.fram,new Partb()).commit();
                break;
            case 2:
                FragmentTransaction ft3=getSupportFragmentManager().beginTransaction();
                ft3.replace(R.id.fram,new PartC()).commit();
                break;
        }
    }
}

