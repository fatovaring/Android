package com.ftovar.sgoliver.textandimages;

import android.graphics.Color;
import android.graphics.Typeface;
import android.renderscript.Type;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.Spannable;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private ImageView vImage;
    private TextView vLabel;
    private EditText vEditText;
    private Button vButton;
    private Button vButtonBold;
    private Button vBtnHtml;
    private TextInputLayout vLytHint;
    private EditText vPhone;
    private Button vBtnCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vImage = (ImageView) findViewById(R.id.imageView);
        vImage.setImageResource(R.drawable.city);

        vLabel = (TextView) findViewById(R.id.lblText);
        String vText = vLabel.getText().toString();
        vText += "123";
        vLabel.setText(vText);
        vLabel.setBackgroundColor(Color.BLUE);

        vEditText = (EditText) findViewById(R.id.inpText);
        String text = vEditText.getText().toString();
        vEditText.setText("Hello World!");

        //Create a new Editable object
        final Editable vSpanStr = Editable.Factory.getInstance().newEditable("Esto es un simulacro");
        //Add bold to a word
        vSpanStr.setSpan(new StyleSpan(Typeface.BOLD), 11, 19, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        //Button Set text
        vButton = (Button) findViewById(R.id.btnAction);
        vButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vEditText.setText(vSpanStr);
            }
        });

        //Button Set Bold
        vButtonBold = (Button) findViewById(R.id.btnBold);
        vButtonBold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spannable vTxt = vEditText.getText();
                int vStart = vEditText.getSelectionStart();
                int vEnd = vEditText.getSelectionEnd();

                if(vStart > 0 && vEnd > 0) {
                    vTxt.setSpan(new StyleSpan(Typeface.BOLD), vStart, vEnd, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                }
            }
        });

        //Button Set HTML
        vLytHint = (TextInputLayout) findViewById(R.id.lytHint);
        vBtnHtml = (Button) findViewById(R.id.btnHtml);

        vBtnHtml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get HTML
                String vHtml = Html.toHtml(vEditText.getText());
                //Set HTML
                vLabel.setText(Html.fromHtml(vHtml), TextView.BufferType.EDITABLE);

                //Clear Required
                vLytHint.setError(null);
            }
        });

        //Set Message below field
        vPhone = (EditText) findViewById(R.id.inpHint);
        vBtnCheck = (Button) findViewById(R.id.btnCheck);

        vLytHint.setErrorEnabled(true);
        vBtnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String vTxt = vPhone.getText().toString();

                if(vTxt == null || vTxt.isEmpty()){
                    vLytHint.setError("Required");
                }
            }
        });
    }
}
