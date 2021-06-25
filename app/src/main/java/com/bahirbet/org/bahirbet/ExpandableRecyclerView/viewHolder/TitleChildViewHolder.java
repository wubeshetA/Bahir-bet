package com.bahirbet.org.bahirbet.ExpandableRecyclerView.viewHolder;

import android.view.View;
import android.widget.TextView;

import com.bahirbet.org.bahirbet.R;
import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;

public class TitleChildViewHolder extends ChildViewHolder {
    public TextView option1, option2,match_date;


    public TitleChildViewHolder(View itemView){
        super(itemView);
        option1 = itemView.findViewById(R.id.option1);
        option2 = itemView.findViewById(R.id.option2);
        match_date = itemView.findViewById(R.id.match_date);
    }
}
