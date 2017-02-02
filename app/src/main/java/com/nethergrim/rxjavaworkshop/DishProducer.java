package com.nethergrim.rxjavaworkshop;


import android.graphics.Color;
import android.support.annotation.NonNull;

import java.util.LinkedList;
import java.util.List;

class DishProducer {

    private static final int COUNT = 10;

    @NonNull
    static List<Dish> produce() {
        List<Dish> result = new LinkedList<>();
        for (int i = 0; i < COUNT; i++) {
            result.add(new Dish(false, Color.BLACK, (i + 1) / 2));
        }
        return result;
    }
}
