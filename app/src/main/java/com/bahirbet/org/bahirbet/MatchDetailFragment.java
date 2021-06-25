package com.bahirbet.org.bahirbet;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.bahirbet.org.bahirbet.ExpandableRecyclerView.CompetationData;


/**
 * A simple {@link Fragment} subclass.
 */
public class MatchDetailFragment extends Fragment {

ImageView club_home_logo,club_away_logo;
RadioButton radio_btn_home, radio_btn_draw, radio_btn_away;
RadioGroup radio_group_main;
FloatingActionButton add_bet_fab;


    public MatchDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view  = inflater.inflate(R.layout.fragment_match_detail, container, false);

      
        club_home_logo = view.findViewById(R.id.club_home_logo);
        club_away_logo = view.findViewById(R.id.club_away_logo);

        club_home_logo.setImageResource(DataToPassMatchDetail.club_1_Logo);
        club_away_logo.setImageResource(DataToPassMatchDetail.club_2_Logo);

        radio_group_main = view.findViewById(R.id.radio_group_main);
        radio_btn_home = view.findViewById(R.id.radio_btn_home);

        radio_btn_draw = view.findViewById(R.id.radio_btn_draw);
        radio_btn_away = view.findViewById(R.id.radio_btn_away);

        radio_btn_home.setText(DataToPassMatchDetail.home_odd);
        radio_btn_draw.setText(DataToPassMatchDetail.draw_odd);
        radio_btn_away.setText(DataToPassMatchDetail.away_odd);
        
        radio_btn_home.setHighlightColor(getResources().getColor(R.color.colorPrimaryDark));
        radio_btn_draw.setHighlightColor(getResources().getColor(R.color.colorPrimaryDark));
        radio_btn_away.setHighlightColor(getResources().getColor(R.color.colorPrimaryDark));
        final int id = radio_group_main.getCheckedRadioButtonId();

        add_bet_fab = view.findViewById(R.id.add_bet_fab);
        add_bet_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String temp_club1 = DataToPassMatchDetail.temp_club1;
                String temp_club2 = DataToPassMatchDetail.temp_club2;

//                String m1_club1 = DataToPassMatchDetail.m1_club_1_name;
//                String m1_club2 = DataToPassMatchDetail.m1_club_2_name;
//
//                String m2_club1 = DataToPassMatchDetail.m2_club_1_name;
//                String m2_club2 = DataToPassMatchDetail.m2_club_2_name;
//
//                String m3_club1 = DataToPassMatchDetail.m3_club_1_name;
//                String m3_club2 = DataToPassMatchDetail.m3_club_2_name;
//
//                String m4_club1 = DataToPassMatchDetail.m4_club_1_name;
//                String m4_club2 = DataToPassMatchDetail.m4_club_2_name;





               // Toast.makeText(getActivity().getApplicationContext(), String.format("club1: %s -- m1_club2: %s",), Toast.LENGTH_SHORT).show();
                RadioButton r = new RadioButton(getActivity().getApplicationContext());
                r.setId(id);
                String odd = "";
                if ( radio_group_main.getCheckedRadioButtonId() == radio_btn_home.getId()) {
                    Toast.makeText(getActivity().getApplicationContext(), "i am in: "+radio_btn_home.getText().toString(), Toast.LENGTH_SHORT).show();
                    odd = radio_btn_home.getText().toString();
                }
                else if ( radio_group_main.getCheckedRadioButtonId() == radio_btn_draw.getId()) {
                    Toast.makeText(getActivity().getApplicationContext(), "i am in: "+r.getId(), Toast.LENGTH_SHORT).show();
                    odd = radio_btn_draw.getText().toString();
                }
                else if ( radio_group_main.getCheckedRadioButtonId() == radio_btn_away.getId()) {
                    Toast.makeText(getActivity().getApplicationContext(), "i am in: "+r.getId(), Toast.LENGTH_SHORT).show();
                    odd = radio_btn_away.getText().toString();
                }

                SharedPreferencesConfig sharedPreferencesConfig = new SharedPreferencesConfig(getActivity().getApplicationContext());



                if (temp_club1.equals(CompetationData.ethiopian_premier_league_matches[0][0]) &&
                        temp_club2.equals(CompetationData.ethiopian_premier_league_matches[0][1])){
                    sharedPreferencesConfig.writeMatch_1_Odd(odd);
                    Toast.makeText(getActivity().getApplicationContext(), "i write on match 1", Toast.LENGTH_SHORT).show();
                }
                else if (temp_club1.equals(CompetationData.ethiopian_premier_league_matches[1][0]) &&
                        temp_club2.equals(CompetationData.ethiopian_premier_league_matches[1][1])){
                    sharedPreferencesConfig.writeMatch_2_Odd(odd);
                    Toast.makeText(getActivity().getApplicationContext(), "i write on match 2", Toast.LENGTH_SHORT).show();

                }
                else if (temp_club1.equals(CompetationData.ethiopian_premier_league_matches[2][0]) &&
                        temp_club2.equals(CompetationData.ethiopian_premier_league_matches[2][1])){
                    sharedPreferencesConfig.writeMatch_3_Odd(odd);
                    Toast.makeText(getActivity().getApplicationContext(), "i write on match 3", Toast.LENGTH_SHORT).show();

                }
                else if (temp_club1.equals(CompetationData.ethiopian_premier_league_matches[3][0]) &&
                        temp_club2.equals(CompetationData.ethiopian_premier_league_matches[3][1])){
                    sharedPreferencesConfig.writeMatch_4_Odd(odd);
                    Toast.makeText(getActivity().getApplicationContext(), "i write on match 4", Toast.LENGTH_SHORT).show();

                }


             //   sharedPreferencesConfig.writeMatch_1_Odd(odd);
//                Toast.makeText(getActivity().getApplicationContext(),
//                        "add: "+odd+" id r: "+ radio_group_main.getCheckedRadioButtonId()+ "id home: "+ radio_btn_home.getId()+"text: "+radio_btn_home.getText(),
//                        Toast.LENGTH_LONG).show();
            }
        });

        return view;

    }


    @Override
    public void onStop() {
        super.onStop();
    }
}
