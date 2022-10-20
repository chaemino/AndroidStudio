package com.example.radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2;
    EditText Edit_text;
    RadioGroup radioGroup;
    RadioButton radioBtn1, radioBtn2;
    ImageView imageView1, imageView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        Edit_text = (EditText) findViewById(R.id.Edit_text);
        radioBtn1 = (RadioButton) findViewById(R.id.radioBtn1);
        radioBtn2 = (RadioButton) findViewById(R.id.radioBtn2);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        imageView1 = (ImageView) findViewById((R.id.imageView1));
        imageView2 = (ImageView) findViewById((R.id.imageView2));

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, Edit_text.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(Edit_text.getText().toString()));
                startActivity(mIntent);
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.radioBtn1:
                        imageView1.setVisibility(View.VISIBLE);
                        imageView2.setVisibility(View.INVISIBLE);
                        break;
                    case R.id.radioBtn2:
                        imageView2.setVisibility(View.VISIBLE);
                        imageView1.setVisibility(View.INVISIBLE);
                        break;
                }
            }
        });

    }
}