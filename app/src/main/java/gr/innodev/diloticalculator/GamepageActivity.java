package gr.innodev.diloticalculator;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.dd.morphingbutton.MorphingButton;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

import javax.xml.datatype.Duration;


/**
 * Created by thanostestebasis on 10/17/15.
 */




public class GamepageActivity extends AppCompatActivity {
    public int dimen(@DimenRes int resId) {
        return (int) getResources().getDimension(resId);
    }
    public int color(@ColorRes int resId) {
        return getResources().getColor(resId);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamepage);
        //final int data = Integer.getInteger(getIntent().getExtras().getString("game").toString());
        final int da = getIntent().getIntExtra("game", 0);
        TextView game = (TextView) findViewById(R.id.gameTxt);
        game.setText("Παιχνίδι στα " + da);
        //EditText teamAnewScore = (EditText)findViewById(R.id.TeamAscore);
        //EditText teamBnewScore = (EditText)findViewById(R.id.TeamBscore);
        final int[] check = {0};
        final int[] check2 = {0};
        Resources r = getResources();
        final String[] mTestArray = r.getStringArray(R.array.score_kseres);
        final TextView kseresA = (TextView) findViewById(R.id.kseresA);
        kseresA.setText(mTestArray[0]);
        final int[] pressKseresA = {0};

        final Spinner scoreA = (Spinner) findViewById(R.id.TeamAScoreSelect);
        final Spinner scoreB = (Spinner) findViewById(R.id.TeamBScoreSelect);

//kseresAplus + kseresAminus Buttons

        final Button kseresAplus = (Button) findViewById(R.id.plusA);
        final Button kseresAminus = (Button) findViewById(R.id.minusA);

        kseresAplus.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        if (pressKseresA[0] < 10) {

                            kseresA.setText(mTestArray[(++pressKseresA[0])]);
                        }

                    }
                }
        );
        kseresAminus.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        if (pressKseresA[0] > 0) {
                            kseresA.setText(mTestArray[(--pressKseresA[0])]);
                        }

                    }
                }
        );


        final TextView kseresB = (TextView) findViewById(R.id.kseresB);

        kseresB.setText(mTestArray[0]);
        final int[] pressKseresB = {0};
