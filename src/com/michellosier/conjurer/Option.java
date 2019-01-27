package com.michellosier.conjurer;


import java.util.HashMap;
import java.util.ArrayList;
import java.util.function.Consumer;


public class Option {
    private String action;
    private String target;
    private String description;
    private ArrayList<CLIArgument> arguments;
    private Consumer<HashMap<String, String>> callback;

    public Option(String action, String target, String description, Consumer<HashMap<String, String>> callback) {
        this.action = action;
        this.target = target;
        this.description = description;
        this.callback = callback;
        this.arguments = new ArrayList<CLIArgument>();
    }

    public Consumer getCallback(){
        return callback;
    }

    public String getAction() {
        return action;
    }

    public String getTarget() {
        return target;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<CLIArgument> getArguments() {
        return arguments;
    }

    public void addArgument(CLIArgument argument){
        arguments.add(argument);
    }



}
