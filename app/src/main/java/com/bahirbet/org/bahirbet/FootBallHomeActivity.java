package com.bahirbet.org.bahirbet;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bahirbet.org.bahirbet.ExpandableRecyclerView.adapter.MyAdapter;
import com.bahirbet.org.bahirbet.helper.LocaleHelper;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.NumberFormat;
import java.util.concurrent.ThreadLocalRandom;

import io.paperdb.Paper;

public  class FootBallHomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public static FragmentManager fragmentManager;

    FloatingActionButton fab;
    Dialog selectedBetViewer, betAmoutViewer;
    PopupWindow f;
    DatabaseReference databaseReference;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase,"en"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foot_ball_home);
       fab = findViewById(R.id.fab);
        if (!networkAvaliable()){
         Snackbar.make(fab, "No internet connection!", Snackbar.LENGTH_LONG)
            .setAction("Action", null).show();
        }

        databaseReference = FirebaseDatabase.getInstance().getReference("Users");


        SharedPreferencesConfig sharedPreferencesConfig = new SharedPreferencesConfig(FootBallHomeActivity.this);
        String o2 = sharedPreferencesConfig.readMatch_2_odd();
        double odd2 = Double.parseDouble(o2.substring(0,o2.length()-1));
        Toast.makeText(this, String.format(" the value of odd 2 is ===> %s",odd2), Toast.LENGTH_LONG).show();
// todo ---> the following the onclick listner of the floastinfg action button

        selectedBetViewer = new Dialog(this);
        betAmoutViewer = new Dialog(this);

        // todo the following set of code is the language stuff until the say 'finish'


        // init paper first
        Paper.init(this);
        //default language is english
        String language = Paper.book().read("language");
        if (language == null)
            Paper.book().write("language","en");
        updateView((String)Paper.book().read("language"));


