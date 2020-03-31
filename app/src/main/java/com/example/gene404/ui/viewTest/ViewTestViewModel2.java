package com.example.gene404.ui.viewTest;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ViewTestViewModel2 extends ViewModel {

    private MutableLiveData<String> mText;

    public ViewTestViewModel2() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

}
