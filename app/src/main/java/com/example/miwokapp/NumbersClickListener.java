package com.example.miwokapp;

import android.view.View;
import android.widget.Toast;

// just to understand working of onclick listener not used in the app
public class NumbersClickListener implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        Toast.makeText(v.getContext(),"new onlclick fn",Toast.LENGTH_LONG).show();
    }
}
