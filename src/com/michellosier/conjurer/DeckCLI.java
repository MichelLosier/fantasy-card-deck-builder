package com.michellosier.conjurer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Consumer;
import java.lang.reflect.Method;


public class DeckCLI {
    private Deck deck;
    private ArrayList<Option> options = new ArrayList();

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
        Option getName = new Option("get", "name", "get deck name", this::getName);
        options.add(getName);

        Option setName = new Option("set", "name", "set deck name", this::setName);
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

    public void printOptions(){

        //System.out.printf("%-10s -%s, -%s, expects: %s\n","", cliParamAnnotation.longName(), cliParamAnnotation.shortName(), cliParamAnnotation.value());

    }


}
