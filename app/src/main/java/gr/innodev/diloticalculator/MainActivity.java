package gr.innodev.diloticalculator;
import android.os.Handler;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;

import com.dd.morphingbutton.MorphingButton;
import com.hanks.library.AnimateCheckBox;


public class MainActivity extends AppCompatActivity {
    public int dimen(@DimenRes int resId) {
        return (int) getResources().getDimension(resId);
    }
    public int color(@ColorRes int resId) {
        return getResources().getColor(resId);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        addListenerOnChk51();
        addListenerOnChk61();
        addListenerOnChkPlus();
        //final int[] game = new int[1];


        //Button StartBtn = (Button)findViewById(R.id.StartBtn);
        final MorphingButton StartBtn = (MorphingButton) findViewById(R.id.StartBtn);

        final MorphingButton.Params circle = MorphingButton.Params.create()
                .duration(300)
                .cornerRadius(dimen(R.dimen.mb_height_28)) // 8 dp
                .width(dimen(R.dimen.mb_height_56)) // 28 dp
                .height(dimen(R.dimen.mb_height_56)) // 28 dp
                .color(color(R.color.green)) // normal state color
                .colorPressed(color(R.color.green_dark)) // pressed state color
                .icon(R.drawable.ic_done); // icon
        StartBtn.setOnClickListener(
                new Button.OnClickListener() {
                    // inside on click event


                    public void onClick(final View v) {

                        StartBtn.morph(circle);
                        Handler mHandler = new Handler();

                        AnimateCheckBox checkBox51 = (AnimateCheckBox) findViewById(R.id.checkBox51);
                        // sample demonstrate how to morph button to green circle with icon



                    AnimateCheckBox checkBox61 = (AnimateCheckBox) findViewById(R.id.checkBox61);
                        AnimateCheckBox checkBoxplus =(AnimateCheckBox)findViewById(R.id.checkBoxPlus);
                        EditText plusNumber = (EditText)findViewById(R.id.PlusNumber);


                        TextView logoText = (TextView) findViewById(R.id.LogoText);
                        if (checkBox61.isChecked()) {

                            //game[0] =61;
                           // logoText.setText("Διάλεξες το παιχνίδι στα 61");
                            //setContentView(R.layout.activity_gamepage);
                            final Intent gmpage = new Intent(v.getContext(), GamepageActivity.class);
                            gmpage.putExtra("game", 61);
                            gmpage.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                            //we need a delay of 1 secs
                            Runnable gmpageRun = new Runnable() {
                                public void run() {
                                    startActivity(gmpage);
                                    morphToSquare(StartBtn, 200);

                                }
                            };

                            mHandler.postDelayed(gmpageRun, 1000);



                        } else if(checkBox51.isChecked()){


                            final Intent gmpage = new Intent(v.getContext(), GamepageActivity.class);
                            gmpage.putExtra("game", 51);
                            gmpage.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                            //we need a delay of 1 secs
                            Runnable gmpageRun = new Runnable() {
                                public void run() {
                                    startActivity(gmpage);
                                    morphToSquare(StartBtn, 200);

                                }
                            };

                            mHandler.postDelayed(gmpageRun, 1000);
                                                 }
                        else if(checkBoxplus.isChecked()&&(!plusNumber.getText().equals(null)||!plusNumber.getText().equals(""))){
                            //logoText.setText("Διάλεξες το παιχνίδι στα " + plusNumber.getText());
                            final Intent gmpage = new Intent(v.getContext(),GamepageActivity.class);
                            gmpage.putExtra("game",Integer.parseInt(plusNumber.getText().toString()));
                            gmpage.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                            //we need a delay of 1 secs
                            Runnable gmpageRun = new Runnable() {
                                public void run() {
                                    startActivity(gmpage);
                                    morphToSquare(StartBtn, 200);

                                }
                            };

                            mHandler.postDelayed(gmpageRun, 1000);                        }
                        else{logoText.setText("Διάλεξε παιχνίδι");}
                    }
                }
        );

    }


