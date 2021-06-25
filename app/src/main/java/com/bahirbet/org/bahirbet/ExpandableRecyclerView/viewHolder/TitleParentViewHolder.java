package com.bahirbet.org.bahirbet.ExpandableRecyclerView.viewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bahirbet.org.bahirbet.R;
import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;


public class TitleParentViewHolder extends ParentViewHolder {
    public TextView textView;
   public  ImageView imageView,competition_logo_imageview;
    public TitleParentViewHolder (View itemView){
        super(itemView);
        textView = itemView.findViewById(R.id.parentTitle);
        imageView = itemView.findViewById(R.id.expand_arrow);
        competition_logo_imageview = itemView.findViewById(R.id.competition_logo_imageview);
    }
}
