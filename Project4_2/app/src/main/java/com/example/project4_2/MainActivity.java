package com.example.project4_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CheckBox select;
    TextView selectAnimal;
    RadioGroup Rgroup;
    RadioButton Rdog;
    RadioButton Rcat;
    RadioButton Rrabbit;
    Button btnOk;

    ImageView imgDog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        select = (CheckBox) findViewById(R.id.startChect);
        selectAnimal = (TextView) findViewById((R.id.selectAnimal));
        Rgroup = (RadioGroup) findViewById(R.id.Rgroup);
        Rdog = (RadioButton) findViewById(R.id.RdoDog);
        Rcat = (RadioButton) findViewById(R.id.RdoCat);
        Rrabbit = (RadioButton) findViewById(R.id.RdoRabbit);
        btnOk = (Button) findViewById(R.id.selectcomplete);

        imgDog = (ImageView) findViewById(R.id.imgDog);



    }
}