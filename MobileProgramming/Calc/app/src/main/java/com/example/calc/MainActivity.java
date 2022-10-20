package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText num1;
    EditText num2;
    Button butp;
    Button butm;
    Button butmu;
    Button butd;
    TextView textResult;

    String n1;
    String n2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = (EditText) findViewById(R.id.num1);
        num2 = (EditText) findViewById(R.id.num2);

        butp = (Button) findViewById(R.id.butP);
        butm = (Button) findViewById(R.id.butMi);
        butmu = (Button) findViewById(R.id.butMu);
        butd = (Button) findViewById(R.id.butD);

        textResult = (TextView) findViewById(R.id.result);

        butp.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Calculate("+", num1, num2);
                return false;
            }
        });
        butm.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Calculate("-", num1, num2);
                return false;
            }
        });
        butmu.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Calculate("*", num1, num2);
                return false;
            }
        });
        butd.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                try {
                    Calculate("/", num1, num2);
                } catch (ArithmeticException e) {
                    textResult.setText("0으로 나눌 수 없습니다.");
                }
                return false;
            }
        });
    }
    void Calculate(String operator, EditText num1, EditText num2) {
        long result = 0;

        if (TextUtils.isEmpty(num1.getText().toString()) || TextUtils.isEmpty(num2.getText().toString())) {
            textResult.setText("숫자를 입력하세요.");
            return;
        }

        String number1 = num1.getText().toString();
        String number2 = num2.getText().toString();

        // overflow**
        long firstNum = Long.parseLong(number1);
        long secondNum = Long.parseLong(number2);

        switch (operator) {
            case "+":
                result = firstNum+secondNum;
                break;
            case "-":
                result = firstNum-secondNum;
                break;

            case "*":
                result = Math.multiplyExact(firstNum, secondNum);
                break;
            case "/":
                result = firstNum/secondNum;
                break;
            default:
        }
        String print = Long.toString(result);
        textResult.setText("계산 결과: " + print);
    }
}
