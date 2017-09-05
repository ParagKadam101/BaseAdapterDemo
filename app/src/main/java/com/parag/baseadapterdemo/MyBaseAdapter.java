package com.parag.baseadapterdemo;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

class MyBaseAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Person> personArrayList;

    MyBaseAdapter(Context context, ArrayList<Person> personArrayList)
    {
        this.context = context;
        this.personArrayList = personArrayList;
    }
    @Override
    public int getCount() {
        return personArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return personArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder;
        if(view == null) { // If the view is null only then inflate a new one
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            view = layoutInflater.inflate(R.layout.single_row, viewGroup, false);
            holder = new Holder(view);
            view.setTag(holder); // Add holder instance to the view as tag
            // Note: tag is not used to identify a view like an id, but it is to store some information associated to the id
        }
        else // Reuse the existing View
        {
            holder = (Holder)view.getTag();
        }
        holder.textViewName.setText(String.valueOf(personArrayList.get(i).getName()+","));
        holder.textViewAge.setText(String.valueOf(personArrayList.get(i).getAge()));
        holder.textViewCity.setText(personArrayList.get(i).getCity());
        return view;
    }

    static class Holder
    {
        @BindView(R.id.txt_name) TextView textViewName;
        @BindView(R.id.txt_age) TextView textViewAge;
        @BindView(R.id.txt_city) TextView textViewCity;
        Holder(View view)
        {
            ButterKnife.bind(this, view);
        }
    }
}
