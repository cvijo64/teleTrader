package com.example.teletrader;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.teletrader.api.Parser;
import com.example.teletrader.ui.main.CustomAdapter;
import com.example.teletrader.ui.main.Symbol;

import java.util.ArrayList;
import java.util.List;
//import com.example.teletrader.ui.main.MainFragment;

public class MainActivity extends AppCompatActivity {

/*    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }
    }*/

    ListView listView;
    TextView textView;
    List<Symbol> listItem = new ArrayList<Symbol>();
            //new Symbol("Huawei", 1, 2, 3, 4, 5, 6), new Symbol("Samsung", 2, 4, 6, 7, 8, 6), new Symbol("dsjkfnghs", 3, 4, 4, 4, 5, 6) );
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        listView=(ListView)findViewById(R.id.listView);
        textView=(TextView)findViewById(R.id.textView);
        listItem = Parser.fetchData();
        final CustomAdapter adapter = new CustomAdapter(listItem, getApplicationContext());
        listView.setAdapter(adapter);

/*        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // TODO Auto-generated method stub
                //String value=adapter.getItem(position);SHORT).show();

            }
        });*/
    }
}