package com.example.project7_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    ImageView imageView;
    //RelativeLayout baseLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("제주도 풍경");

        imageView = (ImageView) findViewById(R.id.imageView);
        editText = (EditText) findViewById(R.id.editView);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_1, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        try {
            switch (item.getItemId()) {
                case R.id.menu1:
                    imageView.setRotation(Integer.parseInt(editText.getText().toString()));
                    return true;
                case R.id.hanra:
                    item.setChecked(true);
                    imageView.setImageResource(R.drawable.testimage);
                    return true;
                case R.id.chu:
                    item.setChecked(true);
                    imageView.setImageResource(R.drawable.chu);
                    return true;
                case R.id.bum:
                    item.setChecked(true);
                    imageView.setImageResource(R.drawable.bum);
                    return true;
            }
        }catch (Exception e){
            Toast.makeText(this.getApplicationContext(), "회전 시킬 만큼의 각도를 입력하세요.", Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}