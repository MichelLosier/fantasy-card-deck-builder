package com.michellosier.conjurer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CLICommand{
    private String commandString;
    private String entity;
    private String action;
    private String target;
    private HashMap<String, String> arguments = new HashMap<String, String>();

    public CLICommand(String commandString) throws Exception {
        this.commandString = commandString;
        parseCommandString();
    }

    public String getEntity() {
        return entity;
    }

    private void setEntity(String entity) {
        this.entity = entity;
    }

    public String getAction(){
        return this.action;
    }

    private void setAction(String action){
        this.action = action;
    }

    public String getTarget(){
        return this.target;
    }

    private void setTarget(String target){
        this.target = target;
    }

    public HashMap<String,String> getArguments(){
        return this.arguments;
    }

    private void addArgument(String key, String value){
        this.arguments.put(key, value);
    }

    private void parseCommandString() throws Exception{
        ArrayList<String> cmdArray = new ArrayList(Arrays.asList(this.commandString.split("\\s+"))); //split by whitespace
        int cmdSize = cmdArray.size();


        if(cmdSize >= 3){
            setEntity(cmdArray.get(0));
            setAction(cmdArray.get(1));
            setTarget(cmdArray.get(2));

            if(cmdSize > 3){
                for (int i = 3; i < cmdSize;){
                    String arg = cmdArray.get(i);

                    if(arg.charAt(0) == '-'){
                        String key = arg.substring(1);
                        String nextArg = cmdArray.get(i + 1);
                        if(nextArg.charAt(0) != '-'){
                            String value = nextArg;
                            addArgument(key, value);
                            i+=2;
                        } else {
                            String value = "";
                            addArgument(key, value);
                            i++;
                        }
                    }
                }
            }
        } else {
            throw new Exception("Command string is incomplete");
        }
    }

}
