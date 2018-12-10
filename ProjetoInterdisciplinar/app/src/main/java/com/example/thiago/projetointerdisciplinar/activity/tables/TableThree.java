package com.example.thiago.projetointerdisciplinar.activity.tables;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thiago.projetointerdisciplinar.R;

public class TableThree extends android.app.Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View  view = inflater.inflate(R.layout.tab_three, container, false);
        return view;
    }
}
