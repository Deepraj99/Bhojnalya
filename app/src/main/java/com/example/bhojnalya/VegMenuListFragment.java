package com.example.bhojnalya;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


public class VegMenuListFragment extends Fragment {

    ListView listView;
    String[] headingList = {
            "SUNDAY\n-----------\nBreakfast", "Lunch", "Snacks", "Dinner",
            "\nMONDAY\n-----------\nBreakfast", "Lunch", "Snacks", "Dinner",
            "\nTUESDAY\n-----------\nBreakfast", "Lunch", "Snacks", "Dinner",
            "\nWEDNESDAY\n-----------\nBreakfast", "Lunch", "Snacks", "Dinner",
            "\nTHURSDAY\n-----------\nBreakfast", "Lunch", "Snacks", "Dinner",
            "\nFRIDAY\n-----------\nBreakfast", "Lunch", "Snacks", "Dinner",
            "\nSATURDAY\n-----------\nBreakfast", "Lunch", "Snacks", "Dinner"};

    String[] descriptionList = {
            "Sandwich\nKetchup\nMilk/Coffee\nBournvita",
            "Chole bhature\nRice\nLassi\nSalad\nAachar",
            "50-50 biscuit\nTea",
            "Green seasonal vegetable\nArhar dal\nRoti\nRice\nSalad\nSewai",

            "Poha\nMilk/Coffee\nBournvita",
            "Aloo matar\nMaa chole\nDal\nRice\nRoti\nDahi\nAchar\nSalad",
            "Samosa\nTea",
            "Matar paneer\nMashoor dal\nRoti\nRice\nSalad\nGulaab jamun",

            "Seasonal paratha\nDahi\nButter\nMilk/Coffee\nAchar\nFruit",
            "Aloo puri\nRice\nDahi\nSalad\nAchar",
            "Samosa",
            "Mix vegetable\nChana dal\nRoti\nRice\nSalad\nKesar kulfi",

            "Upma\nCornflakes\nMilk/Coffee\nFruit",
            "White chole\nRoti\nRice\nSalad\nDahi\nLassi",
            "Parle-G biscuit\nTea",
            "Kadhai paneer\nMoong dal\nRoti\nFried rice\nSalad\nAchar\nRasgulla",

            "Simple paratha\nAloo sabji\nButter\nDahi\nMilk/Coffee\nBournvita",
            "Kadhi pakoda\nJeera aloo\nRoti\nRice\nSalad\nAchar",
            "Biscuit\nLamonade",
            "Seasonal vegetables\nDal makhani\nRoti\nRice\nSalad\nKheer",

            "Aloo paratha\nDahi\nButter\nMilk/Coffee\nBournvita\nFruit\nAchar",
            "Kala chana\nArhar dal\nRoti\nRice\nSalad\nAchar\nDahi",
            "Bread pakora\nTea",
            "Shahi paneer\nUrad dal\nRoti\nRice\nSalad\nAchar\nIce-cream",

            "Daliya with mixed dry fruits\nSprouts\nTea",
            "Rajma\nRoti\nRice\nSalad\nAchar\nDahi",
            "Namkeen\nTea",
            "Seasonal kofta\nMaa chana dal\nRoti\nRice\nSalad\nAchar\nSooji Halwa"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vegMenuListFragment = inflater.inflate(R.layout.fragment_veg_menu_list, container, false);

        listView = vegMenuListFragment.findViewById(R.id.customListView);
        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(getActivity().getApplicationContext(), headingList, descriptionList);
        listView.setAdapter(customBaseAdapter);
        return vegMenuListFragment;
    }
}