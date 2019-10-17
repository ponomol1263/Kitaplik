package com.codeandmania.kitaplik.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codeandmania.kitaplik.R;


public class DiziFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_dizi_fragment, container, false);
        ((DiziAnasayfa)getActivity()).fragment3method();
        return view;
    }

}