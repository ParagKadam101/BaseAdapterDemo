package com.parag.baseadapterdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.list_view) ListView listView;
    @BindArray(R.array.persons) String[] personsStringArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        MyBaseAdapter myBaseAdapter = new MyBaseAdapter(this, getPersonList());
        listView.setAdapter(myBaseAdapter);
    }

    private ArrayList<Person> getPersonList()
    {
        ArrayList<Person> personArrayList = new ArrayList<>();
        for(String personString : personsStringArray)
        {
            String[] personDataString = personString.split("\\$");
            personArrayList.add(new Person(personDataString[0], Integer.parseInt(personDataString[1]), personDataString[2]));
        }
        return personArrayList;
    }
}
