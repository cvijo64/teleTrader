package com.example.teletrader.ui.main;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;

import java.util.Collections;

public class Sorter extends AsyncTask<Void, Void, ListSymbols>{

        private final Context context;
        private final ListView listView;
        private final String sort;
        private int adapterNum;

        public Sorter(Context context, ListView listView, String sort, int aNum) {
            this.context = context;
            this.listView = listView;
            this.sort = sort;
            this.adapterNum = aNum;
        }

        @Override
        protected ListSymbols doInBackground(Void... params) {

        ListSymbols symbols = ListSymbols.getInstance();

        if(sort.equals("normal_sort"))
            Collections.sort(symbols);
        else
            Collections.sort(symbols, Collections.reverseOrder());
        return symbols;
    }



        @Override
        protected void onPostExecute(ListSymbols result) {
        super.onPostExecute(result);

       if(adapterNum ==1) {
           final CustomAdapter adapter = new CustomAdapter(result, this.context);
           listView.setAdapter(adapter);
       }
        else{
                final CustomAdapter2 adapter = new CustomAdapter2(result, this.context);
                listView.setAdapter(adapter);
            }
    }
}
