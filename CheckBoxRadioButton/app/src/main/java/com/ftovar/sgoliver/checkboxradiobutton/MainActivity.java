package com.ftovar.sgoliver.checkboxradiobutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private CheckBox vChkItem;
    private TextView vTxtView;
    private RadioGroup vRadioGroup;
    private RadioButton vOptUno;
    private RadioButton vOptDos;
    private TextView vLblRadioChange;
    private TextView vLblRadioClick;

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

        //RadioGroup
        vRadioGroup = (RadioGroup) findViewById(R.id.rdGroup);
        vOptUno = (RadioButton) findViewById(R.id.optUno);
        vOptDos = (RadioButton) findViewById(R.id.optDos);
        vLblRadioChange = (TextView) findViewById(R.id.lblChange);
        vLblRadioClick = (TextView) findViewById(R.id.lblClicked);

        vRadioGroup.clearCheck();;
        vRadioGroup.check(R.id.optDos);
        vLblRadioClick.setText("Selected:" + vRadioGroup.getCheckedRadioButtonId());

        //RADIO: Onclick (Options)
        View.OnClickListener vListenerClick = new View.OnClickListener() {
            @Override
            public void onClick(View view){
                String vOption = "";

                switch (view.getId()){
                    case R.id.optUno:{
                        vOption = "Option 1";
                        break;
                    }
                    case R.id.optDos:{
                        vOption = "Option 2";
                        break;
                    }
                }

                vLblRadioClick.setText("Clicked: " + vOption);
            }
        };

        //Set listener
        vOptUno.setOnClickListener(vListenerClick);
        vOptDos.setOnClickListener(vListenerClick);

        //RADIO: Onchange
        vRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String vOption = "";

                switch (checkedId){
                    case R.id.optUno:{
                        vOption = "Option 1";
                        break;
                    }
                    case R.id.optDos:{
                        vOption = "Option 2";
                        break;
                    }
                }

                vLblRadioChange.setText("Change: " + vOption);
            }
        });
    }
}
