package com.sheygam.masa_2017_18_12_part_2;

import android.content.res.Configuration;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListFragment.ListFragmentListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.list_frag_container,ListFragment.newInstance(getPersons()))
                .commit();
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            if (savedInstanceState != null) {
                Person p = (Person) savedInstanceState.getSerializable("PERSON");
                if (p != null) {
                    onPersonSelected(p, 0);
                }
            }
        }
    }

    private ArrayList<Person> getPersons(){
        ArrayList<Person> persons = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            persons.add(new Person("Person " + (i+1), "person" + i + "@mail.com","1234567"+i));
        }
        return persons;
    }

    @Override
    public void onPersonSelected(Person person, int position) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frag_container,InfoFragment.newInstance(person),"INFO_FRAGMENT");
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        InfoFragment fragment = (InfoFragment) getSupportFragmentManager().findFragmentByTag("INFO_FRAGMENT");
        if(fragment != null){
            Person person = fragment.getCurrentPerson();
            outState.putSerializable("PERSON",person);
            getSupportFragmentManager()
                    .beginTransaction()
                    .remove(fragment)
                    .commit();
        }
        getSupportFragmentManager().popBackStack();
        super.onSaveInstanceState(outState);
    }
}
