package com.example.teletrader.ui.main;

import com.google.gson.JsonObject;
import java.lang.Math;

public class Symbol {
    String name;
    double high;
    double last;
    double low;
    double ask;
    double changePercent;
    double bid;


    public Symbol(JsonObject symbol, JsonObject quote) {
        this.name = symbol.get("-name").getAsString();

        if(quote.has("-high")) {
            this.setHigh(quote.get("-high").getAsDouble());
        }else {
            this.setHigh(-1);
        }

        if(quote.has("-last")) {
            this.setLast(quote.get("-last").getAsDouble());
        }else {
            this.setLast(-1);
        }

        if(quote.has("-low")) {
            this.setLow(quote.get("-low").getAsDouble());
        }else {
            this.setLow(-1);
        }

        if(quote.has("-ask")) {
            this.setAsk(quote.get("-ask").getAsDouble());
        }else {
            this.setAsk(-1);
        }

        if(quote.has("-changePercent")) {
            this.setChangePercent(quote.get("-changePercent").getAsDouble());
        }else {
            this.setChangePercent(-1);
        }

        if(quote.has("-bid")) {
            this.setBid(quote.get("-bid").getAsDouble());
        }else {
            this.setBid(-1);
        }
    }

    public Symbol(String name, double high, double last, double low, double ask, double changePercent, double bid) {
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

    public double getHigh() {
        return Math.floor(high * 100) / 100;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLast(){
        return Math.floor(last * 100) / 100;
    }

    public void setLast(double last) {
        this.last = last;
    }

    public double getLow() {
        return Math.floor(low * 100) / 100;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getAsk() {
        return Math.floor(ask * 100) / 100;
    }

    public void setAsk(double ask) {
        this.ask = ask;
    }

    public double getChangePercent() {
        return Math.floor(changePercent * 100) / 100;
    }

    public void setChangePercent(double changePercent) {
        this.changePercent = changePercent;
    }

    public double getBid() {
        return Math.floor(bid * 100) / 100;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }
}