// kseresBplus + kseresBminus buttons
        final Button kseresBplus = (Button) findViewById(R.id.plusB);
        final Button kseresBminus = (Button) findViewById(R.id.minusB);



            kseresBplus.setOnClickListener(
                    new Button.OnClickListener() {
                        public void onClick(View v) {
                            if (pressKseresB[0] < 10) {

                                kseresB.setText(mTestArray[(++pressKseresB[0])]);
                            }

                        }
                    }
            );
            kseresBminus.setOnClickListener(
                    new Button.OnClickListener() {
                        public void onClick(View v) {
                            if (pressKseresB[0] > 0) {
                                kseresB.setText(mTestArray[(--pressKseresB[0])]);
                            }

                        }
                    }
            );


        //List<String> list=new ArrayList<String>();
        //list.add
        final int[] initSelection = {0};
        initSelection[0] = 11;
        final CheckBox cutcards = (CheckBox) findViewById(R.id.cutCards);
        cutcards.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //do stuff
                if (isChecked == true) {

                    initSelection[0] = 7;
                    cutadapterchange1();
                    check[0] = 0;
                    check2[0] = 0;


                } else {

                    initSelection[0] = 11;
                    cutadapterchange2();
                    check[0] = 0;
                    check2[0] = 0;
                }
            }
        });

        scoreA.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override


            public void onItemSelected(AdapterView<?> parentView, View selectedItemView,
                                       int position, long id) {
                check[0]++;//to not change values on initialization
                if (check[0] > 1)
                    scoreB.setSelection(initSelection[0] - scoreA.getSelectedItemPosition());



            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
                scoreB.setSelection(0);
            }


        });
        scoreB.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override


            public void onItemSelected(AdapterView<?> parentView, View selectedItemView,
                                       int position, long id) {
                check2[0]++;//to not change values on initialization
                if (check2[0] > 1)
                    scoreA.setSelection(initSelection[0] - scoreB.getSelectedItemPosition());


            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
                scoreA.setSelection(0);
            }


        });

        final Button addscore = (Button) findViewById(R.id.addScore);

        addscore.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView TeamAscore = (TextView) findViewById(R.id.TeamAscore);
                        TextView TeamBscore = (TextView) findViewById(R.id.TeamBscore);


                        int newA = Integer.parseInt(TeamAscore.getText().toString());
                        int addscoreA = scoreA.getSelectedItemPosition();
                        int kseresa = Integer.parseInt(kseresA.getText().toString());

                        int add1 = newA + addscoreA + (kseresa * 10);

                        int newB = Integer.parseInt(TeamBscore.getText().toString());
                        int addscoreB = scoreB.getSelectedItemPosition();
                        int kseresb = Integer.parseInt(kseresB.getText().toString());
                        int add2 = newB + addscoreB + (kseresb * 10);
                        int green=getResources().getColor(R.color.paleGreen);
                        if ((addscoreA!=0)||(addscoreB!=0)) {

                            if ((add1 != add2) && (add1 >= da && add2 >= da)) {
                                if (add1 > add2) {
                                    MediaPlayer mPlayer = MediaPlayer.create(GamepageActivity.this, R.raw.horn);
                                    mPlayer.start();
                                    TeamAscore.setText("WINNER\n" + add1);
                                    TeamAscore.setBackgroundColor(green);
                                    TeamBscore.setText("LOOSER\n" + add2);

                                } else {
                                    MediaPlayer mPlayer = MediaPlayer.create(GamepageActivity.this, R.raw.horn);
                                    mPlayer.start();
                                    TeamBscore.setText("WINNER\n" + add2);
                                    TeamBscore.setBackgroundColor(green);
                                    TeamAscore.setText("LOOSER\n" + add1);

                                }
                            } else if((add1 != add2) && (add1 >= da || add2 >= da)){
                                if (add1 > add2) {
                                    MediaPlayer mPlayer = MediaPlayer.create(GamepageActivity.this, R.raw.horn);
                                    mPlayer.start();
                                    TeamAscore.setText("WINNER\n"+add1);
                                    TeamAscore.setBackgroundColor(green);
                                    TeamBscore.setText("LOOSER\n" + add2);

                                } else {
                                    MediaPlayer mPlayer = MediaPlayer.create(GamepageActivity.this, R.raw.horn);
                                    mPlayer.start();
                                    TeamBscore.setText("WINNER\n" + add2);
                                    TeamBscore.setBackgroundColor(green);

                                    TeamAscore.setText("LOOSER\n" + add1);

                                }
                            }
                            else {
                                TeamAscore.setText("" + add1);
                                TeamBscore.setText("" + add2);

                            }
                        /*if (add1 < da) {
                            TeamAscore.setText("" + add1);
                        } else {
                            MediaPlayer mPlayer = MediaPlayer.create(GamepageActivity.this, R.raw.horn);
                            mPlayer.start();
                            TeamAscore.setText("WINNER");
                        }

                        if (add2 < da) {
                            TeamBscore.setText("" + add2);
                        } else {

                            MediaPlayer mPlayer = MediaPlayer.create(GamepageActivity.this, R.raw.horn);
                            mPlayer.start();
                            TeamBscore.setText("WINNER");
                        }*/
                            //TeamBscore.setText("" + add);
                            cutcards.setChecked(false);
                            check[0] = 0;
                            check2[0] = 0;
                            kseresA.setText(mTestArray[0]);
                            kseresB.setText(mTestArray[0]);
                            pressKseresA[0] = 0;
                            pressKseresB[0] = 0;
                            scoreA.setSelection(0);
                            scoreB.setSelection(0);
                        }
                        else{
                            AlertDialog.Builder alertDialogPoints = new AlertDialog.Builder(
                                    GamepageActivity.this);
                            // Setting Dialog Title
                            alertDialogPoints.setTitle("Επιλέξτε πόντους");
                            // Setting Dialog Message
                            alertDialogPoints.setMessage("Δεν έχετε επιλέξει πόντους!!");
                            // Setting Icon to Dialog
                            //alertDialog.setIcon(R.drawable.dialog_icon);
                            // Setting Positive "Yes" Button
                            alertDialogPoints.setPositiveButton("ΟΚ",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.cancel();
                                        }
                                    });

                            // Showing Alert Message
                            alertDialogPoints.show();

                        }




                    }
                }
        );

    }

    public void cutadapterchange1() {
        final Spinner scoreA = (Spinner) findViewById(R.id.TeamAScoreSelect);
        final Spinner scoreB = (Spinner) findViewById(R.id.TeamBScoreSelect);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.score_cut_arrays, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        scoreA.setAdapter(adapter);
        scoreB.setAdapter(adapter);
        scoreA.setSelection(0);
        scoreB.setSelection(0);
    }

    public void cutadapterchange2() {
        final Spinner scoreA = (Spinner) findViewById(R.id.TeamAScoreSelect);
        final Spinner scoreB = (Spinner) findViewById(R.id.TeamBScoreSelect);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.score_arrays, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        scoreA.setAdapter(adapter2);
        scoreB.setAdapter(adapter2);
        scoreA.setSelection(0);
        scoreB.setSelection(0);
    }

    /*public void enableKseres(ScoreTeamA,btn1,bt) {
        if (scoreA.getSelectedItem().toString() != "0" || scoreB.getSelectedItem().toString() != "0") {
            kseresAminus.setEnabled(false);
            kseresBminus.setEnabled(false);
            kseresAplus.setEnabled(false);
            kseresBplus.setEnabled(false);
            kseresA.setText("0");
            kseresB.setText("0");
        } else {
            kseresAminus.setEnabled(true);
            kseresBminus.setEnabled(true);
            kseresAplus.setEnabled(true);
            kseresBplus.setEnabled(true);

        }
    }*/

    @Override
    public void onBackPressed() {
        //Display alert message when back button has been pressed
        backButtonHandler();
        return;
    }

    public void backButtonHandler() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(
                GamepageActivity.this);
        // Setting Dialog Title
        alertDialog.setTitle("Έξοδος απο το παιχνίδι");
        // Setting Dialog Message
        alertDialog.setMessage("Είστε σίγουροι οτι θέλετε να σταματήσετε το παιχνίδι;");
        // Setting Icon to Dialog
        //alertDialog.setIcon(R.drawable.dialog_icon);
        // Setting Positive "Yes" Button
        alertDialog.setPositiveButton("YES",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();

                    }
                });
        // Setting Negative "NO" Button
        alertDialog.setNegativeButton("NO",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to invoke NO event
                        dialog.cancel();
                    }
                });
        // Showing Alert Message
        alertDialog.show();
    }


}



