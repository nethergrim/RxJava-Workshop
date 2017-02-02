package com.nethergrim.rxjavaworkshop;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.LinkedList;
import java.util.List;

/**
 * Сушилка мытой посуды
 */

@SuppressWarnings("WeakerAccess")
public class  DishCollector {

    private final List<Dish> plates = new LinkedList<>();

    public void addDish(@NonNull Dish plate) {
        if (!plate.isClean()) {
            throw new RuntimeException("You should not place dirty plate here");
        }
        plate.setDry(true);
        plates.add(plate);
    }
    public void addDishes(@NonNull List<Dish> plates) {
        for (int i = 0, platesSize = plates.size(); i < platesSize; i++) {
            Dish plate = plates.get(i);
            addDish(plate);
        }
    }

    @Nullable
    public Dish getDryDish() {
        if (plates.isEmpty()) {
            return null;
        }
        Dish plate = plates.get(0);
        plates.remove(0);
        return plate;
    }
}
