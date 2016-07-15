package com.ftovar.sgoliver.buttons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private Button vbtnSimpleButton;
    private TextView vlblMessage;
    private ToggleButton vbtnToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vbtnSimpleButton = (Button)findViewById(R.id.btnSimpleButton);
        vlblMessage = (TextView)findViewById(R.id.lblMessage);
        vbtnToggle = (ToggleButton)findViewById(R.id.btnToggle);

        vbtnSimpleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vlblMessage.setText("Simple Button has been clicked");
            }
        });

        vbtnToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(vbtnToggle.isChecked()){
                    vlblMessage.setText("Toggle: ON");
                }
                else{
                    vbtnToggle.setText("Toggle: OFF");
                }
            }
        });
    }
}
