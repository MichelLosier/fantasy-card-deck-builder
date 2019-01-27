package com.michellosier.conjurer;


import java.util.HashMap;

import java.util.function.Consumer;


public class Option {
    private String action;
    private String target;
    private String description;
    private HashMap<String, String> arguments;
    private Consumer<HashMap<String, String>> callback;

    public Option(String action, String description, Consumer<HashMap<String, String>> callback) {
        this.action = action;
        this.target = target;
        this.description = description;
        this.callback = callback;
    }

    public void runMethod(String arguments){
        //this.method.run();
    }

    public void runMethod(){
        this.runMethod("");
    }


    public String getAction() {
        return action;
    }

    public String getDescription() {
        return description;
    }

}
