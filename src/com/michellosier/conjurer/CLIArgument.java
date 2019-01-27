package com.michellosier.conjurer;

import java.lang.reflect.Type;

public class CLIArgument {
    private String shortArg;
    private String longArg;
   // private Type expectedType;
    private boolean isRequired;

    public CLIArgument(String shortArg, String longArg, boolean isRequired){
        this.shortArg = shortArg;
        this.longArg = longArg;
        //this.expectedType = expectedType;
        this.isRequired = isRequired;
    }

    public String getShortArg() {
        return shortArg;
    }

    public String getLongArg() {
        return longArg;
    }

//    public Type getExpectedType() {
//        return expectedType;
//    }

    public boolean isRequired() {
        return isRequired;
    }
}
