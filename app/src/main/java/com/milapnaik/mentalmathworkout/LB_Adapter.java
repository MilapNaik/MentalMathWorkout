package com.milapnaik.mentalmathworkout;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;
import android.content.Context;

/**
 * Created by MilapNaik on 5/10/16.
 */
public class LB_Adapter extends ArrayAdapter {
    List list = new ArrayList();

    public LB_Adapter(Context context, int resource){
        super(context, resource);
    }

    public void add(LB object){
        list.add(object);
        super.add(object);
    }

    @Override
    public int getCount(){
        return super.getCount();
    }

    @Override
    public Object getItem(int position){
        return super.getItem(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }
}
