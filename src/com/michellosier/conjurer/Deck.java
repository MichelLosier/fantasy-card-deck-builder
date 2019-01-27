package com.michellosier.conjurer;

import java.util.*;

public class Deck {
    private String name;
    private ArrayList<String> cards;

    public Deck(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
