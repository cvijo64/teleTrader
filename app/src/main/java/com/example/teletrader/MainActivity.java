package com.example.teletrader;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.teletrader.ui.main.FetchDataTask;
import com.example.teletrader.ui.main.Symbol;

import java.util.ArrayList;
import java.util.List;
//import com.example.teletrader.ui.main.MainFragment;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    RadioGroup radioGroup;
    RadioButton radioButtonP, radioButtonHL, radioButtonPicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        listView = (ListView) findViewById(R.id.listView);
        //listItem = Parser.fetchData();
        new FetchDataTask(getApplicationContext(), listView).execute();

        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);
        radioButtonP=(RadioButton)findViewById(R.id.Percentage);
        radioButtonHL=(RadioButton)findViewById(R.id.High_Low);
        radioButtonPicture=(RadioButton)findViewById(R.id.News);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.Percentage)
                {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);

                }
                else
                if (checkedId == R.id.High_Low ) {
                    Intent intent1 = new Intent(getApplicationContext(), HihgLowActivity.class);
                    startActivity(intent1);

                }
            }
        });


    }
}