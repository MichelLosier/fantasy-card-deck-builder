package com.michellosier.clitools;

import java.util.ArrayList;

public class EntityCLI {
    private String namespace;
    private String description;
    private ArrayList<Option> options;

    public EntityCLI(String namespace, String description){
        this.namespace = namespace;
        this.description = description;
        this.options = new ArrayList<Option>();
    }

    public void handleCommand(CLICommand command){
        if(command.getAction().equals("usage")){
            this.printOptions();
            return;
        }
        try{
            command.execute(this.options);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    //subclasses should always override and implement
    public void build(){ }

    public String getNamespace(){return this.namespace;}
    public ArrayList<Option> getOptions(){
        return this.options;
    }
    public String getDescription(){return this.description;}

    public void printOptions(){
        for (Option option:options){
            System.out.printf("'%s %s' : '%s'\n", option.getAction(), option.getTarget(), option.getDescription());

            if(option.getArguments().size() > 0){
                for(CLIArgument argument: option.getArguments()){
                    System.out.printf("%-10s -%s, -%s, expects: %s\n","", argument.getShortArg(), argument.getLongArg(), argument.getDescription());
                }
            }
        }
    }
}
