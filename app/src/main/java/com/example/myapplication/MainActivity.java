package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    ImageView imageView;
    int[] PHOTO = {R.drawable.photo1,R.drawable.photo2,R.drawable.photo3,
            R.drawable.photo4,R.drawable.photo5,R.drawable.photo6,
            R.drawable.photo7,R.drawable.photo8,R.drawable.photo9,
            R.drawable.photo10
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText)findViewById(R.id.editTextTextPersonName);
        imageView = findViewById(R.id.imageView);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence text, int start, int before, int count) {
                //text  输入框中改变后的字符串信息
                //start 输入框中改变后的字符串的起始位置
                //before 输入框中改变前的字符串的位置 默认为0
                //count 输入框中改变后的一共输入字符串的数量
                change_photo();

            }

            @Override
            public void beforeTextChanged(CharSequence text, int start, int count,int after) {
                //text  输入框中改变前的字符串信息
                //start 输入框中改变前的字符串的起始位置
                //count 输入框中改变前后的字符串改变数量一般为0
                //after 输入框中改变后的字符串与起始位置的偏移量



            }

            @Override
            public void afterTextChanged(Editable edit) {
                //edit  输入结束呈现在输入框中的信息


            }
        });
    }
    public void change_photo(){
        try {
            int num = Integer.parseInt(editText.getText().toString());
            imageView.setImageResource(PHOTO[num-1]);
        }
        catch (Exception e){
            Toast.makeText(this, "PLEASE INPUT CORRECT NUMBER", Toast.LENGTH_LONG).show();
        }
    }
}