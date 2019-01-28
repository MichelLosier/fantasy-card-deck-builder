package com.michellosier.conjurer;

import com.michellosier.clitools.CLIArgument;
import com.michellosier.clitools.Option;
import com.michellosier.clitools.EntityCLI;

import java.util.HashMap;


public class DeckCLI extends EntityCLI {
    private Deck deck;

    public DeckCLI(Deck deck){
        super("deck", "Interface for managing a deck of cards");
        this.deck = deck;
    }

    @Override
    public void build(){
        //initialize options
        Option getName = new Option("get", "name", "get deck name", this::getName);
        super.getOptions().add(getName);

        Option setName = new Option("set", "name", "set deck name", this::setName);
        setName.addArgument(new CLIArgument("n", "name","name value",true ));
        super.getOptions().add(setName);
    }

    private void getName(HashMap<String, String> args){
        String name = this.deck.getName();
        System.out.println(name);
    }

    private void setName(HashMap<String, String> args){

        this.deck.setName(args.get("name"));
        System.out.printf("Deck name set to: %s\n", this.deck.getName());
    }

}
