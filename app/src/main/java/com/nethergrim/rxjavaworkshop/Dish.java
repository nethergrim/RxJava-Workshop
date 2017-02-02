package com.nethergrim.rxjavaworkshop;

import android.graphics.Color;
import android.support.annotation.ColorInt;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Тарелка :)
 */

@SuppressWarnings("WeakerAccess")
public class Dish {

    private static final AtomicInteger autoIncrementGenerator = new AtomicInteger(0);

    private int id;

    private boolean clean;

    private boolean dry = true;
    @ColorInt
    private int color = Color.WHITE;

    private int sizeIn;

    public Dish(boolean clean, int color, int sizeIn) {
        this.clean = clean;
        this.color = color;
        this.sizeIn = sizeIn;
        this.id = autoIncrementGenerator.incrementAndGet();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isClean() {
        return clean;
    }

    public void setClean(boolean clean) {
        this.clean = clean;
    }

    public boolean isDry() {
        return dry;
    }

    public void setDry(boolean dry) {
        this.dry = dry;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getSizeIn() {
        return sizeIn;
    }

    public void setSizeIn(int sizeIn) {
        this.sizeIn = sizeIn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dish dish = (Dish) o;

        return id == dish.id;

    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", clean=" + clean +
                ", dry=" + dry +
                ", color=" + color +
                ", sizeIn=" + sizeIn +
                '}';
    }
}
