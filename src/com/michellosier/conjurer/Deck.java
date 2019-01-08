package com.michellosier.conjurer;

import java.util.*;

public class Deck {
    private String name;
    private ArrayList<String> cards;
    private Map<String, Runnable> methodMap = new HashMap<String, Runnable>();

    public Deck(String name) {
        this.name = name;
        this.buildMethodMap();
    }

    private void buildMethodMap(){
        methodMap.put("name", () -> this.printName());
    }

    public void printCommandOptions(){
        System.out.println("Commands: \n");
        methodMap.forEach((k, v) -> {
            System.out.println(k +"\n");
        });
    }

    public void invokeMethodFromCommand(String cmd){
        if (methodMap.containsKey(cmd)) {
            methodMap.get(cmd).run();
        } else {
            System.out.printf("Command '%s' not recognized", cmd);
        }
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
