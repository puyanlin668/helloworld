package com.example.thinkpad.mvvm;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ObSwordsman swordsman;
    private ObservableArrayList<Swordsman > mSwordsmen = new ObservableArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate: AppCompatActivity的加载器" + AppCompatActivity.class.getClassLoader() );
        Log.e(TAG, "onCreate: AppCompatActivity的加载器的父类" + AppCompatActivity.class.getClassLoader().getParent() );
        Log.e(TAG, "onCreate: Activity的加载器" + Activity.class.getClassLoader() );
        Log.e(TAG, "onCreate: MainActivity的类加载器" + getClassLoader() );
        ActivityFrist binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        swordsman = new ObSwordsman("孙大圣","1000");
        binding.setSwordsman(swordsman);
        binding.setAge(88);
        binding.setMan(true);
        binding.setName("Android 精通");



        ArrayList<String> list = new ArrayList<>();
        list.add("0");
        list.add("1");
        binding.setList(list);

        Map<String,String> map = new HashMap<>();
        map.put("age","30");
        binding.setMap(map);

        String[] arrays = {"诸葛","周瑜"};
        binding.setArrays(arrays);
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"点击了",Toast.LENGTH_LONG).show();
                swordsman.setName("张三丰");
            }
        });

        binding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"点击了222",Toast.LENGTH_LONG).show();
                swordsman.setName("李寻欢");
            }
        });
    }
}
