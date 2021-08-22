package com.example.teletrader;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.teletrader.ui.main.FetchDataTask;
import com.example.teletrader.ui.main.Symbol;

import java.util.ArrayList;
import java.util.List;
//import com.example.teletrader.ui.main.MainFragment;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        listView = (ListView) findViewById(R.id.listView);
        //listItem = Parser.fetchData();
        new FetchDataTask(getApplicationContext(), listView).execute();

        /*  listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // TODO Auto-generated method stub
                //String value=adapter.getItem(position);SHORT).show();

            }
        });*/


    }

/*    public void addListenerOnRadioGroup() {

        radioSexGroup = (RadioGroup) findViewById(R.id.radioSex);
        btnDisplay = (Button) findViewById(R.id.btnDisplay);

        btnDisplay.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                // get selected radio button from radioGroup
                int selectedId = radioSexGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioSexButton = (RadioButton) findViewById(selectedId);

                Toast.makeText(MyAndroidAppActivity.this,
                        radioSexButton.getText(), Toast.LENGTH_SHORT).show();

            }

        });
    }*/
}