package com.ftovar.sgoliver.helloandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText txtNombre;
    private Button btnAceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get the reference to the controls in the interface
        txtNombre = (EditText)findViewById(R.id.txtNombre);
        btnAceptar = (Button)findViewById(R.id.btnAceptar);

        //btnAceptar: OnClick Event
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create the intent
                Intent vIntent = new Intent(MainActivity.this, SaludoActivity.class);

                //Create the information to transfer between the activities
                Bundle vBundle = new Bundle();
                vBundle.putString("NOMBRE", txtNombre.getText().toString());

                //Add the information to the intent
                vIntent.putExtras(vBundle);

                //Start the new Activity
                startActivity(vIntent);
            }
        });
    }
}
