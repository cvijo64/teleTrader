package com.example.teletrader;

import android.content.Intent;
import android.os.Bundle;

import com.example.teletrader.ui.main.CustomAdapter;
import com.example.teletrader.ui.main.CustomAdapter2;
import com.example.teletrader.ui.main.FetchDataTask;
import com.example.teletrader.ui.main.ListSymbols;
import com.example.teletrader.ui.main.Sorter;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class HihgLowActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioGroup radioSort;
    RadioButton radioButtonD, radioButtonAsc, radioButtonDesc;
    RadioButton radioButtonP, radioButtonHL, radioButtonPicture;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        listView = (ListView) findViewById(R.id.listView);

        ListSymbols symbols = ListSymbols.getInstance();
        final CustomAdapter2 adapter = new CustomAdapter2(symbols, getApplicationContext());
        listView.setAdapter(adapter);

        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);
        radioButtonP=(RadioButton)findViewById(R.id.Percentage);
        radioButtonHL=(RadioButton)findViewById(R.id.High_Low);
        radioButtonPicture=(RadioButton)findViewById(R.id.News);

        radioButtonHL.setChecked(true);
        radioButtonP.setChecked(false);
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
                    final CustomAdapter adapter = new CustomAdapter(symbols, getApplicationContext());
                    listView.setAdapter(adapter);
                    //symbols.clear();
                    //Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    //startActivity(intent);
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
                    symbols.clear();
                    new FetchDataTask(getApplicationContext(), listView, 2).execute();
                }
                else
                if (checkedId == R.id.normal_sort ) {
                    new Sorter(getApplicationContext(), listView, "normal_sort", 2).execute();;
                }
                else
                    new Sorter(getApplicationContext(), listView, "reverse_sort", 2).execute();
            }
        });
    }

}
