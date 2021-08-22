package com.example.teletrader;

import android.os.Bundle;

import com.example.teletrader.ui.main.FetchDataTask;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.ListView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;


public class HihgLowActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        listView = (ListView) findViewById(R.id.listView);
        //listItem = Parser.fetchData();
        new FetchDataTask(getApplicationContext(), listView).execute();


    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_hihg_low);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}