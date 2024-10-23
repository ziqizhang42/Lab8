package com.example.lab8v2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // Declare the variables so that you will be able to reference it later.
    ListView cityList;
    ArrayAdapter<City> cityAdapter;
    ArrayList<City> cityDataList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityList = findViewById(R.id.city_list);
        cityDataList = new ArrayList<>();

        cityDataList.add(new City("Edmonton","AB"));
        cityDataList.add(new City("Vancouver","BC"));
        cityDataList.add(new City("Toronto","ON"));
        cityDataList.add(new City("Hamilton","ON"));
        cityDataList.add(new City("Calgary","AB"));
        cityDataList.add(new City("Waterloo","ON"));


        cityAdapter = new CustomList(this,cityDataList);
        cityList.setAdapter(cityAdapter);

    }
}