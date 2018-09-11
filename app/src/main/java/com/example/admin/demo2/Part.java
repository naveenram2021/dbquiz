package com.example.admin.demo2;


import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class Part extends Fragment {
    public static final String ALL_SECTIONS ="allsections";

    ListView lv;
    ArrayList<String> al;
    ArrayAdapter<String> ar;
    Typeface mTypeface;
    ImageView imageView;


    public Part() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_part,container,false);
        lv=v.findViewById(R.id.listview);
        imageView=v.findViewById(R.id.imageView3);
        //getContext().getAssets();
        //mTypeface=Typeface.createFromAsset(getContext().getAssets(),"fonts/");
        String[] diffsections = Question.getallsections();
        ArrayAdapter<String> adaptersections = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, diffsections);
        lv.setAdapter(adaptersections);
        al=new ArrayList<String>();
        al.add("PHRASES AND THEIR MEANINGS");
        al.add("SYNONYMS");
        al.add("ANTONYMS");
        al.add("PREFIX,SUFFIX");
        al.add("ARTICLE");
        al.add("PREPOSITION");
        al.add("QUESTION TAG");
        al.add("SELECT THE CORRECT TENSE");
        al.add("SELECT THE CORRECT VOICE");
        al.add("INFINITIVE,GERUND,PARTICIPLE");
        al.add("SENTENCE PATTERN");
        al.add("ERROR SPOTTING");
        al.add("COMPREHENSION");
        al.add("SELECT THE CORRECT SENTENCE");
        al.add("FIND OUT THE WORDS");
        al.add("SELECT THE CORRECT PLURAL FORMS");
        al.add("SIMPLE,COMPOUND,COMPLEX");
        al.add("IDENTIFY THE CORRECT DEGREE");
        al.add("BLENDING THE WORDS");
        al.add("COMPOUND WORDS");
        ar=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,al){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
            TextView item = (TextView) super.getView(position,convertView,parent);


                item.setTypeface(mTypeface);
                item.setTextColor(Color.parseColor("#f7faf6"));
                item.setTypeface(item.getTypeface(), Typeface.BOLD);
                item.setTextSize(TypedValue.COMPLEX_UNIT_DIP,18);
                item.setGravity(Gravity.START);

                return item;
        }};
        lv.setAdapter(ar);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
              //String se= lv.getSelectedItem().toString();
                    //String sections = lv.getSelectedItem().toString();
                    //synonym.putExtra(ALL_SECTIONS,sections);
            switch (position){
                case 0:
                    Intent synonym = new Intent(getActivity(), Synonyms.class);
                    synonym.putExtra(ALL_SECTIONS,"Synonyms");
                    startActivity(synonym);
                    break;

                case 1:
                    Intent antonym = new Intent(getActivity(),Synonyms.class);
                    antonym.putExtra(ALL_SECTIONS,"Antonyms");
                    startActivity(antonym);
                    break;

                case 2:
                    Intent prefix = new Intent(getActivity(),Synonyms.class);
                    prefix.putExtra(ALL_SECTIONS,"Prefix");
                    startActivity(prefix);
                    break;
            }

            }
        });
        return v;
    }

}
