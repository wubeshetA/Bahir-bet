package com.bahirbet.org.bahirbet;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesConfig {
    private SharedPreferences match1, match2,match3,match4;
    private Context context;
    String match1_name;
    String match2_name;
    String match3_name;
    String match4_name;
    public SharedPreferencesConfig(Context context) {
         match1_name = DataToPassMatchDetail.m1_club_1_name + "Vs"+DataToPassMatchDetail.m1_club_2_name;
         match2_name = DataToPassMatchDetail.m2_club_1_name +"Vs"+DataToPassMatchDetail.m2_club_2_name;
         match3_name = DataToPassMatchDetail.m3_club_1_name +"Vs"+DataToPassMatchDetail.m3_club_2_name;
         match4_name = DataToPassMatchDetail.m4_club_1_name + "Vs" + DataToPassMatchDetail.m4_club_2_name;
        this.context = context;

        match1 = context.getSharedPreferences(match1_name, Context.MODE_PRIVATE);
        match2 = context.getSharedPreferences(match2_name, Context.MODE_PRIVATE);
        match3 = context.getSharedPreferences(match3_name, Context.MODE_PRIVATE);
        match4 = context.getSharedPreferences(match4_name, Context.MODE_PRIVATE);


    }
    public void writeMatch_1_Odd(String odd){
        SharedPreferences.Editor editor = match1.edit();
        editor.putString(match1_name,odd);
        editor.apply();
    }

    public void writeMatch_2_Odd(String odd){
        SharedPreferences.Editor editor = match2.edit();
        editor.putString(match2_name,odd);
        editor.apply();
    }
    public void writeMatch_3_Odd(String odd){
        SharedPreferences.Editor editor = match3.edit();
        editor.putString(match3_name,odd);
        editor.apply();
    }
    public void writeMatch_4_Odd(String odd){
        SharedPreferences.Editor editor = match4.edit();
        editor.putString(match4_name,odd);
        editor.apply();
    }






    public String readMatch_1_odd(){
        String odd = match1.getString(match1_name,"1x");
        return odd;
    }
    public String readMatch_2_odd(){
        String odd = match2.getString(match2_name,"1x");
        return odd;
    }
    public String readMatch_3_odd(){
        String odd = match3.getString(match3_name,"1x");
        return odd;
    }
    public String readMatch_4_odd(){
        String odd = match4.getString(match4_name,"1x");
        return odd;
    }
}
