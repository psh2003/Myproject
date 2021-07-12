package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView text1,text2;
    CheckBox chkagree;
    RadioGroup rdgroup1;
    RadioButton rdodog,rdocat,rdorabbit;
    Button btnok;
    ImageView imgpet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("애완동물 사진 보기");

        text1 = (TextView)findViewById(R.id.text1);
        chkagree=(CheckBox) findViewById(R.id.chkagree);

        text2=(TextView) findViewById(R.id.text2);
        rdgroup1=(RadioGroup) findViewById(R.id.rdgroup1);
        rdodog=(RadioButton) findViewById(R.id.rdodog);
        rdocat=(RadioButton) findViewById(R.id.rdocat);
        rdorabbit=(RadioButton) findViewById(R.id.rdorabbit);

        btnok = (Button) findViewById(R.id.btnok);
        imgpet=(ImageView) findViewById(R.id.imgpet);

        chkagree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (chkagree.isChecked()==true) {
                    text2.setVisibility(android.view.View.VISIBLE);
                    rdgroup1.setVisibility(android.view.View.VISIBLE);
                    btnok.setVisibility(android.view.View.VISIBLE);
                    imgpet.setVisibility(android.view.View.VISIBLE);
                }
                else {
                    text2.setVisibility(android.view.View.INVISIBLE);
                    rdgroup1.setVisibility(android.view.View.INVISIBLE);
                    btnok.setVisibility(android.view.View.INVISIBLE);
                    imgpet.setVisibility(android.view.View.INVISIBLE);
                }
            }
        });
        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (rdgroup1.getCheckedRadioButtonId()){
                    case R.id.rdodog:
                        imgpet.setImageResource(R.drawable.dog);
                        break;
                    case R.id.rdocat:
                        imgpet.setImageResource(R.drawable.cat);
                        break;
                    case R.id.rdorabbit:
                        imgpet.setImageResource(R.drawable.rabbit);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(),"동물 먼저 선택하세요",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}