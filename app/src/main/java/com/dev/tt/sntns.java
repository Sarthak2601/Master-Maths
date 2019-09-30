package com.dev.tt;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class sntns extends AppCompatActivity {
private AdView mAdView;
    TextView textView6;

    public void onBackPressed() {

        startActivity(getParentActivityIntent());
        finish();


    }

    class Numbers {

        int number;

        public boolean isSquare() {

            double squareroot = Math.sqrt(number);

            if (squareroot == Math.floor(squareroot)) {
                return true;
            } else {
                return false;

            }


        }

        public boolean isTriangular() {

            {
                int x = 1;
                int triangularNumber = 1;

                while (triangularNumber < number) {

                    x++;
                    triangularNumber = triangularNumber + x;
                }

                if (triangularNumber == number) {
                    return true;
                } else {
                    return false;

                }
            }

        }


    }

    public void calc(View view) {


        String message = "";
        EditText newNum = (EditText) findViewById(R.id.editText);

        if (newNum.getText().toString().isEmpty()) {

            message = "Please enter a number ";

        } else {

            Numbers myNum = new Numbers();
            myNum.number = Integer.parseInt(newNum.getText().toString());


            if (myNum.isSquare()) {

                if (myNum.isTriangular()) {
                    message = newNum.getText().toString() + " is both a square and a triangular number. ";
                } else {
                    message = newNum.getText().toString() + " is a square but not a triangular number. ";
                }

            } else {

                if (myNum.isTriangular()) {
                    message = newNum.getText().toString() + " is a triangular but not a square number. ";
                } else {
                    message = newNum.getText().toString() + " is neither a triangular nor a square number. ";
                }
            }

            System.out.println(myNum.isSquare());


        }

        textView6.setText(message);


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sntns);

        textView6 = (TextView) findViewById(R.id.textView6);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Square n Triangular Numbers");
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
