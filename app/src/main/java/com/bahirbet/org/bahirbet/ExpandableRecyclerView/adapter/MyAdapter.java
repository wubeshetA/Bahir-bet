package com.bahirbet.org.bahirbet.ExpandableRecyclerView.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bahirbet.org.bahirbet.ExpandableRecyclerView.CompetationData;
import com.bahirbet.org.bahirbet.ExpandableRecyclerView.models.TitleChild;
import com.bahirbet.org.bahirbet.ExpandableRecyclerView.models.TitleParent;
import com.bahirbet.org.bahirbet.ExpandableRecyclerView.viewHolder.TitleChildViewHolder;
import com.bahirbet.org.bahirbet.ExpandableRecyclerView.viewHolder.TitleParentViewHolder;
import com.bahirbet.org.bahirbet.FootBallHomeActivity;
import com.bahirbet.org.bahirbet.MatchDetailFragment;
import com.bahirbet.org.bahirbet.R;
import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.List;

import static com.bahirbet.org.bahirbet.DataToPassMatchDetail.away_odd;
import static com.bahirbet.org.bahirbet.DataToPassMatchDetail.club_1_Logo;
import static com.bahirbet.org.bahirbet.DataToPassMatchDetail.club_2_Logo;
import static com.bahirbet.org.bahirbet.DataToPassMatchDetail.draw_odd;
import static com.bahirbet.org.bahirbet.DataToPassMatchDetail.home_odd;
import static com.bahirbet.org.bahirbet.DataToPassMatchDetail.m1_club_1_name;
import static com.bahirbet.org.bahirbet.DataToPassMatchDetail.m1_club_2_name;
import static com.bahirbet.org.bahirbet.DataToPassMatchDetail.m2_club_1_name;
import static com.bahirbet.org.bahirbet.DataToPassMatchDetail.m2_club_2_name;
import static com.bahirbet.org.bahirbet.DataToPassMatchDetail.m3_club_1_name;
import static com.bahirbet.org.bahirbet.DataToPassMatchDetail.m3_club_2_name;
import static com.bahirbet.org.bahirbet.DataToPassMatchDetail.m4_club_1_name;
import static com.bahirbet.org.bahirbet.DataToPassMatchDetail.m4_club_2_name;
import static com.bahirbet.org.bahirbet.DataToPassMatchDetail.temp_club1;
import static com.bahirbet.org.bahirbet.DataToPassMatchDetail.temp_club2;


public class MyAdapter extends ExpandableRecyclerAdapter<TitleParentViewHolder, TitleChildViewHolder> {
    LayoutInflater inflater;

    public MyAdapter(Context context, List<ParentObject> parentItemList){
        super(context,parentItemList);
        inflater = LayoutInflater.from(context);

        // here the following variable are used for to passed to the match_detail_activity


    }

    @Override
    public TitleParentViewHolder onCreateParentViewHolder(ViewGroup viewGroup){
        View view = inflater.inflate(R.layout.expandable_list_parent,viewGroup,false);
        return new TitleParentViewHolder(view);
    }

    @Override
    public TitleChildViewHolder onCreateChildViewHolder(ViewGroup viewGroup){
        View view = inflater.inflate(R.layout.expandable_view_child,viewGroup,false);
        return new TitleChildViewHolder(view);
    }

    @Override
    public void onBindParentViewHolder(TitleParentViewHolder titleParentViewHolder, int i, Object o) {
        TitleParent titleParent = (TitleParent)o;
        titleParentViewHolder.textView.setText(titleParent.getTitle());
        titleParentViewHolder.competition_logo_imageview.setImageResource(titleParent.getCompetition_logo_drawable());
    }




