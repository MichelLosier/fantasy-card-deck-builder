package com.michellosier.conjurer;

public class Option {
    private String action;
    private String description;
    private Runnable method;

    public Option(String action, String description, Runnable method) {
        this.action = action;
        this.description = description;
        this.method = method;
    }

    public void runMethod(){
        this.method.run();
    }

    public String getAction() {
        return action;
    }

    public String getDescription() {
        return description;
    }

}
