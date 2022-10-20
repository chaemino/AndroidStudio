package com.example.projecta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton good_btn;
    ImageButton bad_btn;
    boolean setfav;
    TextView good;
    TextView bad;

    Button review_btn;
    Button review_all;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("씨네마천국");

        good_btn = (ImageButton)findViewById(R.id.btn1);
        bad_btn = (ImageButton)findViewById(R.id.btn2);
        good = (TextView)findViewById(R.id.num_good);
        bad = (TextView)findViewById(R.id.num_bad);

        review_btn = (Button)findViewById(R.id.review_btn);
        review_all = (Button)findViewById(R.id.review_all_btn);


        good_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int countGood = Integer.parseInt((String) good.getText());
                if(!setfav) {
                    good_btn.setImageResource(R.drawable.ic_thumb_up_selected);
                    good.setText(Integer.toString(++countGood));
                }else {
                    good_btn.setImageResource(R.drawable.ic_thumb_up);
                    good.setText(Integer.toString(--countGood));
                }
                setfav = !setfav;
            }
        });
        bad_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int countBad = Integer.parseInt((String) bad.getText());
                if(!setfav) {
                    bad_btn.setImageResource(R.drawable.ic_thumb_down_selected);
                    bad.setText(Integer.toString(++countBad));
                }else {
                    bad_btn.setImageResource(R.drawable.ic_thumb_down);
                    bad.setText(Integer.toString(--countBad));
                }
                setfav = !setfav;
            }
        });
        review_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "작성하기", Toast.LENGTH_SHORT).show();
            }
        });
        review_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "모두 보기", Toast.LENGTH_SHORT).show();
            }
        });










    }
}