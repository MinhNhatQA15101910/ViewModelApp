package com.donhat.viewmodelapp;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private final MutableLiveData<Integer> counter = new MutableLiveData<>();

    public void increaseCounter(View view) {
        int currentValue = counter.getValue() != null ? counter.getValue() : 0;

        counter.setValue(currentValue + 1);
    }

    public MutableLiveData<Integer> getCounter() {
        return counter;
    }
}
