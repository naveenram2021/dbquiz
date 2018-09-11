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


public class PartC extends Fragment {
    ListView lv;
    ArrayList<String> al;
    ArrayAdapter<String> ar;

    public PartC() {

    }
    private Typeface mTypeface;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_part,container,false);
        lv=v.findViewById(R.id.listview);
        al=new ArrayList<String>();
        al.add("MATCH THE POEMS WITH THE POETS");
        al.add("NATIONALITY THE STORY BELONGS TO");
        al.add("IDENTIFY THE AUTHOR WITH THE SHORT STORY");
        al.add("AUTO-BIOGRAPHY/BIOGRAPHY");
        al.add("NATIONALITY THE POET BELONGS TO");
        al.add("CHARACTERS,QUOTES,IMPORTANT LINES FROM WORKS OF INDIAN AUTHORS");
        al.add("DRAMA FAMOUS LINES,CHARACTERS,QUOTES");
        al.add("MATCH THE PLACES,POET,DRAMATIST");
        al.add("FOLK ARTS AND THEIR RESPECTIVE STATES");
        al.add("MATCH THE AUTHOR WITH RELEVANT TITLE,CHARACTER");
        al.add("MATCH THE CHARACTER WITH RELEVANT STORY TITLE");
        al.add("ABOUT THE POETS");
        al.add("ABOUT THE DRAMATISTS");
        al.add("MENTION THE POEM IN WHICH THESE LINES OCCUR");
        al.add("VARIOUS WORKS OF THE FOLLOWING AUTHORS");
        al.add("THEME OBSERVED IN THE LITERARY WORKS");
        al.add("FAMOUS QUOTES");
        al.add("PERIOD TO WHICH THE POET BELONGS TO");
        al.add("MATCH THE POETS AND POEMS");
        al.add("NATURE CENTERED LITERARY WORKS");
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
