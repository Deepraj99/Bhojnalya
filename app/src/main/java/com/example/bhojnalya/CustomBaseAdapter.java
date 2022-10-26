package com.example.bhojnalya;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomBaseAdapter extends BaseAdapter {

    Context context;
    String[] listHeading;
    String[] listDescription;
    LayoutInflater inflater;

    public CustomBaseAdapter(Context ctx, String[] headingList, String[] descriptionList) {
        this.context = ctx;
        this.listHeading = headingList;
        this.listDescription = descriptionList;
        inflater = LayoutInflater.from(ctx);
    }
    @Override
    public int getCount() {
        return listHeading.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.activity_custom_list_view, null);
        TextView txtView = convertView.findViewById(R.id._heading);
        TextView desView = convertView.findViewById(R.id._description);
        txtView.setText(listHeading[position]);
        desView.setText(listDescription[position]);
        return convertView;
    }
}
