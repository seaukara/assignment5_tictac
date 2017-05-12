package com.sc.karamanseau.game;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    // define variables for the widgets
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;

    private Button newGame;
    private TextView gameConsole;

    private SharedPreferences savedValues;

    // define instance variables

    private String currentPlayer = "X";
    private String score[] = new String[10];
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);



        //get references to widgets
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);

        newGame = (Button) findViewById(R.id.newGame);
        gameConsole = (TextView) findViewById(R.id.gameConsole);
        gameConsole.setText("It's player "+currentPlayer+" turn!");

        //set listeners

        button1.setOnClickListener(clickListener);
        button2.setOnClickListener(clickListener);
        button3.setOnClickListener(clickListener);
        button4.setOnClickListener(clickListener);
        button5.setOnClickListener(clickListener);
        button6.setOnClickListener(clickListener);
        button7.setOnClickListener(clickListener);
        button8.setOnClickListener(clickListener);
        button9.setOnClickListener(clickListener);

        newGame.setOnClickListener(newGameListener);


        savedValues = getSharedPreferences("SavedValues", MODE_PRIVATE);

    }

        @Override
        public void onPause() {

            SharedPreferences.Editor editor = savedValues.edit();
            editor.putString("button1", score[1]);
            editor.putString("button2", score[2]);
            editor.putString("button3", score[3]);
            editor.putString("button4", score[4]);
            editor.putString("button5", score[5]);
            editor.putString("button6", score[6]);
            editor.putString("button7", score[7]);
            editor.putString("button8", score[8]);
            editor.putString("button9", score[9]);
            editor.commit();

            super.onPause();
        }

        @Override
        public void onResume() {
            super.onResume();
            System.out.println(savedValues.getString(score[1], ""));
            score[1] = savedValues.getString("button1", "");
            score[2] = savedValues.getString("button2", "");
            score[3] = savedValues.getString("button3", "");
            score[4] = savedValues.getString("button4", "");
            score[5] = savedValues.getString("button5", "");
            score[6] = savedValues.getString("button6", "");
            score[7] = savedValues.getString("button7", "");
            score[8] = savedValues.getString("button8", "");
            score[9] = savedValues.getString("button9", "");

            button1.setText(score[1]);
            button2.setText(score[2]);
            button3.setText(score[3]);
            button3.setText(score[4]);
            button3.setText(score[5]);
            button3.setText(score[6]);
            button3.setText(score[7]);
            button3.setText(score[8]);
            button3.setText(score[9]);
        }

        public void determineWinner() {

            if  (score[1]==""&&score[3]==""&&score[9]==""&&score[7]==""&&score[5]=="") {
                gameConsole.setText("It's "+currentPlayer+"'s turn!");
            } else if  (score[1]!=""&&score[1]==score[2]&&score[2]==score[3]) {
                gameConsole.setText("Winner: "+score[1]);
            } else if  (score[4]!=""&&score[4]==score[5]&&score[5]==score[6]) {
                gameConsole.setText("Winner: "+score[4]);
            } else if  (score[7]!=""&&score[7]==score[8]&&score[8]==score[9]) {
                gameConsole.setText("Winner: "+score[8]);
            } else if  (score[1]!=""&&score[1]==score[4]&&score[4]==score[7]) {
                gameConsole.setText("Winner: "+score[1]);
            } else if  (score[5]!=""&&score[5]==score[2]&&score[2]==score[8]) {
                gameConsole.setText("Winner: "+score[2]);
            } else if  (score[9]!=""&&score[9]==score[6]&&score[6]==score[3]) {
                gameConsole.setText("Winner: "+score[3]);
            } else if  (score[1]!=""&&score[1]==score[5]&&score[5]==score[9]) {
                gameConsole.setText("Winner: "+score[1]);
            } else if  (score[3]!=""&&score[5]==score[7]&&score[7]==score[3]) {
                gameConsole.setText("Winner: "+score[3]);
            } else {
                gameConsole.setText("It's "+currentPlayer+"'s turn!");
            }
        }

        private View.OnClickListener newGameListener = new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                score = new String[10];
                SharedPreferences.Editor editor = savedValues.edit();
                editor.clear();
                editor.commit();
                recreate();
//                button1.setText("");
//                button2.setText("");
//                button3.setText("");
//                button4.setText("");
//                button5.setText("");
//                button6.setText("");
//                button7.setText("");
//                button8.setText("");
//                button9.setText("");
//
//
//
//
//                currentPlayer = "X";
//                gameConsole.setText("It's "+currentPlayer+"'s turn!");


            };
        };


        private View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View b) {


                switch (b.getId()) {
                    case R.id.button1:
                        button1.setText(currentPlayer);
                        score[1] = (currentPlayer);
                        break;
                    case R.id.button2:
                        button2.setText(currentPlayer);
                        score[2] = (currentPlayer);
                        break;
                    case R.id.button3:
                        button3.setText(currentPlayer);
                        score[3] = (currentPlayer);
                        break;
                    case R.id.button4:
                        button4.setText(currentPlayer);
                        score[4] = (currentPlayer);
                        break;
                    case R.id.button5:
                        button5.setText(currentPlayer);
                        score[5] = (currentPlayer);
                        break;
                    case R.id.button6:
                        button6.setText(currentPlayer);
                        score[6] = (currentPlayer);
                        break;
                    case R.id.button7:
                        button7.setText(currentPlayer);
                        score[7] = (currentPlayer);
                        break;
                    case R.id.button8:
                        button8.setText(currentPlayer);
                        score[8] = (currentPlayer);
                        break;
                    case R.id.button9:
                        button9.setText(currentPlayer);
                        score[9] = (currentPlayer);
                        break;
                }

                if (currentPlayer == "O") {
                    currentPlayer = "X";
                } else if (currentPlayer == "X") {
                    currentPlayer = "O";
                }

                determineWinner();
            }
        };
}

