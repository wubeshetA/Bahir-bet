package com.bahirbet.org.bahirbet;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bahirbet.org.bahirbet.ExpandableRecyclerView.CompetationData;
import com.bahirbet.org.bahirbet.ExpandableRecyclerView.adapter.MyAdapter;
import com.bahirbet.org.bahirbet.ExpandableRecyclerView.models.TitleChild;
import com.bahirbet.org.bahirbet.ExpandableRecyclerView.models.TitleCreator;
import com.bahirbet.org.bahirbet.ExpandableRecyclerView.models.TitleParent;
import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListOfCompetitionFragment extends Fragment {
   public static RecyclerView recyclerView;

    public ListOfCompetitionFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_of_competition, container, false);
        //TODO code starts here ===============================================

        recyclerView = view.findViewById(R.id.RecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        MyAdapter adapter = new MyAdapter(getContext(),initData(getActivity().getApplicationContext()));

        adapter.setParentClickableViewAnimationDefaultDuration();
        adapter.setParentAndIconExpandOnClick(true);

        recyclerView.setAdapter(adapter);



        // TODO --> my todo code ends here =====================================================



        return view;


    }

    private List<ParentObject> initData(Context c){

        TitleCreator titleCreator = TitleCreator.get(c);
        List<TitleParent> titles = titleCreator.getAll();
        List<ParentObject> parentObject = new ArrayList<>();

        TitleParent title1 = new TitleParent(getString(R.string.EthiopianPremierLeague),R.drawable.ethiopian_premier_league_logo);
        TitleParent title2 = new TitleParent(getString(R.string.english_premier_league),R.drawable.english_premierleague_logo);
        TitleParent title3 = new TitleParent(getString(R.string.spain_laliga),R.drawable.spain_laliga_logo);
        TitleParent title4 = new TitleParent(getString(R.string.german_bundesliga),R.drawable.german_bundesliga_logo);
        TitleParent title5 = new TitleParent(getString(R.string.italy_serie),R.drawable.italy_serie_logo);
        TitleParent title6 = new TitleParent(getString(R.string.uefa_champions_league),R.drawable.uefa_champions_league_logo);
        TitleParent title7 = new TitleParent(getString(R.string.uefa_europa_leagua),R.drawable.uefa_europa_league_logo);
        TitleParent title8 = new TitleParent(getString(R.string.african_champions_league),R.drawable.african_champions_league_logo);
        TitleParent title9 = new TitleParent(getString(R.string.frican_cup),R.drawable.african_caup_logo);
        TitleParent title10 = new TitleParent(getString(R.string.world_cup),R.drawable.world_cup_logo);

        TitleChild t1 = new TitleChild(CompetationData.ethiopian_premier_league_matches[0][0],CompetationData.ethiopian_premier_league_matches[0][1],"14-02-19 06:30");
        TitleChild t2 = new TitleChild(CompetationData.ethiopian_premier_league_matches[1][0],CompetationData.ethiopian_premier_league_matches[1][1],"14-02-19 06:10");
        TitleChild t3 = new TitleChild(CompetationData.ethiopian_premier_league_matches[2][0],CompetationData.ethiopian_premier_league_matches[2][1],"15-02-19 09:30");
        TitleChild t4 = new TitleChild(CompetationData.ethiopian_premier_league_matches[3][0],CompetationData.ethiopian_premier_league_matches[3][1],"17-02-19 03:45");

        TitleChild e1 = new TitleChild(CompetationData.english_primier_league_matches[0][0],CompetationData.english_primier_league_matches[0][1],"11-02-19 06:30");
        TitleChild e2 = new TitleChild(CompetationData.english_primier_league_matches[1][0],CompetationData.english_primier_league_matches[1][1],"14-02-19 06:10");
        TitleChild e3 = new TitleChild(CompetationData.english_primier_league_matches[2][0],CompetationData.english_primier_league_matches[2][1],"15-02-19 09:30");


        List<Object> childList1 = new ArrayList<>();

        List<Object> childList2 = new ArrayList<>();

        childList1.add(t1);
        childList1.add(t2);
        childList1.add(t3);
        childList1.add(t4);

        childList2.add(e1);
        childList2.add(e2);
        childList2.add(e3);

        title1.setChildObjectList(childList1);
        title2.setChildObjectList(childList2);

        parentObject.add(title1);
        parentObject.add(title2);
        parentObject.add(title3);
        parentObject.add(title4);
        parentObject.add(title5);
        parentObject.add(title6);
        parentObject.add(title7);
        parentObject.add(title8);
        parentObject.add(title9);
        parentObject.add(title10);

        return parentObject;
    }

}
