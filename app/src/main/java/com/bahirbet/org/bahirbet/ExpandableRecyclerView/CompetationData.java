package com.bahirbet.org.bahirbet.ExpandableRecyclerView;

import com.bahirbet.org.bahirbet.R;

public abstract class CompetationData {

    public static String[][] ethiopian_premier_league_matches = new String[][]{
            {"Dedebit","Bair Dar Kenema"},
            {"Debub Police","Shire Endaselassie"},
            {"Mekelle Kenema","Adama City"},
            {"Saint George ","Defense Force"}};

    public static String[][] english_primier_league_matches = new String[][]{
            {"Machester United","Leicester City"},
            {"Arsenal","Manchester City"},
            {"Burnley FC","Chelsea"},};

    String[][] speain_laliga = new String[][]{
            {"Machester United","Liver Pool"},
            {"Arsenal","Manchester City"},
            {"Watford","Totnhum"},};

    String[][] german_bundesliga = new String[][]{
            {"Machester United","Liver Pool"},
            {"Arsenal","Manchester City"},
            {"Watford","Totnhum"}};

    public static int[][] et_clubs_logo = new int[][]{
            {R.drawable.dedebit,R.drawable.bahir_dar_kenema},
            {R.drawable.debub_polixe,R.drawable.shire_endeslassie},
            {R.drawable.mekele_kenema,R.drawable.adama},
            {R.drawable.saint_george,R.drawable.defense_force}
    };

    public static int[][] en_clubs_logo = new int[][]{
            {R.drawable.man_united,R.drawable.leicester_city},
            {R.drawable.arsenal,R.drawable.man_city},
            {R.drawable.burnley_fc,R.drawable.chelsea},
    };

    public static String[][] ethipian_pre_match_odd = new String[][]{
            {"3.3x","4.9x","2.3x"},
            {"3.9x","5.6x","1.2x"},
            {"2.5x","2.1x","1.5x"},
            {"4.2x","1.6x","2.1x"},
            
    };

}
