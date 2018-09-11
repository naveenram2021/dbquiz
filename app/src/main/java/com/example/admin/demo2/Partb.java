package com.example.admin.demo2;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class Partb extends Fragment {
    ListView lv;
    ArrayList<String> al;
    ArrayAdapter<String> ar;

    public Partb() {

    }
    private Typeface mTypeface;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_part,container,false);
        lv=v.findViewById(R.id.listview);
        al=new ArrayList<String>();
        al.add("FIGURES OF SPEECH");
        al.add("APPRECIATION QUESTIONS FROM POETRY");
        al.add("IMPORTANT LINES FROM POEMS");
        al.add("QUESTIONS ON THE BIOGRAPHY");
        al.add("QUESTIONS ON SHAKESPEARE'S WORKS");
        al.add("QUESTIONS FROM OSCAR WILDES WORKS");
        al.add("Dr.Karl Paulnack - MUSIC THE HOPE RAISER");
        al.add("COMPREHENSION QUESTIONS FROM MOTIVATIONAL ESSAYS");
        al.add("COMPREHENSION QUESTIONS FROM DESCRIPTION OF PLACES");
        al.add("BRITISH ENGLISH - AMERICAN ENGLISH");
        ar=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,al){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                TextView item = (TextView) super.getView(position,convertView,parent);
                item.setTypeface(mTypeface);
                item.setTextColor(Color.parseColor("#f7faf6"));
                item.setTypeface(item.getTypeface(), Typeface.BOLD);
                item.setTextSize(TypedValue.COMPLEX_UNIT_DIP,18);
                item.setGravity(Gravity.CENTER);
                return item;
            };};
        lv.setAdapter(ar);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if (position==1) {
                    Intent synonym = new Intent(getActivity(),Synonyms.class);
                    startActivity(synonym);

                }}
        });
        return v;
    }

}
