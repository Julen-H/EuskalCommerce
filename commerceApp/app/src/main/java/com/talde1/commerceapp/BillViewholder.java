package com.talde1.commerceapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class BillViewholder extends Fragment {
    public BillViewholder() {
        // Required empty public constructor
    }

    public static BillViewholder newInstance() {
        BillViewholder fragment = new BillViewholder();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bill_viewholder, container, false);
    }
}