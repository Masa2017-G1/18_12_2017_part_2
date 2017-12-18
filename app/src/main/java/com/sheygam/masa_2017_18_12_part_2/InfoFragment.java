package com.sheygam.masa_2017_18_12_part_2;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by gregorysheygam on 18/12/2017.
 */

public class InfoFragment extends Fragment {
    private Person currentPerson;

    public static InfoFragment newInstance(Person person){
        InfoFragment fragment = new InfoFragment();
        fragment.currentPerson = person;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.info_fragment,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ViewGroup root = view.findViewById(R.id.info_root);
        root.setOnClickListener(null);
        TextView nameTxt = view.findViewById(R.id.name_txt);
        TextView emailTxt = view.findViewById(R.id.email_txt);
        TextView phoneTxt = view.findViewById(R.id.phone_txt);
        nameTxt.setText(currentPerson.getName());
        emailTxt.setText(currentPerson.getEmail());
        phoneTxt.setText(currentPerson.getPhone());
    }

    public Person getCurrentPerson(){
        return currentPerson;
    }
}
