package com.example.teletrader.ui.main;

import org.json.JSONException;
import org.json.JSONObject;

public class Symbol {
    String name;
    int high;
    int last;
    int low;
    int ask;
    int changePercent;
    int bid;

    public Symbol(JSONObject symbol, JSONObject quote) throws JSONException {
        this.name = symbol.getString("name");

        if (symbol.has("high")) {
            this.setHigh(quote.getInt("high"));
        } else {
            this.setHigh(-1);
        }

        if (symbol.has("last")) {
            this.setHigh(quote.getInt("last"));
        } else {
            this.setHigh(-1);
        }

        if (symbol.has("low")) {
            this.setHigh(quote.getInt("low"));
        } else {
            this.setHigh(-1);
        }

        if (symbol.has("ask")) {
            this.setHigh(quote.getInt("ask"));
        } else {
            this.setHigh(-1);
        }

        if (symbol.has("changePercent")) {
            this.setHigh(quote.getInt("changePercent"));
        } else {
            this.setHigh(-1);
        }

        if (symbol.has("bid")) {
            this.setHigh(quote.getInt("bid"));
        } else {
            this.setHigh(-1);
        }
    }

    public Symbol(String name, int high, int last, int low, int ask, int changePercent, int bid) {
        this.name = name;
        this.high = high;
        this.last = last;
        this.low = low;
        this.ask = ask;
        this.changePercent = changePercent;
        this.bid = bid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }

    public int getLow() {
        return low;
    }

    public void setLow(int low) {
        this.low = low;
    }

    public int getAsk() {
        return ask;
    }

    public void setAsk(int ask) {
        this.ask = ask;
    }

    public int getChangePercent() {
        return changePercent;
    }

    public void setChangePercent(int changePercent) {
        this.changePercent = changePercent;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }
}