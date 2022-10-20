package com.example.project6_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Chronometer chronometer;

    RadioGroup radioGroup;
    RadioButton btnDate;
    RadioButton btnTime;

    TimePicker timePicker;
    DatePicker datePicker;

    TextView tvYear;
    TextView tvMonth;
    TextView tvDay;
    TextView tvHour;
    TextView tvMinute;

    private int selectYear, selectMonth, selectDay, selecthour, selectminute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectYear=0;
        selectMonth=0;
        selectDay=0;
        selecthour=0;
        selectminute = 0;

        setTitle("시간 예약");

        chronometer = (Chronometer) findViewById(R.id.chStart);

        radioGroup = (RadioGroup) findViewById(R.id.radio);
        btnDate = (RadioButton) findViewById(R.id.rdoCal);
        btnTime = (RadioButton) findViewById(R.id.rdoTime);

        timePicker = (TimePicker) findViewById(R.id.timeP);
        datePicker = (DatePicker) findViewById(R.id.dateP);
        tvYear = (TextView) findViewById(R.id.tvYear);
        tvMonth = (TextView) findViewById((R.id.tvMonth));
        tvDay = (TextView) findViewById((R.id.tvDay));
        tvHour = (TextView) findViewById((R.id.tvhour));
        tvMinute = (TextView) findViewById((R.id.tvmin));

        // [예약에 걸린 시간] 선택 시 타이머 시작, 선택 버튼 visible
        chronometer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioGroup.setVisibility(View.VISIBLE);
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
            }
        });
        // 날짜, 시간 각각 선택 시 그에 맞는 time picker, date picker 화면 visible
        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePicker.setVisibility(View.INVISIBLE);
                datePicker.setVisibility(View.VISIBLE);
            }
        });
        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePicker.setVisibility(View.VISIBLE);
                datePicker.setVisibility(View.INVISIBLE);
            }
        });
        // 연도 길게 선택 시 타이머 멈춤
        tvYear.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                chronometer.stop();
                Toast.makeText(getApplicationContext(), "timer stop", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // date picker 날짜 선택 시
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
                @Override
                public void onDateChanged(DatePicker datePicker, int year, int month, int day) {
                    selectYear = year;
                    selectMonth = month;
                    selectDay = day;

                    tvYear.setText(Integer.toString(selectYear));
                    tvMonth.setText(Integer.toString(selectMonth));
                    tvDay.setText(Integer.toString(selectDay));
                }
            });
        }
        // time picker 시간 선택 시
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int hour, int minute) {
                selecthour = hour;
                selectminute = minute;

                tvHour.setText(Integer.toString(selecthour));
                tvMinute.setText(Integer.toString(selectminute));
            }
        });
    }
}