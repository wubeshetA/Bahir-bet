package com.bahirbet.org.bahirbet.ExpandableRecyclerView.models;

public class TitleChild {

    public String option1;
    public String option2;
    public String match_date;

    public TitleChild(String option1, String option2,String match_date) {
        this.option1 = option1;
        this.option2 = option2;
        this.match_date = match_date;
    }

    public String getMatch_date() {
        return match_date;
    }

    public void setMatch_date(String match_date) {
        this.match_date = match_date;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }
}