    @Override
    public void onBindChildViewHolder(final TitleChildViewHolder titleChildViewHolder, int i, Object o) {
        final TitleChild titleChild = (TitleChild) o;
        titleChildViewHolder.match_date.setText(titleChild.getMatch_date());
        titleChildViewHolder.option1.setText(titleChild.getOption1());
        titleChildViewHolder.option2.setText(titleChild.getOption2());
        /**
         * the following set of code the on click listner of option1
         */

        titleChildViewHolder.option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String option1Text = titleChildViewHolder.option1.getText().toString();
                String option2Text = titleChildViewHolder.option2.getText().toString();
                for (int i = 0; i< CompetationData.ethiopian_premier_league_matches.length; i++) {

                    if (option1Text == CompetationData.ethiopian_premier_league_matches[i][0] &&
                            option2Text == CompetationData.ethiopian_premier_league_matches[i][1]) {
                        club_1_Logo = CompetationData.et_clubs_logo[i][0];
                        club_2_Logo = CompetationData.et_clubs_logo[i][1];

                        home_odd = CompetationData.ethipian_pre_match_odd[i][0];
                        draw_odd = CompetationData.ethipian_pre_match_odd[i][1];
                        away_odd = CompetationData.ethipian_pre_match_odd[i][2];

                        temp_club1 = CompetationData.ethiopian_premier_league_matches[i][0];
                        temp_club2 = CompetationData.ethiopian_premier_league_matches[i][1];

                        m1_club_1_name = CompetationData.ethiopian_premier_league_matches[0][0];
                        m1_club_2_name = CompetationData.ethiopian_premier_league_matches[0][1];

                        m2_club_1_name = CompetationData.ethiopian_premier_league_matches[1][0];
                        m2_club_2_name = CompetationData.ethiopian_premier_league_matches[1][1];

                        m3_club_1_name = CompetationData.ethiopian_premier_league_matches[2][0];
                        m3_club_2_name = CompetationData.ethiopian_premier_league_matches[2][1];

                        m4_club_1_name = CompetationData.ethiopian_premier_league_matches[3][0];
                        m4_club_2_name = CompetationData.ethiopian_premier_league_matches[3][1];

                        break;

                    }
                }
                FootBallHomeActivity.fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container,new MatchDetailFragment(),null)
                        .addToBackStack("").commit();
            }
        });


        /**
         * the following set of code the on click listner of option2
         */



        titleChildViewHolder.option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String option2Text = titleChildViewHolder.option2.getText().toString();
                for (int i = 0; i< CompetationData.ethiopian_premier_league_matches.length; i++){

                        if (option2Text == CompetationData.ethiopian_premier_league_matches[i][1]){
                            club_2_Logo = CompetationData.et_clubs_logo[i][1];
                            club_1_Logo = CompetationData.et_clubs_logo[i][0];
                            home_odd = CompetationData.ethipian_pre_match_odd[i][0];
                            draw_odd = CompetationData.ethipian_pre_match_odd[i][1];
                            away_odd = CompetationData.ethipian_pre_match_odd[i][2];

                            m1_club_1_name = CompetationData.ethiopian_premier_league_matches[0][0];
                            m1_club_2_name = CompetationData.ethiopian_premier_league_matches[0][1];

                            m2_club_1_name = CompetationData.ethiopian_premier_league_matches[1][0];
                            m2_club_2_name = CompetationData.ethiopian_premier_league_matches[1][1];

                            m3_club_1_name = CompetationData.ethiopian_premier_league_matches[2][0];
                            m3_club_2_name = CompetationData.ethiopian_premier_league_matches[2][1];

                            m4_club_1_name = CompetationData.ethiopian_premier_league_matches[3][0];
                            m4_club_2_name = CompetationData.ethiopian_premier_league_matches[3][1];
                            break;

                    }
                }
                FootBallHomeActivity.fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container,new MatchDetailFragment(),null)
                        .addToBackStack("").commit();
            }
        });
//        titleChildViewHolder.option1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(mContext, "clicked 1", Toast.LENGTH_SHORT).show();
//                String option1Text = titleChildViewHolder.option1.getText().toString();
//                String option2Text = titleChildViewHolder.option2.getText().toString();
//                switch (option1Text){
//                    case "Manchester United":
//                        club_1_Logo = R.drawable.man_united;
//
//
//
//                        break;
//                    case "Cristal Palace":
//                        club_1_Logo = R.drawable.cristal;
//                        break;
//
//                }
//                FootBallHomeActivity.fragmentManager.beginTransaction()
//                        .replace(R.id.fragment_container,new MatchDetailFragment(),null)
//                        .addToBackStack("").commit();
//            }
//        });



    }
}
