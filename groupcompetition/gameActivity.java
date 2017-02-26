package com.example.sayf.groupcompetition;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.app.ActionBar.LayoutParams;

import java.util.Arrays;

import static android.R.attr.max;
import static android.R.id.list;
import static android.R.interpolator.linear;
import static android.graphics.Color.BLACK;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;
import static android.os.Build.VERSION_CODES.M;
import static android.os.Build.VERSION_CODES.N;
import static com.example.sayf.groupcompetition.R.id.button;
import static com.example.sayf.groupcompetition.R.id.example;
import static com.example.sayf.groupcompetition.R.id.groupEightPoints;
import static com.example.sayf.groupcompetition.R.id.groupFivePoints;
import static com.example.sayf.groupcompetition.R.id.groupFourPoints;
import static com.example.sayf.groupcompetition.R.id.groupNinePoints;
import static com.example.sayf.groupcompetition.R.id.groupOnePoints;
import static com.example.sayf.groupcompetition.R.id.groupSevenPoints;
import static com.example.sayf.groupcompetition.R.id.groupSixPoints;
import static com.example.sayf.groupcompetition.R.id.groupTenPoints;
import static com.example.sayf.groupcompetition.R.id.groupThreePoints;
import static com.example.sayf.groupcompetition.R.id.groupTwoPoints;
import static com.example.sayf.groupcompetition.R.id.list_item;
import static com.example.sayf.groupcompetition.R.id.wrap_content;

/**
 * Created by Sayf on 2/9/2017.
 */

