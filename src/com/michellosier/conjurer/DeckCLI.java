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
        try{
            command.execute(this.options);
        } catch(Exception e){
            e.printStackTrace();
        }

    }

    public void build(){

        //initialize options
        Option getName = new Option("get", "name", (args) -> this.getName(args));
        options.add(getName);

        Option setName = new Option("set", "name", (args) -> this.setName(args));
        setName.addArgument(new CLIArgument("n", "name",true ));
        options.add(setName);
    }

    private void getName(HashMap<String, String> args){
        String name = this.deck.getName();
        System.out.println(name);
    }

    private void setName(HashMap<String, String> args){
        this.deck.setName(args.get("name"));
    }


}
