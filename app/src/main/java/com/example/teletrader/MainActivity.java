package com.example.teletrader;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.teletrader.ui.main.FetchDataTask;
import com.example.teletrader.ui.main.ListSymbols;
import com.example.teletrader.ui.main.Sorter;
import com.example.teletrader.ui.main.Symbol;

import java.util.ArrayList;
import java.util.List;
//import com.example.teletrader.ui.main.MainFragment;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    RadioGroup radioGroup;
    RadioGroup radioSort;
    RadioButton radioButtonD, radioButtonAsc, radioButtonDesc;
    RadioButton radioButtonP, radioButtonHL, radioButtonPicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        listView = (ListView) findViewById(R.id.listView);
        //listItem = Parser.fetchData();
        new FetchDataTask(getApplicationContext(), listView, 1).execute();

        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);
        radioButtonP=(RadioButton)findViewById(R.id.Percentage);
        radioButtonHL=(RadioButton)findViewById(R.id.High_Low);
        radioButtonPicture=(RadioButton)findViewById(R.id.News);

        radioButtonHL.setChecked(false);
        radioButtonP.setChecked(true);
        radioButtonPicture.setChecked(false);

        radioSort=(RadioGroup)findViewById(R.id.radioSort);
        radioButtonD=(RadioButton)findViewById(R.id.unsort);
        radioButtonAsc=(RadioButton)findViewById(R.id.normal_sort);
        radioButtonDesc=(RadioButton)findViewById(R.id.reverse_sort);

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

        radioSort.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.unsort)
                {
                    ListSymbols symbols = ListSymbols.getInstance();
                    symbols.clear();
                    new FetchDataTask(getApplicationContext(), listView, 1).execute();
                }
                else
                if (checkedId == R.id.normal_sort ) {
                    new Sorter(getApplicationContext(), listView, "normal_sort", 1).execute();;
                }
                else
                    new Sorter(getApplicationContext(), listView, "reverse_sort", 1).execute();
            }
        });

    }
}