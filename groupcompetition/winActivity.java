package com.example.sayf.groupcompetition;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static android.R.color.white;

/**
 * Created by Sayf on 2/11/2017.
 */

public class winActivity extends gameActivity {
    MyDBHandler dbhandler = new MyDBHandler(this,null,null,12);
    protected void onCreate(Bundle savedInstanceState) {
        Bundle bundle = getIntent().getExtras();
        whoWon = bundle.getInt("whoWon");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.win_screen);
        setWinner();
    }
    public void setWinner(){
        setTotal();
        TextView winner = (TextView) findViewById(R.id.winText);
        System.out.println("winner: " + whoWon);
        //winner.setText("The winner is group "+ (whoWon+1));
        winner.setText(groupOneObj.toString());
    }
    public void setTotal(){
        update();
        String dString = dbhandler.databaseToString();
        TextView groupOne = (TextView) findViewById(R.id.groupOneTotal);
        groupOne.setText(dString);
    }
    public void playAgain(View v){
        Intent inn1=getIntent();
        inn1=new Intent(winActivity.this,gameActivity.class);
        inn1.putExtra("groups", totalGroups);
        startActivity(inn1);
    }

}
