package com.example.badwordsprevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {
    Button show;
    EditText et_word;
    String myword;
    TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show= findViewById(R.id.btn_show);
        et_word= findViewById(R.id.et_word);
        tv_result=findViewById(R.id.tv_result);

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myword = et_word.getText().toString();
                List<String> words = Arrays.asList("يلعنك", "bad", "كلب");

                for (String word : words) {
                    Pattern rx = Pattern.compile("\\b" + word + "\\b", Pattern.CASE_INSENSITIVE);
                    myword = rx.matcher(myword).replaceAll(new String(new char[word.length()]).replace('\0', '*'));


                }
                tv_result.setText(myword);

            }
        });
    }
}