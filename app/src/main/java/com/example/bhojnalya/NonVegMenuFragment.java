package com.example.bhojnalya;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NonVegMenuFragment extends Fragment {

    SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
    Date d = new Date();
    String dayOfTheWeek = sdf.format(d);

    ListView listView;
    TextView currentDay;
    String[] headingList = {"Breakfast", "Lunch", "Snacks", "Dinner"};
    String[] descriptionList;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View nonVegMenuFragment = inflater.inflate(R.layout.fragment_non_veg_menu, container, false);

        switch (dayOfTheWeek) {
            case "Sunday":
                descriptionList = new String[]{
                        "Egg bhurji\nBread-2\nMilk/Coffee\nBournvita",
                        "Chole bhature\nRice\nLassi\nSalad\nAachar",
                        "50-50 biscuit\nTea",
                        "Green seasonal vegetable\nArhar dal\nRoti\nRice\nSalad\nSewai"};
                break;
            case "Monday":
                descriptionList = new String[]{
                        "Poha\nMilk/Coffee\nBournvita",
                        "Aloo matar\nMaa chole\nDal\nRice\nRoti\nDahi\nAchar\nSalad",
                        "Samosa\nTea",
                        "Kadhai chicken\nMashoor dal\nRoti\nRice\nSalad\nGulaab jamun"};
                break;
            case "Tuesday":
                descriptionList = new String[]{
                        "Seasonal paratha\nDahi\nButter\nMilk/Coffee\nAchar\nFruit",
                        "Aloo puri\nRice\nDahi\nSalad\nAchar",
                        "Samosa",
                        "Mix vegetable\nChana dal\nRoti\nRice\nSalad\nKesar kulfi"};
                break;
            case "Wednesday":
                descriptionList = new String[]{
                        "Upma\nCornflakes\nMilk/Coffee\nFruit",
                        "White chole\nRoti\nRice\nSalad\nDahi\nLassi",
                        "Parle-G biscuit\nTea",
                        "Egg curry\nMoong dal\nRoti\nFried rice\nSalad\nAchar\nRasgulla"};
                break;
            case "Thursday":
                descriptionList = new String[]{
                        "Missa paratha\nButter\nDahi\nMilk/Coffee\nBournvita\nFruit",
                        "Kadhi pakoda\nJeera aloo\nRoti\nRice\nSalad\nAchar",
                        "Biscuit\nLamonade",
                        "Seasonal vegetables\nDal makhani\nRoti\nRice\nSalad\nKheer"};
                break;
            case "Friday":
                descriptionList = new String[]{
                        "Aloo paratha\nDahi\nButter\nMilk/Coffee\nBournvita\nFruit\nAchar",
                        "Kala chana\nArhar dal\nRoti\nRice\nSalad\nAchar\nDahi",
                        "Bread pakora\nTea",
                        "Butter chicken\nUrad dal\nRoti\nRice\nSalad\nAchar\nIce-cream"};
                break;
            default:
                descriptionList = new String[]{
                        "Daliya with mixed dry fruits\nSprouts\nTea",
                        "Rajma\nRoti\nRice\nSalad\nAchar\nDahi",
                        "Namkeen\nTea",
                        "Seasonal kofta\nMaa chana dal\nRoti\nRice\nSalad\nAchar\nSooji Halwa"};
                break;
        }

        currentDay = nonVegMenuFragment.findViewById(R.id.current_day_tv);
        currentDay.setText("It's " + dayOfTheWeek.toLowerCase() + " today!");
        listView = nonVegMenuFragment.findViewById(R.id.customListView);
        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(getActivity().getApplicationContext(), headingList, descriptionList);
        listView.setAdapter(customBaseAdapter);
        return nonVegMenuFragment;
    }
}