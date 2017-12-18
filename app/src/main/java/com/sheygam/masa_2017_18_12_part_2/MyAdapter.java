package com.sheygam.masa_2017_18_12_part_2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by gregorysheygam on 18/12/2017.
 */

public class MyAdapter extends BaseAdapter {
    private ArrayList<Person> persons;

    public MyAdapter(ArrayList<Person> persons) {
        this.persons = persons;
    }

    @Override
    public int getCount() {
        return persons != null ? persons.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return persons != null ? persons.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_row,parent,false);
        }
        Person p = persons.get(position);
        TextView nameTxt = convertView.findViewById(R.id.row_title);
        nameTxt.setText(p.getName());
        return convertView;
    }
}
