package com.michellosier.conjurer;

import java.util.*;

public class CommandParser {
    private ArrayList<Option> CLInterface;

    public CommandParser(ArrayList<Option> CLInterface){
        this.CLInterface = CLInterface;
    }

    public int getActionOptionIndex(String action){
        int index = -1;

        for (int i = 0; i < CLInterface.size(); i++){
            Option option = CLInterface.get(i);

            if(action.matches(option.getAction())){
                index = i;
                break;
            }
        }
        return index;
    }

    public void invokeMethodFromCommand(String command){
        int actionIndex = this.getActionOptionIndex(command);
        if (actionIndex > -1){
            this.CLInterface.get(actionIndex).runMethod();
        } else {
            System.out.printf("Command '%s' not recognized", command);
        }
    }

    public void printCommandOptions(){
        System.out.println("Commands: \n");
        CLInterface.forEach((option) -> {
            System.out.printf("%s: %s\n", option.getAction(), option.getDescription());
        });
    }

}