public class gameActivity extends MainActivity {
    //@Override
   //creates global variables that can be used in this actvity as well as in the win
    //activity, TODO:Create an array list out of the object to make shit alot easier
    MyDBHandler dbhandler = new MyDBHandler(this,null,null,12);
    int groupTotal;
    GroupClass groupTenObj;
    GroupClass groupNineObj;
    GroupClass groupEightObj;
    GroupClass groupSevenObj;
    GroupClass groupSixObj;
    GroupClass groupFiveObj;
    GroupClass groupFourObj;
    GroupClass groupThreeObj;
    GroupClass groupTwoObj;
    GroupClass groupOneObj;
    int[] points = new int[10];
    protected void onCreate(Bundle savedInstanceState) {
        Bundle bundle = getIntent().getExtras();
        groupTotal = bundle.getInt("groups");
        //System.out.println(groupTotal);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);
        setupLayout();
    }
    // worse part of the fucking code, its absolutely disgusting but it fucking works jenkins
    //TODO:When array list is impleneted, rewrite for easier understanding and less disgusting
    public void setupLayout() {
        TextView groupTenPoints = (TextView) findViewById(R.id.groupTenPoints);
        TextView groupTen = (TextView) findViewById(R.id.textView11);
        Button buttonTen = (Button) findViewById(R.id.buttonGroup10);
        groupTenObj = new GroupClass(groupTen,groupTenPoints,buttonTen);

        TextView groupNinePoint = (TextView) findViewById(groupNinePoints);
        TextView groupNine = (TextView) findViewById(R.id.textView10);
        Button buttonNine = (Button) findViewById(R.id.buttonGroup9);
        groupNineObj = new GroupClass(groupNine,groupNinePoint,buttonNine);

        TextView group8Points = (TextView) findViewById(groupEightPoints);
        TextView groupEight = (TextView) findViewById(R.id.textView9);
        Button buttonEight = (Button) findViewById(R.id.buttonGroup8);
        groupEightObj = new GroupClass(groupEight,group8Points,buttonEight);

        TextView group7Points = (TextView) findViewById(groupSevenPoints);
        TextView groupSeven = (TextView) findViewById(R.id.textView8);
        Button buttonSeven = (Button) findViewById(R.id.buttonGroup7);
        groupSevenObj = new GroupClass(groupSeven,group7Points,buttonSeven);

        TextView group6Points = (TextView) findViewById(groupSixPoints);
        TextView groupSix = (TextView) findViewById(R.id.textView7);
        Button buttonSix = (Button) findViewById(R.id.buttonGroup6);
        groupSixObj = new GroupClass(groupSix,group6Points,buttonSix);

        TextView group5Points = (TextView) findViewById(groupFivePoints);
        TextView groupFive = (TextView) findViewById(R.id.textView6);
        Button buttonFive = (Button) findViewById(R.id.buttonGroup5);
        groupFiveObj = new GroupClass(groupFive,group5Points,buttonFive);

        TextView group4Points = (TextView) findViewById(groupFourPoints);
        TextView groupFour = (TextView) findViewById(R.id.textView5);
        Button button4 = (Button) findViewById(R.id.buttonGroup4);
        groupFourObj = new GroupClass(groupFour,group4Points,button4);

        TextView group3Points = (TextView) findViewById(groupThreePoints);
        TextView groupThree = (TextView) findViewById(R.id.textView4);
        Button buttonThree = (Button) findViewById(R.id.buttonGroup3);
        groupThreeObj = new GroupClass(groupThree,group3Points,buttonThree);

        TextView group2Points = (TextView) findViewById(groupTwoPoints);
        TextView groupTwo = (TextView) findViewById(R.id.textView3);
        Button buttonTwo = (Button) findViewById(R.id.buttonGroup2);
        groupTwoObj = new GroupClass(groupTwo,group2Points,buttonTwo);

        TextView group1Points = (TextView) findViewById(groupOnePoints);
        TextView groupOne = (TextView) findViewById(R.id.textView2);
        Button buttonOne = (Button) findViewById(R.id.buttonGroup1);
        groupOneObj = new GroupClass(groupOne,group1Points,buttonOne);

        if(groupTotal == 9) {
            groupTenObj.setInvisible();
        }
        else if(groupTotal==8) {
           groupTenObj.setInvisible();
            groupNineObj.setInvisible();
        }
        else if(groupTotal == 7){
            groupTenObj.setInvisible();
            groupNineObj.setInvisible();
            groupEightObj.setInvisible();
        }
        else if(groupTotal == 6){
            groupTenObj.setInvisible();
            groupNineObj.setInvisible();
            groupEightObj.setInvisible();
            groupSevenObj.setInvisible();
        }
        else if(groupTotal == 5){
            groupTenObj.setInvisible();
            groupNineObj.setInvisible();
            groupEightObj.setInvisible();
            groupSevenObj.setInvisible();
            groupSixObj.setInvisible();
        }
        else if(groupTotal == 4){
            groupTenObj.setInvisible();
            groupNineObj.setInvisible();
            groupEightObj.setInvisible();
            groupSevenObj.setInvisible();
            groupSixObj.setInvisible();
            groupFiveObj.setInvisible();
        }
        else if(groupTotal == 3){
            groupTenObj.setInvisible();
            groupNineObj.setInvisible();
            groupEightObj.setInvisible();
            groupSevenObj.setInvisible();
            groupSixObj.setInvisible();
            groupFiveObj.setInvisible();
            groupFourObj.setInvisible();
        }
        else if(groupTotal == 2){
            groupTenObj.setInvisible();
            groupNineObj.setInvisible();
            groupEightObj.setInvisible();
            groupSevenObj.setInvisible();
            groupSixObj.setInvisible();
            groupFiveObj.setInvisible();
            groupFourObj.setInvisible();
            groupThreeObj.setInvisible();
        }
    }
    // next methods are linked to the button to each respective group, i really need that array list
    //TODO:Make the permanent points actually fucking work this time
    public void addGroup1Points(View V){
        groupOneObj.add100();
        //groupOneObj.addPermanentPoints();
    }
    public void addGroup2Points(View V){
        groupTwoObj.add100();
        //groupTwoObj.addPermanentPoints();
    }
    public void addGroup3Points(View V){
        groupThreeObj.add100();
        //groupThreeObj.addPermanentPoints();
    }
    public void addGroup4Points(View V){
        groupFourObj.add100();
        //groupFourObj.addPermanentPoints();
    }
    public void addGroup5Points(View V){
        groupFiveObj.add100();
        //groupFiveObj.addPermanentPoints();
    }
    public void addGroup6Points(View V){
        groupSixObj.add100();
        //groupSixObj.addPermanentPoints();
    }
    public void addGroup7Points(View V){
        groupSevenObj.add100();
        //groupSevenObj.addPermanentPoints();
    }
    public void addGroup8Points(View V){
        groupEightObj.add100();
        //groupEightObj.addPermanentPoints();
    }
    public void addGroup9Points(View V){
        groupNineObj.add100();
        //groupNineObj.addPermanentPoints();
    }
    public void addGroup10Points(View V){
        groupTenObj.add100();
        //groupTenObj.addPermanentPoints();
    }
    // this method gets the winner and returns who wins
    public int getWinner(int[] a){
        a[0] = groupOneObj.getPoints();
        System.out.println("Group1: " + a[0]);
        a[1] = groupTwoObj.getPoints();
        System.out.println("Group2: " + a[1]);
        a[2] = groupThreeObj.getPoints();
        a[3] = groupFourObj.getPoints();
        a[4] = groupFiveObj.getPoints();
        a[5] = groupSixObj.getPoints();
        a[6] = groupSevenObj.getPoints();
        a[7] = groupEightObj.getPoints();
        a[8] = groupNineObj.getPoints();
        a[9] = groupTenObj.getPoints();
        int max = a[0];
        int winner;
        int temp = 0;
        for(int n=0;n<=a.length-1;n++){
            System.out.println("Loop:" + n);
            System.out.println(temp);
            System.out.println(max);
            if(a[n]>max){
                temp = n;
                max=a[n];
            }
            if(n==groupTotal){
                System.out.println("TEEMPOPPP:" + temp);
                return temp;
            }
        }
        winner = temp;
        return winner;
    }
    public int whoWon;
    public void endRound(View v){
        saveInfo(v);
        whoWon=getWinner(points);
        Intent inn1=getIntent();
        inn1=new Intent(gameActivity.this,winActivity.class);
        inn1.putExtra("groups", totalGroups);
        inn1.putExtra("whoWon", whoWon);
        startActivity(inn1);

    }
    //saves the info to the database to handle, TODO:find a way to update info
    public void saveInfo(View view){
        dbhandler.addGroup(groupOneObj);
        dbhandler.addGroup(groupTwoObj);
        dbhandler.addGroup(groupThreeObj);
        dbhandler.addGroup(groupFourObj);
        dbhandler.addGroup(groupFiveObj);
        dbhandler.addGroup(groupSixObj);
        dbhandler.addGroup(groupSevenObj);
        dbhandler.addGroup(groupEightObj);
        dbhandler.addGroup(groupNineObj);
        dbhandler.addGroup(groupTenObj);
    }
    // method that doesnt work because i have no idea what im doing in regards to SQL
    public void update(){
        dbhandler.updateInfo(groupOneObj);
        dbhandler.updateInfo(groupTwoObj);
        dbhandler.updateInfo(groupThreeObj);
        dbhandler.updateInfo(groupFourObj);
        dbhandler.updateInfo(groupFiveObj);
        dbhandler.updateInfo(groupSixObj);
        dbhandler.updateInfo(groupSevenObj);
        dbhandler.updateInfo(groupEightObj);
        dbhandler.updateInfo(groupNineObj);
        dbhandler.updateInfo(groupTenObj);
    }
}