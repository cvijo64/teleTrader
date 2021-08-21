package com.example.teletrader.ui.main;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.github.underscore.lodash.U;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class FetchDataTask  extends AsyncTask<Void, Void, String> {

        private final Context context;
        private final ListView listView;

        public FetchDataTask(Context context, ListView listView) {
            this.context = context;
            this.listView = listView;
        }

        @Override
        protected String doInBackground(Void... params) {
            String str = null;
            try {
                URL url = new URL("https://www.teletrader.rs/downloads/tt_symbol_list.xml");
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestProperty("Authorization", "Basic YW5kcm9pZF90dDpTazNNIUBwOWU=");
                con.setRequestMethod("GET");
                int status = con.getResponseCode();
                System.out.println(status);

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer content = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();
                con.disconnect();
                str = content.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return str;

        }



        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            String response = result;
            List<Symbol> symbols = null;
            JsonObject json;
            try {
                String jsonString = U.xmlToJson(response);
                json = new JsonParser().parse(jsonString).getAsJsonObject();
// JSONObject json = XML.toJSONObject(content.toString());


                JsonArray symbolList = json.getAsJsonObject("Result").getAsJsonObject("SymbolList").getAsJsonArray("Symbol");
                symbols = new ArrayList<Symbol>();
                for(int i = 0; i < symbolList.size(); i++) {
                    JsonObject symbolObj = (JsonObject) symbolList.get(i);
                    JsonObject quote =  symbolObj.getAsJsonObject("Quote");
                    Symbol symbol = new Symbol(symbolObj, quote);
                    symbols.add(symbol);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            final CustomAdapter adapter = new CustomAdapter(symbols, this.context);
            listView.setAdapter(adapter);
        }
    }

