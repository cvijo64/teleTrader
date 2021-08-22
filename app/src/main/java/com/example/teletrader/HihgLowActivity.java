package com.example.teletrader;

import android.content.Intent;
import android.os.Bundle;

import com.example.teletrader.ui.main.CustomAdapter2;
import com.example.teletrader.ui.main.ListSymbols;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class HihgLowActivity extends AppCompatActivity {

    RadioGroup radioGroup;
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
