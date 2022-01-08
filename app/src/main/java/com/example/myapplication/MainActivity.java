package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    class Data{
        int photo;
        String name;
    }
    public class  MyAdapter extends  BaseAdapter{
        private MainActivity.Data[] data ;
        private int view ;
        public MyAdapter(MainActivity.Data[] data, int view){
            this.data=data;
            this.view=view;
        }
        @Override
        public int getCount(){
            return data.length;
        }
        @Override
        public Object getItem(int position){
            return data[position];
        }
        @Override
        public long getItemId(int position){
            return 0;
        }
        @Override
        public View getView(int position, View covertView, ViewGroup parent){

            covertView=getLayoutInflater().inflate(view,parent,false);
            TextView name =covertView.findViewById(R.id.tv_msg);
            name.setText(data[position].name);
            ImageView imageView=covertView.findViewById(R.id.img_photo);
            imageView.setImageResource(data[position].photo);

            return covertView;


        }



    }

    String[] foodNameArray = new String[]{"apple", "avocado", "banana",
            "strawberry", "grapes", "cherries", "peach", "orange", "coconut", "pineapple"
            ,"rice 價格:50元"
    };
    int[] foodPhotoIdArray = new int[]{R.drawable.apple, R.drawable.avocado,
            R.drawable.banana, R.drawable.strawberry,
            R.drawable.grapes, R.drawable.cherries,
            R.drawable.peach, R.drawable.orange,
            R.drawable.coconut, R.drawable.pineapple,
            R.drawable.rice
    };
    private ImageView imgShow;
    private TextView textView1,tv_num;
    private ImageButton ImgBtn_plus,ImgBtn_sub;
    private Button btn_AddFood,btn_FoodList;
    int num=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgShow=findViewById(R.id.imgShow);
        textView1=findViewById(R.id.textView1);
        ImgBtn_plus=findViewById(R.id.ImgBtn_plus);
        ImgBtn_sub=findViewById(R.id.ImgBtn_sub);
        tv_num=findViewById(R.id.tv_num);
        btn_AddFood=findViewById(R.id.btn_AddFood);
        btn_FoodList=findViewById(R.id.btn_FoodList);


        ImgBtn_plus.setOnClickListener(new View.OnClickListener() {  //按鈕增加餐點數量
            @Override
            public void onClick(View view) {
                 num++;
                tv_num.setText(" "+num);
            }
        });
        ImgBtn_sub.setOnClickListener(new View.OnClickListener() {    //按鈕減少餐點數量
            @Override
            public void onClick(View view) {
                num--;
                if(num<0)
                    num=0;
                tv_num.setText(" "+num);
            }
        });

        btn_FoodList.setOnClickListener(new View.OnClickListener() {   //按鈕換頁
            @Override
            public void onClick(View view) {
            Intent intent=new Intent();
            intent.setClass(MainActivity.this ,FoodList.class);
            startActivity(intent);
            }
        });



        Data[] foodData = new Data[foodNameArray.length];
        for (int i =0 ; i < foodData.length; i++) {
            foodData[i] = new Data();
            foodData[i].name = foodNameArray[i];
            foodData[i].photo = foodPhotoIdArray[i];
        }
        MyAdapter adapter =new MyAdapter(foodData,R.layout.adapter_vertical);
        GridView gridView = findViewById(R.id.GridView);
        gridView.setAdapter(adapter);
        gridView.setNumColumns(2);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?>parent,View v,
                int position,long id){
                imgShow.setImageResource(foodPhotoIdArray[position]);
                ImgBtn_plus.setVisibility(View.VISIBLE);
                ImgBtn_sub.setVisibility(View.VISIBLE);
                tv_num.setVisibility(View.VISIBLE);
                btn_AddFood.setVisibility(View.VISIBLE);
                if(position==0) {
                    textView1.setText("餐點簡介\n內容");

                }
                else if(position==1)
                    textView1.setText("餐點簡介\n內容");

            }
        });
    }
}
