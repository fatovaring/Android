package com.ftovar.sgoliver.helloandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SaludoActivity extends AppCompatActivity {

    private TextView txtSaludo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saludo);

        //Get reference of the controls
        txtSaludo = (TextView) findViewById(R.id.txtSaludo);

        //Recover the information transferred in the intent
        Bundle vBundle = this.getIntent().getExtras();

        //Build the message to show
        txtSaludo.setText("Hi " + vBundle.getString("NOMBRE"));
    }
}
