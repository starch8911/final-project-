package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FoodList extends AppCompatActivity {
    private Button btn_Menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);
        btn_Menu=findViewById(R.id.btn_Menu);

        btn_Menu.setOnClickListener(new View.OnClickListener() {   //按鈕返回菜單
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(FoodList.this ,MainActivity.class);
                startActivity(intent);
            }
        });




    }
}