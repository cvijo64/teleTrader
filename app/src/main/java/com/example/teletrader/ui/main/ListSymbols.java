package com.example.teletrader.ui.main;

import java.util.ArrayList;

public class ListSymbols<Symbols> extends ArrayList{

    private static ListSymbols<Symbol> symbols;

    private ListSymbols(){}

    public static ListSymbols<Symbol> getInstance() {
            if (symbols==null)
                symbols = new ListSymbols<Symbol>();
            return symbols;
        }
}
