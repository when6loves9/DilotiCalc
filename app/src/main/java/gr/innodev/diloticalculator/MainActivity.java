package gr.innodev.diloticalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        addListenerOnChk51();
        addListenerOnChk61();
        addListenerOnChkPlus();
        //final int[] game = new int[1];


        Button StartBtn = (Button)findViewById(R.id.StartBtn);

        StartBtn.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        CheckBox checkBox51 = (CheckBox) findViewById(R.id.checkBox51);
                        CheckBox checkBox61 = (CheckBox) findViewById(R.id.checkBox61);
                        CheckBox checkBoxplus =(CheckBox)findViewById(R.id.checkBoxPlus);
                        EditText plusNumber = (EditText)findViewById(R.id.PlusNumber);


                        TextView logoText = (TextView) findViewById(R.id.LogoText);
                        if (checkBox61.isChecked() == true) {
                            //game[0] =61;
                           // logoText.setText("Διάλεξες το παιχνίδι στα 61");
                            //setContentView(R.layout.activity_gamepage);
                            Intent gmpage = new Intent(v.getContext(),GamepageActivity.class);
                            gmpage.putExtra("game",61);
                            gmpage.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                            startActivity(gmpage);

                        } else if(checkBox51.isChecked()==true){
                            Intent gmpage = new Intent(v.getContext(),GamepageActivity.class);
                            gmpage.putExtra("game",51);
                            gmpage.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                            startActivity(gmpage);                        }
                        else if(checkBoxplus.isChecked()==true){
                            //logoText.setText("Διάλεξες το παιχνίδι στα " + plusNumber.getText());
                            Intent gmpage = new Intent(v.getContext(),GamepageActivity.class);
                            gmpage.putExtra("game",Integer.parseInt(plusNumber.getText().toString()));
                            gmpage.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                            startActivity(gmpage);
                        }
                        else{logoText.setText("Διάλεξε παιχνίδι");}
                    }
                }
        );

    }


    public void addListenerOnChk51() {
        CheckBox checkBox51 = (CheckBox)findViewById(R.id.checkBox51);

        checkBox51.setOnClickListener(new View.OnClickListener() {



            public void onClick(View v) {
                CheckBox checkBox61 = (CheckBox)findViewById(R.id.checkBox61);
                CheckBox checkBoxplus =(CheckBox)findViewById(R.id.checkBoxPlus);
                EditText plusNumber = (EditText)findViewById(R.id.PlusNumber);

                //is checkBox51 checked?
                if (((CheckBox) v).isChecked()) {
                    checkBox61.setChecked(false);
                    plusNumber.setFocusable(false);
                    plusNumber.setFocusableInTouchMode(false);
                    plusNumber.setText("");
                    checkBoxplus.setChecked(false);
                }

            }
        });

    }
    public void addListenerOnChk61() {
        CheckBox checkBox61 =(CheckBox)findViewById(R.id.checkBox61);

        checkBox61.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                CheckBox checkBox51 = (CheckBox)findViewById(R.id.checkBox51);
                EditText plusNumber = (EditText)findViewById(R.id.PlusNumber);
                CheckBox checkBoxplus =(CheckBox)findViewById(R.id.checkBoxPlus);

                //is checkBox61 checked?
                if (((CheckBox) v).isChecked()) {
                    checkBox51.setChecked(false);
                    checkBoxplus.setChecked(false);
                    plusNumber.setFocusable(false);
                    plusNumber.setFocusableInTouchMode(false);
                    plusNumber.setText("");
                    checkBoxplus.setChecked(false);

                }

            }
        });

    }
    public void addListenerOnChkPlus() {
        CheckBox checkBoxplus =(CheckBox)findViewById(R.id.checkBoxPlus);

        checkBoxplus.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                CheckBox checkBox51 = (CheckBox)findViewById(R.id.checkBox51);
                CheckBox checkBox61 = (CheckBox)findViewById(R.id.checkBox61);
                EditText plusNumber = (EditText)findViewById(R.id.PlusNumber);

                //is checkBoxPlus checked?
                if (((CheckBox) v).isChecked()) {
                    checkBox51.setChecked(false);
                    checkBox61.setChecked(false);
                    plusNumber.setFocusableInTouchMode(true);
                    plusNumber.setFocusable(true);

                }

            }
        });

    }


}