    public void addListenerOnChk51() {
        final AnimateCheckBox checkBox51 = (AnimateCheckBox)findViewById(R.id.checkBox51);
        checkBox51.setOnCheckedChangeListener(new AnimateCheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(View buttonView, boolean isChecked) {
                AnimateCheckBox checkBox61 = (AnimateCheckBox) findViewById(R.id.checkBox61);
                AnimateCheckBox checkBoxplus = (AnimateCheckBox) findViewById(R.id.checkBoxPlus);
                EditText plusNumber = (EditText) findViewById(R.id.PlusNumber);

                //is checkBox51 checked?
                if (checkBox51.isChecked()) {
                    checkBox61.setChecked(false);
                    plusNumber.setFocusable(false);
                    plusNumber.setFocusableInTouchMode(false);
                    plusNumber.setText(null);
                    checkBoxplus.setChecked(false);
                }

            }
        });

    }
    public void addListenerOnChk61() {
        final AnimateCheckBox checkBox61 =(AnimateCheckBox)findViewById(R.id.checkBox61);
checkBox61.setOnCheckedChangeListener(new AnimateCheckBox.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(View buttonView, boolean isChecked) {
        AnimateCheckBox checkBox51 = (AnimateCheckBox) findViewById(R.id.checkBox51);
        EditText plusNumber = (EditText) findViewById(R.id.PlusNumber);
        AnimateCheckBox checkBoxplus = (AnimateCheckBox) findViewById(R.id.checkBoxPlus);

        //is checkBox61 checked?
        if (checkBox61.isChecked()) {
            checkBox51.setChecked(false);
            checkBoxplus.setChecked(false);
            plusNumber.setFocusable(false);
            plusNumber.setFocusableInTouchMode(false);
            plusNumber.setText(null);
            checkBoxplus.setChecked(false);

        }
    }



});

                                      }
        // checkBox61.setOnClickListener(new View.OnClickListener() {


           /* public void onClick(View v) {
                AnimateCheckBox checkBox51 = (AnimateCheckBox) findViewById(R.id.checkBox51);
                EditText plusNumber = (EditText) findViewById(R.id.PlusNumber);
                AnimateCheckBox checkBoxplus = (AnimateCheckBox) findViewById(R.id.checkBoxPlus);

                //is checkBox61 checked?
                if (((AnimateCheckBox) v).isChecked()) {
                    checkBox51.setChecked(false);
                    checkBoxplus.setChecked(false);
                    plusNumber.setFocusable(false);
                    plusNumber.setFocusableInTouchMode(false);
                    plusNumber.setText("");
                    checkBoxplus.setChecked(false);

                }

            }
        });

    }*/
    //morph to squre for MorphButtons
    private void morphToSquare(final MorphingButton btnMorph, int duration) {
        MorphingButton.Params square = MorphingButton.Params.create()
                .duration(duration)
                .cornerRadius(dimen(R.dimen.mb_corner_radius_2))
                .width(dimen(R.dimen.mb_width_200))
                .height(dimen(R.dimen.mb_height_56))
                .color(color(R.color.mb_blue))
                .colorPressed(color(R.color.mb_blue_dark))
                .text(getString(R.string.StartPlay))
                ;
        btnMorph.morph(square);
    }

    public void addListenerOnChkPlus() {
        final AnimateCheckBox checkBoxplus =(AnimateCheckBox)findViewById(R.id.checkBoxPlus);

        checkBoxplus.setOnCheckedChangeListener(new AnimateCheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(View buttonView, boolean isChecked) {
                AnimateCheckBox checkBox51 = (AnimateCheckBox) findViewById(R.id.checkBox51);
                AnimateCheckBox checkBox61 = (AnimateCheckBox) findViewById(R.id.checkBox61);
                EditText plusNumber = (EditText) findViewById(R.id.PlusNumber);

                //is checkBoxPlus checked?
                if (checkBoxplus.isChecked()) {
                    checkBox51.setChecked(false);
                    checkBox61.setChecked(false);
                    plusNumber.setFocusableInTouchMode(true);
                    plusNumber.setFocusable(true);

                }

            }
        });

    }


}

