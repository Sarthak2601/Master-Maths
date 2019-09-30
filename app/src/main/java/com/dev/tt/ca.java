package com.dev.tt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ca extends AppCompatActivity {

    TextView textView;

    public void square(int a){

        int fi = a * a * a;

        textView.setText("Square is " + fi);


    }


/*
    EditText entry =  (EditText) findViewById(R.id.pointOfEntry);
    TextView finalText = (TextView) findViewById(R.id.textView5);


    String a = entry.getText().toString();

    int b = Integer.parseInt(a);

    public void square(View view){

        int c = b * b ;

        finalText.setText("Square of " + a + " is " + b * b );

    }

    public void cube(View view){

        finalText.setText("Square of " + a + " is " + b * b * b );

    }
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ca);

        EditText editText = (EditText) findViewById(R.id.poe);

        TextView textView = (TextView) findViewById(R.id.aafat);

        String abc = editText.getText().toString();
        int bdc = Integer.parseInt(abc);

        square(bdc);


    }
}
