package com.example.bhojnalya;

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


public class ListFragment extends Fragment {

    View fragmentView;
    Button nonVegMenuBtn, vegMenuBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        fragmentView = inflater.inflate(R.layout.fragment_list, container, false);
        nonVegMenuBtn = fragmentView.findViewById(R.id.non_veg_menu_btn);
        vegMenuBtn = fragmentView.findViewById(R.id.veg_menu_btn);

        replaceFragment(new NonVegMenuListFragment());
        nonVegMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nonVegMenuBtn.setBackgroundColor(getResources().getColor(R.color.yellow));
                vegMenuBtn.setBackgroundColor(getResources().getColor(R.color.light_yellow));
                replaceFragment(new NonVegMenuListFragment());
            }
        });
        vegMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nonVegMenuBtn.setBackgroundColor(getResources().getColor(R.color.light_yellow));
                vegMenuBtn.setBackgroundColor(getResources().getColor(R.color.yellow));
                replaceFragment(new VegMenuListFragment());
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