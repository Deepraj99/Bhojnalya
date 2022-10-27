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

public class HomeFragment extends Fragment {

    SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
    Date d = new Date();
    String dayOfTheWeek = sdf.format(d);

    View fragmentView;
    ListView listView, listView2;
    TextView currentDay;
    String[] headingList = {"Breakfast", "Lunch", "Snacks", "Dinner"};
    String[] headingList1 = {"Breakfast", "Lunch", "Snacks", "Dinner"};
    String[] descriptionList, descriptionList1;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        if(dayOfTheWeek.equals("Sunday"))
        {
            descriptionList = new String[] {
                    "Egg bhurji\nBread-2\nMilk/Coffee\nBournvita",
                    "Chole bhature\nRice\nLassi\nSalad\nAachar",
                    "50-50 biscuit\nTea",
                    "Green seasonal vegetable\nArhar dal\nRoti\nRice\nSalad\nSewai"};

            descriptionList1 = new String[] {
                    "Sandwich\nKetchup\nMilk/Coffee\nBournvita",
                    "Chole bhature\nRice\nLassi\nSalad\nAachar",
                    "50-50 biscuit\nTea",
                    "Green seasonal vegetable\nArhar dal\nRoti\nRice\nSalad\nSewai"};
        }
        else if(dayOfTheWeek.equals("Monday"))
        {
            descriptionList = new String[] {
                    "Poha\nMilk/Coffee\nBournvita",
                    "Aloo matar\nMaa chole\nDal\nRice\nRoti\nDahi\nAchar\nSalad",
                    "Samosa\nTea",
                    "Kadhai chicken\nMashoor dal\nRoti\nRice\nSalad\nGulaab jamun"};

            descriptionList1 = new String[] {
                    "Poha\nMilk/Coffee\nBournvita",
                    "Aloo matar\nMaa chole\nDal\nRice\nRoti\nDahi\nAchar\nSalad",
                    "Samosa\nTea",
                    "Matar paneer\nMashoor dal\nRoti\nRice\nSalad\nGulaab jamun"};
        }
        else if(dayOfTheWeek.equals("Tuesday"))
        {
            descriptionList = new String[] {
                    "Seasonal paratha\nDahi\nButter\nMilk/Coffee\nAchar\nFruit",
                    "Aloo puri\nRice\nDahi\nSalad\nAchar",
                    "Samosa",
                    "Mix vegetable\nChana dal\nRoti\nRice\nSalad\nKesar kulfi"};

            descriptionList1 = new String[] {
                    "Seasonal paratha\nDahi\nButter\nMilk/Coffee\nAchar\nFruit",
                    "Aloo puri\nRice\nDahi\nSalad\nAchar",
                    "Samosa",
                    "Mix vegetable\nChana dal\nRoti\nRice\nSalad\nKesar kulfi"};
        }
        else if(dayOfTheWeek.equals("Wednesday"))
        {
            descriptionList = new String[] {
                    "Upma\nCornflakes\nMilk/Coffee\nFruit",
                    "White chole\nRoti\nRice\nSalad\nDahi\nLassi",
                    "Parle-G biscuit\nTea",
                    "Egg curry\nMoong dal\nRoti\nFried rice\nSalad\nAchar\nRasgulla"};

            descriptionList1 = new String[] {
                    "Upma\nCornflakes\nMilk/Coffee\nFruit",
                    "White chole\nRoti\nRice\nSalad\nDahi\nLassi",
                    "Parle-G biscuit\nTea",
                    "Kadhai paneer\nMoong dal\nRoti\nFried rice\nSalad\nAchar\nRasgulla"};
        }
        else if(dayOfTheWeek.equals("Thursday"))
        {
            descriptionList = new String[] {
                    "Missa paratha\nButter\nDahi\nMilk/Coffee\nBournvita\nFruit",
                    "Kadhi pakoda\nJeera aloo\nRoti\nRice\nSalad\nAchar",
                    "Biscuit\nLamonade",
                    "Seasonal vegetables\nDal makhani\nRoti\nRice\nSalad\nKheer"};

            descriptionList1 = new String[] {
                    "Simple paratha\nAloo sabji\nButter\nDahi\nMilk/Coffee\nBournvita",
                    "Kadhi pakoda\nJeera aloo\nRoti\nRice\nSalad\nAchar",
                    "Biscuit\nLamonade",
                    "Seasonal vegetables\nDal makhani\nRoti\nRice\nSalad\nKheer"};
        }
        else if(dayOfTheWeek.equals("Friday"))
        {
            descriptionList = new String[] {
                    "Aloo paratha\nDahi\nButter\nMilk/Coffee\nBournvita\nFruit\nAchar",
                    "Kala chana\nArhar dal\nRoti\nRice\nSalad\nAchar\nDahi",
                    "Bread pakora\nTea",
                    "Butter chicken\nUrad dal\nRoti\nRice\nSalad\nAchar\nIce-cream"};

            descriptionList1 = new String[] {
                    "Aloo paratha\nDahi\nButter\nMilk/Coffee\nBournvita\nFruit\nAchar",
                    "Kala chana\nArhar dal\nRoti\nRice\nSalad\nAchar\nDahi",
                    "Bread pakora\nTea",
                    "Shahi paneer\nUrad dal\nRoti\nRice\nSalad\nAchar\nIce-cream"};
        }
        else
        {
            descriptionList = new String[] {
                    "Daliya with mixed dry fruits\nSprouts\nTea",
                    "Rajma\nRoti\nRice\nSalad\nAchar\nDahi",
                    "Namkeen\nTea",
                    "Seasonal kofta\nMaa chana dal\nRoti\nRice\nSalad\nAchar\nSooji Halwa"};

            descriptionList1 = new String[] {
                    "Daliya with mixed dry fruits\nSprouts\nTea",
                    "Rajma\nRoti\nRice\nSalad\nAchar\nDahi",
                    "Namkeen\nTea",
                    "Seasonal kofta\nMaa chana dal\nRoti\nRice\nSalad\nAchar\nSooji Halwa"};
        }

        fragmentView = inflater.inflate(R.layout.fragment_home, container, false);
        currentDay = fragmentView.findViewById(R.id.tv_current_day);
        currentDay.setText("It's " + dayOfTheWeek.toLowerCase() + " today!");
        listView = fragmentView.findViewById(R.id.customListView);
        listView2 = fragmentView.findViewById(R.id.customListView2);
        CustomBaseAdapter customBaseAdapter1 = new CustomBaseAdapter(getActivity().getApplicationContext(), headingList, descriptionList);
        CustomBaseAdapter customBaseAdapter2 = new CustomBaseAdapter(getActivity().getApplicationContext(), headingList1, descriptionList1);
        listView2.setAdapter(customBaseAdapter2);
        listView.setAdapter(customBaseAdapter1);
        return fragmentView;
    }
}