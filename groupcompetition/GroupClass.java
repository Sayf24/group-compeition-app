package com.example.sayf.groupcompetition;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Sayf on 2/11/2017.
 */

public class GroupClass extends gameActivity {
    private TextView groupText;
    private TextView groupPoints;
    private Button addPoints;
    private int n;
    private int x;
    // constructor that holds the place where the name and points will appear as well as
    //the button respective to each group
    public GroupClass(TextView a, TextView b, Button c) {
        groupText = a;
        groupPoints = b;
        addPoints = c;
        sizeOfText();
        addPoints.setBackgroundColor(0xff0000ff);
    }

    public void setInvisible() {
        groupText.setVisibility(View.INVISIBLE);
        groupPoints.setVisibility(View.INVISIBLE);
        addPoints.setVisibility(View.INVISIBLE);
    }

    public void add100() {
        n += 100;
        groupPoints.setText("Points: " + n);
        addPermanentPoints();
    }

    public int getPoints() {
        return n;
    }

    public void sizeOfText() {
        groupText.setTextSize(25);
        groupPoints.setTextSize(20);
        groupText.setTextColor((0xffffffff));
        groupPoints.setTextColor((0xffffffff));
        addPoints.setTextColor((0xffffffff));
    }

    public String toString() {
        return "" + getPoints();
    }

    public void addPermanentPoints() {
        x += 100;
    }

    public int getPermanentPoints() {
        return x;
    }
}
