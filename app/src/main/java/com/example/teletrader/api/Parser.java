/*
package com.example.teletrader.api;

import com.example.teletrader.ui.main.Symbol;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    public static List<Symbol> fetchData()  {
        List<Symbol> symbols = null;
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
            JSONObject json = XML.toJSONObject(content.toString());
            JSONArray symbolList = json.getJSONObject("Result").getJSONObject("SymbolList").getJSONArray("Symbol");
            symbols = new ArrayList<>();
            for(int i = 0; i < symbolList.length(); i++) {
                JSONObject symbolObj = (JSONObject) symbolList.get(i);
                JSONObject quote =  symbolObj.getJSONObject("Quote");
                Symbol symbol = new Symbol(symbolObj, quote);
                symbols.add(symbol);
            }

            System.out.println(symbols);
        }catch(IOException | JSONException e){
            System.out.println("ERROR");
        }
        return symbols;
    }
}
*/
