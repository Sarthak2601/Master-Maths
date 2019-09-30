package com.dev.tt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.smarteist.autoimageslider.SliderView;

import java.util.Timer;
import java.util.TimerTask;

public class mainMenu extends AppCompatActivity {

    int currentPage = 0;
    Timer timer;
    final long DELAY_MS = 500;//delay in milliseconds before task is to be executed
    final long PERIOD_MS = 3000; // time in milliseconds between successive task executions
    int NUM_PAGES = 5;
    private AdView mAdView;


    SliderView sliderView;

    public void calculate(View view ){

        Intent cal = new Intent(mainMenu.this, calculator.class);
        startActivity(cal);

        finish();

    }

    public void times_table(View view){
        Intent tt = new Intent(mainMenu.this, times_tables.class);
        startActivity(tt);

        finish();

    }

    public void squares(View view ){

        Intent sq = new Intent(mainMenu.this, squares.class);
        startActivity(sq);

        finish();

    }

    public void cubes(View view ){

        Intent cube = new Intent(mainMenu.this, cubes.class);
        startActivity(cube);

        finish();

    }

    public void sqroots(View view){

        Intent sqr = new Intent(mainMenu.this, sqroot.class);
        startActivity(sqr);

        finish();

    }

    public void cbroots(View view){

        Intent cbr = new Intent(mainMenu.this, cbroot.class);
        startActivity(cbr);

        finish();

    }

    public void sntn(View view){


        Intent sntns = new Intent(mainMenu.this, sntns.class);
        startActivity(sntns);

        finish();

    }

    public void share(View view){

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain ");
        String shareBody =  "Master Maths! Download this app for awesome maths content. " + "https://play.google.com/store/apps/details?id=com.dev.tt ";
        String shareSub = "Master Maths ";
        intent.putExtra(Intent.EXTRA_SUBJECT,shareSub);
        intent.putExtra(Intent.EXTRA_TEXT,shareBody);

        startActivity(intent.createChooser(intent, "Share using... "));

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);



        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        ImageAdapter adapter = new ImageAdapter(this);
        viewPager.setAdapter(adapter);

        /*After setting the adapter use the timer */
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES-1) {
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);
            }
        };

        timer = new Timer(); // This will create a new Thread
        timer.schedule(new TimerTask() { // task to be scheduled
            @Override
            public void run() {
                handler.post(Update);
            }
        }, DELAY_MS, PERIOD_MS);


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        mAdView.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        });





    }

    }




