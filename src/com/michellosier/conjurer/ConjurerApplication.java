package com.michellosier.conjurer;

import java.util.*;

//https://stackoverflow.com/questions/4480334/how-to-call-a-method-stored-in-a-hashmap-java

public class ConjurerApplication {

    private static Scanner inputScanner =  new Scanner(System.in);
    private static Deck currentDeck;

    public static void main(String[] args) {
        boolean exit = false;
        Scanner input = new Scanner(System.in);

        while(exit == false){
            String nextLine = input.nextLine();
            if(nextLine.matches("exit")) {
                exit = true;
                return;
            }
            fooBarCLI.interpretCommand(nextLine);
        }
        input.close();

    }

    private static void setCurrentDeck(Deck deck){
        currentDeck = deck;
    }
}
