package com.nethergrim.rxjavaworkshop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        List<Dish> dirtyDishes = DishProducer.produce();
        DishWasher washer = DishWasher.getInstance();
        washer.washDishes(dirtyDishes);
    }

}
