package com.bahirbet.org.bahirbet.ExpandableRecyclerView.models;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.List;
import java.util.UUID;


public class TitleParent implements ParentObject {
    private List<Object> mChildrenList;
    private UUID _id;
    private String title;
    private int competition_logo_drawable;

    public TitleParent(String title, int competition_logo_drawable) {
        this.title = title;
        this.competition_logo_drawable = competition_logo_drawable;
        _id = UUID.randomUUID();
    }

    public int getCompetition_logo_drawable() {
        return competition_logo_drawable;
    }

    public void setCompetition_logo_drawable(int competition_logo_drawable) {
        this.competition_logo_drawable = competition_logo_drawable;
    }

    public UUID get_id() {
        return _id;
    }

    public void set_id(UUID _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public List<Object> getChildObjectList(){
        return mChildrenList;
    }
    @Override
    public void setChildObjectList(List<Object> list){
        mChildrenList = list;
    }
}


