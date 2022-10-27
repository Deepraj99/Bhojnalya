package com.example.bhojnalya;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;


public class ListFragment extends Fragment {

    View fragmentView;
    ListView listView;
    String[] headingList = {
            "SUNDAY\n-----------\nBreakfast", "Lunch", "Snacks", "Dinner",
            "\nMONDAY\n-----------\nBreakfast", "Lunch", "Snacks", "Dinner",
            "\nTUESDAY\n-----------\nBreakfast", "Lunch", "Snacks", "Dinner",
            "\nWEDNESDAY\n-----------\nBreakfast", "Lunch", "Snacks", "Dinner",
            "\nTHURSDAY\n-----------\nBreakfast", "Lunch", "Snacks", "Dinner",
            "\nFRIDAY\n-----------\nBreakfast", "Lunch", "Snacks", "Dinner",
            "\nSATURDAY\n-----------\nBreakfast", "Lunch", "Snacks", "Dinner",};

    String[] descriptionList = {
            "Egg bhurji\nBread-2\nMilk/Coffee\nBournvita",
            "Chole bhature\nRice\nLassi\nSalad\nAachar",
            "50-50 biscuit\nTea",
            "Green seasonal vegetable\nArhar dal\nRoti\nRice\nSalad\nSewai",

            "Poha\nMilk/Coffee\nBournvita",
            "Aloo matar\nMaa chole\nDal\nRice\nRoti\nDahi\nAchar\nSalad",
            "Samosa\nTea",
            "Kadhai chicken\nMashoor dal\nRoti\nRice\nSalad\nGulaab jamun",

            "Seasonal paratha\nDahi\nButter\nMilk/Coffee\nAchar\nFruit",
            "Aloo puri\nRice\nDahi\nSalad\nAchar",
            "Samosa",
            "Mix vegetable\nChana dal\nRoti\nRice\nSalad\nKesar kulfi",

            "Upma\nCornflakes\nMilk/Coffee\nFruit",
            "White chole\nRoti\nRice\nSalad\nDahi\nLassi",
            "Parle-G biscuit\nTea",
            "Egg curry\nMoong dal\nRoti\nFried rice\nSalad\nAchar\nRasgulla",

            "Missa paratha\nButter\nDahi\nMilk/Coffee\nBournvita\nFruit",
            "Kadhi pakoda\nJeera aloo\nRoti\nRice\nSalad\nAchar",
            "Biscuit\nLamonade",
            "Seasonal vegetables\nDal makhani\nRoti\nRice\nSalad\nKheer",

            "Aloo paratha\nDahi\nButter\nMilk/Coffee\nBournvita\nFruit\nAchar",
            "Chole bhature\nSalad\nAchar\nRice\nLassi",
            "50-50 Biscuit\nTea",
            "Green seasonal vegetables\nArhar dal\nRoti\nRice\nSalad\nSewai",

            "Daliya with mixed dry fruits\nSprouts\nTea",
            "Rajma\nRoti\nRice\nSalad\nAchar\nDahi",
            "Namkeen\nTea",
            "Seasonal kofta\nMaa chana dal\nRoti\nRice\nSalad\nAchar\nSooji Halwa"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        fragmentView = inflater.inflate(R.layout.fragment_list, container, false);
        listView = fragmentView.findViewById(R.id.customListView);
        CustomBaseAdapter customBaseAdapter1 = new CustomBaseAdapter(getActivity().getApplicationContext(), headingList, descriptionList);
        listView.setAdapter(customBaseAdapter1);
        return fragmentView;
    }
}