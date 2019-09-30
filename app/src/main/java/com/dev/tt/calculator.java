package com.dev.tt;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.text.DecimalFormat;


public class calculator extends AppCompatActivity {
private AdView mAdView;
    EditText editText;
    TextView textView;
    int a ;
    String b;
    Double c;
    String d;
    DecimalFormat df = new DecimalFormat("0.00");

    public void onBackPressed(){

        startActivity(getParentActivityIntent());
        finish();


    }


   public void square(View view){



        if (editText.getText().toString().isEmpty()){

            Toast.makeText(calculator.this, "Please enter a number ", Toast.LENGTH_SHORT).show();
        }

        else{

            b = editText.getText().toString();
            a = Integer.parseInt(b);
            d = Integer.toString(a*a);

            textView.setText("Answer : "+ d);
        }


   }


    public void Cubes(View view){


        if (editText.getText().toString().isEmpty()){

            Toast.makeText(calculator.this, "Please enter a number ", Toast.LENGTH_SHORT).show();
        }

        else{

            b = editText.getText().toString();
            a = Integer.parseInt(b);
            d = Integer.toString(a*a*a);
            textView.setText("Answer : "+ d);
        }


    }


    public void sqrt(View view){


        if (editText.getText().toString().isEmpty()){

            Toast.makeText(calculator.this, "Please enter a number ", Toast.LENGTH_SHORT).show();
        }

        else{

            b = editText.getText().toString();
            a = Integer.parseInt(b);

            c = Math.sqrt(a);
            d = df.format(c);

            textView.setText("Answer : "+d);
        }


    }

    public void cbrt (View view){


        if (editText.getText().toString().isEmpty()){

            Toast.makeText(calculator.this, "Please enter a number ", Toast.LENGTH_SHORT).show();
        }

        else{

            b = editText.getText().toString();
            a = Integer.parseInt(b);

            c = Math.cbrt(a);
            d = df.format(c);

            textView.setText("Answer : "+ d);
        }


    }






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        editText = (EditText) findViewById(R.id.poe);
        textView = (TextView) findViewById(R.id.aafat);





        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Super Calculator");
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
