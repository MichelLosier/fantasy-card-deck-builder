package com.michellosier.clitools;

import java.lang.reflect.Type;

public class CLIArgument {
    private String shortArg;
    private String longArg;
    private String description;
   // private Type expectedType;
    private boolean isRequired;

    public CLIArgument(String shortArg, String longArg, String description, boolean isRequired){
        this.shortArg = shortArg;
        this.longArg = longArg;
        this.description = description;
        //this.expectedType = expectedType;
        this.isRequired = isRequired;
    }

    public String getShortArg() {
        return shortArg;
    }

    public String getLongArg() {
        return longArg;
    }

    public String getDescription(){ return description;}

//    public Type getExpectedType() {
//        return expectedType;
//    }

    public boolean isRequired() {
        return isRequired;
    }
}
