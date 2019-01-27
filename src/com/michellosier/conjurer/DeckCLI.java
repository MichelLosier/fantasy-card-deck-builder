package com.michellosier.conjurer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Consumer;

public class DeckCLI {
    private Deck deck;
    private ArrayList<Option> options;

    public DeckCLI(Deck deck){
        this.deck = deck;
    }

    public void handleCommand(CLICommand command){

    }

    private void buildOptions(){
        options.add(new Option("get", "name", (args) -> this.getName(args)));
        options.add(new Option("set", "name", (args) -> this.setName(args)));
    }

    private void getName(HashMap<String, String> args){
        String name = this.deck.getName();
        System.out.println(name);
    }

    private void setName(HashMap<String, String> args){

        this.deck.setName(name);
    }


}
