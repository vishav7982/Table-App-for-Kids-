package com.example.tableappforkids;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    public final void generateTable(int table_num)
    {
        ArrayList<String> content = new ArrayList<String>();
        for(int i=1;i<=22;i++)
        {
            int num = table_num*i;
            String s = Integer.toString(table_num);
            s = s + " x " + Integer.toString(i) + " = ";
            s +=Integer.toString(num);
            content.add(s);
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,content);
        listView.setAdapter(arrayAdapter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final SeekBar seekBar   = findViewById(R.id.seekBar2);
        listView = findViewById(R.id.myList);

        int start=1;
        int max =40;
        seekBar.setMax(max);
        generateTable(start);
        seekBar.setProgress(start);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int minimum = 1;
                int table_num;
                if(progress <minimum)
                {
                    table_num=minimum;
                    seekBar.setProgress(minimum);
                }
                else {
                    table_num = progress;
                }
                generateTable(table_num);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}