package com.bahirbet.org.bahirbet.ExpandableRecyclerView.models;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class TitleCreator {
    static TitleCreator _titleCreator;
    List<TitleParent> _titleParent;
    public TitleCreator(Context context){
//        _titleParent = new ArrayList<>();
//        for (int i=1; i<=100; i++){
//            TitleParent title = new TitleParent(String.format("caller #%d",i));
//            _titleParent.add(title);
//        }

    }
    public static TitleCreator get(Context context){
        if (_titleCreator == null){
            _titleCreator = new TitleCreator(context);
        }
        return _titleCreator;
    }
    public List<TitleParent> getAll() {
        return _titleParent;
    }
}