// todo the language suff ends here

        fragmentManager = getSupportFragmentManager();
        if (findViewById(R.id.fragment_container) != null){
            if (savedInstanceState != null){
                return;
            }
            else{
                fragmentManager.beginTransaction().add(R.id.fragment_container,new ListOfCompetitionFragment(),null).commit();
            }
        }




        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private boolean networkAvaliable() {
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    private void updateView(String language) {
        Context context = LocaleHelper.setLocale(this,language);


    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        ((MyAdapter)ListOfCompetitionFragment.recyclerView.getAdapter()).onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.foot_ball_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
        else if (id == R.id.language_amharic){
            Paper.book().write("language","am");
            updateView((String)Paper.book().read("language"));
        }
        else if(id == R.id.language_english){
            Paper.book().write("language","en");
            updateView((String)Paper.book().read("language"));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void showPopUp(View view){
        TextView t;
        selectedBetViewer.setContentView(R.layout.selected_bet_viewer);


        SharedPreferencesConfig s = new SharedPreferencesConfig(getApplicationContext());
        String a = s.readMatch_1_odd();

        selectedBetViewer.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        selectedBetViewer.show();
    }
// todo - the following set of code is the operation after the button betOn is clicked.

    public boolean checkPermission(String permission){
        int check = ContextCompat.checkSelfPermission(this, permission);
        return (check == PackageManager.PERMISSION_GRANTED);
    }

    public void betOnClicked(MenuItem item) {

        SharedPreferencesConfig sharedPreferencesConfig = new SharedPreferencesConfig(getApplicationContext());
        String o1 = sharedPreferencesConfig.readMatch_1_odd();
        String o2 = sharedPreferencesConfig.readMatch_2_odd();
        String o3 = sharedPreferencesConfig.readMatch_3_odd();
        String o4 = sharedPreferencesConfig.readMatch_4_odd();

        double odd1 = Double.parseDouble(o1.substring(0,o1.length()-1));
        double odd2 = Double.parseDouble(o2.substring(0,o2.length()-1));
        double odd3 = Double.parseDouble(o3.substring(0,o3.length()-1));
        double odd4 = Double.parseDouble(o4.substring(0,o4.length()-1));
        Toast.makeText(this, String.format("%s - %s - %s - %s", odd1,odd2,odd3,odd4), Toast.LENGTH_LONG).show();
        final double total_odd = odd1*odd2*odd3*odd4;
        betAmoutViewer.setContentView(R.layout.bet_amount_viewer);
        betAmoutViewer.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        final EditText amountEditText = betAmoutViewer.findViewById(R.id.amountEditText);

        final double amount = Double.parseDouble(amountEditText.getText().toString());

        final TextView possible_win = betAmoutViewer.findViewById(R.id.possible_win);
        TextView totalBettingAmount = betAmoutViewer.findViewById(R.id.totalBettingAmount);

        final NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);

        totalBettingAmount.setText(String.format("%s",nf.format(total_odd)));
        final double[] possible_win_amount = {amount * total_odd};
        nf.setMinimumFractionDigits(2);

        possible_win.setText(nf.format(possible_win_amount[0]));
        amountEditText.addTextChangedListener(new TextWatcher() {







            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!amountEditText.getText().toString().equals("")){
                    double amount = Double.parseDouble(amountEditText.getText().toString());

                    possible_win_amount[0] = amount*total_odd;

                    possible_win.setText(nf.format(possible_win_amount[0]));
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        Button btnX = betAmoutViewer.findViewById(R.id.btnX);
        btnX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                betAmoutViewer.dismiss();
            }
        });

        Button btnR = betAmoutViewer.findViewById(R.id.btnR);
        btnR.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                double SMS_TRANSACTION_AMOUNT = 0.2;
                String PHONE_NUMBER = "0980277644";
                int betCouponCode = generateRndNumber();


                if (checkPermission(Manifest.permission.SEND_SMS)){
                    SmsManager smsManager = SmsManager.getDefault();

                    int amt = Integer.parseInt(amountEditText.getText().toString());
                    double NumberOfMessage = Math.round(amt/SMS_TRANSACTION_AMOUNT);
                    int n = (int)(NumberOfMessage);
                    for(int i = 1;i <= n;i++){

                        smsManager.sendTextMessage(PHONE_NUMBER,
                                null, String.format("msg %d", i),null,null );

                    }

                    addUserToFirebase(betCouponCode,Double.parseDouble(amountEditText.getText().toString()));

                    


                    ShowNotification(betCouponCode);
                    betAmoutViewer.dismiss();
                }


            }

            private void ShowNotification(int betCouponCode) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(),"channelId");

                builder.setBadgeIconType(R.drawable.logo);
                builder.setSmallIcon(R.drawable.logo);
                builder.setContentTitle(getResources().getString(R.string.app_name));
                builder.setSound(Settings.System.DEFAULT_NOTIFICATION_URI);
                builder.setContentText(getString(R.string.your_coupon_code_is)+betCouponCode);
                builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
                NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getApplicationContext());
                notificationManagerCompat.notify(001,builder.build());



            }

            private void addUserToFirebase(int betCouponCode,double betAmount) {
                double amount = Double.parseDouble(amountEditText.getText().toString());
                possible_win_amount[0] = amount*total_odd;
                User user = new User("09113243", String.format("%d", betCouponCode),String.format("%s", nf.format(total_odd)),
                        ""+betAmount, ""+possible_win_amount[0]);

                databaseReference.child(String.format("%d", betCouponCode)).setValue(user);
//                SharedPreferencesConfig sharedPreferencesConfig = new SharedPreferencesConfig(getApplicationContext());
//                sharedPreferencesConfig.writeMatch_1_Odd("1x");
//                sharedPreferencesConfig.writeMatch_2_Odd("1x");
//                sharedPreferencesConfig.writeMatch_3_Odd("1x");
//                sharedPreferencesConfig.writeMatch_4_Odd("1x");
            }

        });

        betAmoutViewer.show();
    }


    private int generateRndNumber() {
         return ThreadLocalRandom.current().nextInt(100000000, 999999999);
    }

}

