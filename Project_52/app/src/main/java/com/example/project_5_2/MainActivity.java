package com.example.project_5_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button btn;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);

        LinearLayout baseLayout = new LinearLayout(this);
        baseLayout.setOrientation((LinearLayout.VERTICAL));
        baseLayout.setBackgroundColor(Color.WHITE);
        setContentView(baseLayout, params);

        editText = new EditText(this);
        editText.setTextSize(20);
        editText.setTextColor(Color.BLACK);
        editText.setBackgroundTintList(ColorStateList.valueOf(Color.BLACK));

        btn = new Button(this);
        btn.setBackgroundColor(Color.YELLOW);
        btn.setText("버튼입니다");
        btn.setTextColor(Color.BLACK);

        textView = new TextView(this);
        textView.setTextSize(20);
        textView.setTextColor(Color.MAGENTA);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(editText.getText());
            }
        });

        baseLayout.addView(editText);
        baseLayout.addView(btn);
        baseLayout.addView(textView);

    }
}