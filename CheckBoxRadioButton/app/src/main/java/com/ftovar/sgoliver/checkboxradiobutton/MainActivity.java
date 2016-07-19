package com.ftovar.sgoliver.checkboxradiobutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private CheckBox vChkItem;
    private TextView vTxtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vChkItem = (CheckBox) findViewById(R.id.chkItem);
        vTxtView = (TextView) findViewById(R.id.txtView);

        //CHECKBOX: Onclick
        vChkItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean vIsChecked = ((CheckBox)v).isChecked();

                if(vIsChecked) {
                    vChkItem.setText("Click!: Checked");
                }
                else {
                    vChkItem.setText("Click!: Unchecked");
                }
            }
        });

        //CHECKBOX: Onchange
        vChkItem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    vTxtView.setText("Change!: Control Checked");
                }
                else {
                    vTxtView.setText("Change!: Control unchecked");
                }
            }
        });
    }
}
