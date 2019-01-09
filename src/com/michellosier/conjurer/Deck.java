package com.michellosier.conjurer;

import java.util.*;

public class Deck {
    private String name;
    private ArrayList<String> cards;
    private ArrayList<Option> CLInterface = new ArrayList<Option>();
    private CommandParser commandParser;

    public Deck(String name) {
        this.name = name;

        this.buildCLInterface();
        this.commandParser = new CommandParser(this.CLInterface);
    }

    private void buildCLInterface(){
       CLInterface.add(new Option("name", "Get the name of the deck", () -> this.printName()));
    }

    public void performAction(String command){
        commandParser.invokeMethodFromCommand(command);
    }

    public void printCLInterface(){
        commandParser.printCommandOptions();
    }

    public String getName() {
        return name;
    }

    public void printName(){
        System.out.printf("Current Card deck name: '%s'", this.name);
    }

    public void setName(String name) {
        this.name = name;
    }
}
