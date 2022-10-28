package com.example.bhojnalya;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HomeFragment extends Fragment {

    View fragmentView;
    Button nonVegMenuBtn, vegMenuBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {


        fragmentView = inflater.inflate(R.layout.fragment_home, container, false);

        nonVegMenuBtn = fragmentView.findViewById(R.id.non_veg_menu_btn);
        vegMenuBtn = fragmentView.findViewById(R.id.veg_menu_btn);

        replaceFragment(new NonVegMenuFragment());
        nonVegMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nonVegMenuBtn.setBackgroundColor(getResources().getColor(R.color.yellow));
                vegMenuBtn.setBackgroundColor(getResources().getColor(R.color.light_yellow));
                replaceFragment(new NonVegMenuFragment());
            }
        });
        vegMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nonVegMenuBtn.setBackgroundColor(getResources().getColor(R.color.light_yellow));
                vegMenuBtn.setBackgroundColor(getResources().getColor(R.color.yellow));
                replaceFragment(new VegMenuFragment());
            }
        });
        return fragmentView;
    }
    private void replaceFragment(Fragment fragment) {

        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}