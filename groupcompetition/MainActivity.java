package com.example.sayf.groupcompetition;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import static com.example.sayf.groupcompetition.R.array.group_size;

public class MainActivity extends AppCompatActivity {
    public int totalGroups;
    public String text;
    Spinner s;
    @Override
    // creates view on phone setting it to the file that contains the layout xml code
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // opens the group screen on the button click
    public void begin(View v){
        Intent inn1=getIntent();
        inn1=new Intent(MainActivity.this,gameActivity.class);
        inn1.putExtra("groups", totalGroups);
        startActivity(inn1);
    }
    // unused for now, might implement depending on database turnour
    public int getTotalGroups(){
        System.out.println(totalGroups);
        return totalGroups;
    }
    // gets the value from the edit text box and parses int value fromn it
    public void enter(View v){
        EditText editText = (EditText) findViewById(R.id.editText);
        text = editText.getText().toString();
        totalGroups = Integer.parseInt(text);
        System.out.println(totalGroups);
    }

}
