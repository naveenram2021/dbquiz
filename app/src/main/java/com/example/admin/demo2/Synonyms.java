package com.example.admin.demo2;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

public class Synonyms extends AppCompatActivity {
    public static final String ALL_SECTIONS ="allsections";

    TextView t1,t2;
    RadioGroup rg1,rg2;
    RadioButton rb1,rb2,rb3,rb4;
    Button next;
    AlertDialog.Builder alertdialog;
    ColorStateList textcolorDefaultRb;

    private List<Question> questionList;
    private Question currentQuestion;
    private int questionCounter;
    private int questionCountTotal;
    private boolean answered;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_synonyms);
        t1=findViewById(R.id.textView2);
        t2=findViewById(R.id.textView3);
        rg1=findViewById(R.id.radiogroup1);
        rg2=findViewById(R.id.radiogroup2);
        rb1=findViewById(R.id.radioButton);
        rb2=findViewById(R.id.radioButton2);
        rb3=findViewById(R.id.radioButton3);
        rb4=findViewById(R.id.radioButton4);
        next=findViewById(R.id.button4);

        textcolorDefaultRb=rb1.getTextColors();
        Intent intent=getIntent();
        //String section = intent.getStringExtra(Part.ALL_SECTIONS);

        QuizDbHelper dbHelper = new QuizDbHelper(this);
        questionList = dbHelper.getSections(getIntent().getStringExtra(ALL_SECTIONS));
        questionCountTotal=questionList.size();
        Collections.shuffle(questionList);
        showNextQuestion();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!answered) {
                    if (rb1.isChecked() || rb2.isChecked() || rb3.isChecked() || rb4.isChecked()) {
                        checkAnswer();
                    } else {
                        Toast.makeText(Synonyms.this, "Please select an answer", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    showNextQuestion();
                }
            }
        });
    }

    private void showNextQuestion() {
        rb1.setTextColor(textcolorDefaultRb);
        rb2.setTextColor(textcolorDefaultRb);
        rb3.setTextColor(textcolorDefaultRb);
        rb4.setTextColor(textcolorDefaultRb);
        rg1.clearCheck();
        if (questionCounter < questionCountTotal) {
            currentQuestion = questionList.get(questionCounter);
            t1.setText(currentQuestion.getQuestion());
            rb1.setText(currentQuestion.getOption1());
            rb2.setText(currentQuestion.getOption2());
            rb3.setText(currentQuestion.getOption3());
            rb4.setText(currentQuestion.getOption4());
            questionCounter++;
            answered=false;
            next.setText("Confirm");
        }
        else {
            finishQuiz();
        }
    }

    private void checkAnswer() {
        answered = true;
        RadioButton rbSelected = findViewById(rg1.getCheckedRadioButtonId());
        int answerNr = rg1.indexOfChild(rbSelected) + 1;
        if (answerNr == currentQuestion.getAnswerNr()) {
            score++;
        }

        showSolution();
    }

    private void showSolution() {
        rb1.setTextColor(Color.RED);
        rb2.setTextColor(Color.RED);
        rb3.setTextColor(Color.RED);
        rb4.setTextColor(Color.RED);

        switch (currentQuestion.getAnswerNr()) {
            case 1:
                rb1.setTextColor(Color.GREEN);
                Toast.makeText(this, "Option A is Correct", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                rb2.setTextColor(Color.GREEN);
                Toast.makeText(this, "Option B is Correct", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                rb3.setTextColor(Color.GREEN);
                Toast.makeText(this, "Option C is Correct", Toast.LENGTH_SHORT).show();
                break;
            case 4:
                rb4.setTextColor(Color.GREEN);
                Toast.makeText(this, "Option D is Correct", Toast.LENGTH_SHORT).show();
                break;
        }
        if (questionCounter < questionCountTotal) {
            next.setText("Next");
        } else {
            next.setText("Finish");
        }
    }

    private void finishQuiz() {
        alertdialog = new AlertDialog.Builder(Synonyms.this);
        alertdialog.setTitle("Thanks for attending the quiz");
        alertdialog.setMessage("Your Score is:" +score);
        alertdialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        alertdialog.show();
    }
}
