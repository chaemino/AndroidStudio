package com.example.fourbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button bu1;
    Button bu2;
    Button bu3;
    Button bu4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bu1 = (Button) findViewById(R.id.bu1);
        bu1.setBackgroundColor(Color.GRAY);
        bu1.setTextColor(Color.BLACK);
        bu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inten = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
                startActivity(inten);
            }
        });

        bu2 = (Button) findViewById(R.id.bu2);
        bu2.setBackgroundColor(Color.GREEN);
        bu2.setTextColor(Color.BLACK);
        bu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inten = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:/911"));
                startActivity(inten);
            }
        });

        bu3 = (Button) findViewById(R.id.bu3);
        bu3.setBackgroundColor(Color.RED);
        bu3.setTextColor(Color.BLACK);
        bu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inten = new Intent(Intent.ACTION_VIEW, Uri.parse("content://media/internal/images/media"));
                startActivity(inten);
            }
        });

        bu4 = (Button) findViewById(R.id.bu4);
        bu4.setBackgroundColor(Color.YELLOW);
        bu4.setTextColor(Color.BLACK);
        bu4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}