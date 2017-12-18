package com.sheygam.masa_2017_18_12_part_2;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by gregorysheygam on 18/12/2017.
 */

public class ListFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ArrayList<Person> persons;
    private MyAdapter adapter;
    private ListFragmentListener listener;

    public static ListFragment newInstance(ArrayList<Person> persons){
        ListFragment fragment = new ListFragment();
        fragment.persons = persons;
        return fragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(activity instanceof ListFragmentListener){
            listener = (ListFragmentListener) activity;
        }else{
            throw new RuntimeException(activity.getClass().getName() + "Must implements ListFragmentListener!");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new MyAdapter(persons);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_fragment,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListView list = view.findViewById(R.id.my_list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Person p = (Person) adapter.getItem(position);
        listener.onPersonSelected(p,position);
    }

    public interface ListFragmentListener{
        void onPersonSelected(Person person, int position);
    }
}
