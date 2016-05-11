package com.milapnaik.mentalmathworkout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.widget.TextView;

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
        return list.size();
    }

    @Override
    public Object getItem(int position){
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        LBHolder lbholder;

        if(row==null){
            LayoutInflater layoutinflater = (LayoutInflater) this.getContext().getSystemService(getContext().LAYOUT_INFLATER_SERVICE);
            row = layoutinflater.inflate(R.layout.display_leaderboard_row, parent, false);
            lbholder = new LBHolder();
            lbholder.lb_rank = (TextView) row.findViewById(R.id.lb_rank);
            lbholder.lb_score = (TextView) row.findViewById(R.id.lb_score);
            lbholder.lb_time = (TextView) row.findViewById(R.id.lb_time);
            row.setTag(lbholder);
        }
        else {
            lbholder = (LBHolder) row.getTag();
        }
        LB leaderboard = (LB) getItem(position);
        lbholder.lb_rank.setText(leaderboard.getRank().toString());
        lbholder.lb_score.setText(leaderboard.getScore().toString());
        lbholder.lb_time.setText(leaderboard.getTime().toString());

        return row;
    }

    static class LBHolder{
        TextView lb_rank, lb_score, lb_time;
    }
}
