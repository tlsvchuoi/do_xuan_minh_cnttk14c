package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Đặt nội dung của activity để dùng trong activity_main.xml layout
        setContentView(R.layout.activity_main);


        // Tìm View hiển thị danh mục Số
        TextView numbers = (TextView)findViewById(R.id.numbers);

        // Đặt một clicklistener vào View
        numbers.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                // Tạo intent mới để mở {@Link NumbersActivity}
                Intent numbersIntent = new Intent(MainActivity.this, NumbersActivity.class);

                // Bắt đầu activity mới
                startActivity(numbersIntent);
            }
        });

        // Tìm View hiển thị danh mục Gia đình
        TextView family = (TextView)findViewById(R.id.family);

        // Đặt một clicklistener vào View
        family.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                // Tạo intent mới để mở {@Link FamilyActivity}
                Intent familyIntent = new Intent(MainActivity.this, FamilyActivity.class);

                // Bắt đầu activity mới
                startActivity(familyIntent);
            }
        });

        // Tìm View hiển thị danh mục Màu sắc
        TextView colors = (TextView)findViewById(R.id.colors);

        // Đặt một clicklistener vào View
        colors.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                // Tạo intent mới để mở {@Link ColorsActivity}
                Intent colorsIntent = new Intent(MainActivity.this, ColorsActivity.class);

                // Bắt đầu activity mới
                startActivity(colorsIntent);
            }
        });

        // Tìm View hiển thị danh mục Mẫu câu
        TextView phrases = (TextView)findViewById(R.id.phrases);

        // Đặt một clicklistener vào View
        phrases.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                // Tạo intent mới để mở {@Link PhrasesActivity}
                Intent phrasesIntent = new Intent(MainActivity.this, PhrasesActivity.class);

                // Bắt đầu activity mới
                startActivity(phrasesIntent);
            }
        });
    }

}