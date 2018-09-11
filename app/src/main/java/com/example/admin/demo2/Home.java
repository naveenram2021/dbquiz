package com.example.admin.demo2;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Home extends AppCompatActivity {
    GridView gridView;
    ArrayList arrayList;
    ArrayAdapter arrayAdapter;

    private Typeface mTypeface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        gridView=findViewById(R.id.gridview);
        arrayList=new ArrayList();
        arrayList.add("Home");
        arrayList.add("Begin");
        arrayList.add("About");
        arrayList.add("Rate Us");
        arrayAdapter=new ArrayAdapter<String>(Home.this,android.R.layout.simple_list_item_1,arrayList)
        {
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
            TextView item = (TextView) super.getView(position,convertView,parent);

            item.setTypeface(mTypeface);
            item.setTextColor(Color.parseColor("#f7faf6"));
            item.setTypeface(item.getTypeface(), Typeface.BOLD);
            item.setTextSize(TypedValue.COMPLEX_UNIT_DIP,20);
            item.setGravity(Gravity.CENTER);
            item.setLayoutParams(new GridView.LayoutParams(350, 250));
            item.setBackgroundResource(R.drawable.border);
            return item;
        }};
        gridView.setAdapter(arrayAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==1){
                    Intent intent = new Intent(Home.this,Main2Activity.class);
                    startActivity(intent);
                }
            }
        });
    }
    boolean doubleBackToExitPressedOnce = false;
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
}
