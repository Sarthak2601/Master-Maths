package com.dev.tt;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class squares extends AppCompatActivity {

    private AdView mAdView;

    public void onBackPressed(){

        startActivity(getParentActivityIntent());
        finish();


    }

    public void squares1(View view){

        Intent intent = new Intent(squares.this, S1.class);
        startActivity(intent);

        finish();

    }

    public void squares2(View view){

        Intent intent = new Intent(squares.this, S2.class);
        startActivity(intent);

        finish();

    }

    public void squares3(View view){

        Intent intent = new Intent(squares.this, S3.class);
        startActivity(intent);

        finish();

    }

    public void squares4(View view){

        Intent intent = new Intent(squares.this, S4.class);
        startActivity(intent);

        finish();

    }

    public void squares5(View view){

        Intent intent = new Intent(squares.this, S5.class);
        startActivity(intent);

        finish();

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_squares);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Squares");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

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

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
