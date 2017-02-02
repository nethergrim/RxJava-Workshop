package com.nethergrim.rxjavaworkshop;


import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import rx.Observable;

public class DishWasher {

    private static final String TAG = "DishWasher";
    private static DishWasher sInstance;

    public static synchronized DishWasher getInstance() {
        if (sInstance == null) {
            sInstance = new DishWasher();
        }
        return sInstance;
    }

    private DishCollector dishCollector = new DishCollector();
    private AtomicBoolean waterOpened = new AtomicBoolean(false);

    void washDishes(@NonNull List<Dish> dirtyDishes) {
        Log.d(TAG, "washDishes() called with: dirtyDishes = [" + dirtyDishes + "]");
        Observable.from(dirtyDishes)
//                .doOnSubscribe(this::openWater)
//                .flatMap(dish -> {
//                    if (dish.isClean()) { // if dish is clean, then skip this step
//                        return Observable.just(dish);
//                    }
//                    return cleanDish(dish);
//                })
//                .doOnUnsubscribe(this::closeWater)
//                .doOnNext(dish -> dishCollector.addDish(dish))
                .subscribe(o -> {
                    Log.d(TAG, "dish cleaned() called with: o = [" + o.hashCode() + "] on " + Thread.currentThread().getName());
                });
    }

    private Observable<Dish> cleanDish(@NonNull final Dish dish) {
        return Observable.fromCallable(() -> {
            if (!waterOpened.get()) {
                throw new IllegalStateException("Water is closed");
            }
            Log.d(TAG, "cleanDish() STARTED with: dish = [" + dish.hashCode() + "] on " + Thread.currentThread().getName());
            dish.setDry(false);
            dish.setClean(true);
            Thread.sleep(1000);
            Log.d(TAG, "cleanDish() FINISHED with: dish = [" + dish.hashCode() + "] on " + Thread.currentThread().getName());
            return dish;
        });
    }

    private void openWater() {
        Log.d(TAG, "openWater() called");
        waterOpened.set(true);
    }

    private void closeWater() {
        Log.d(TAG, "closeWater() called");
        waterOpened.set(false);
    }
}
