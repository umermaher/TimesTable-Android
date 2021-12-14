package com.example.timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView table;
    SeekBar seekBar;
    String multiplication[]=new String[10];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        table=findViewById(R.id.table);
        seekBar =findViewById(R.id.seekbar);
        seekBar.setMax(20);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Toast.makeText(MainActivity.this, "progress "+i, Toast.LENGTH_SHORT).show();
                //i --> progress of seekbar
                if(!(i==0))
                    populate(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void populate(int num){
        for(int i = 1; i<=10; i++){
            multiplication[i-1]=num+" X "+i+" = "+(num*i);
        }
        ArrayAdapter<String> adp=new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,multiplication);
        table.setAdapter(adp);
    }
}