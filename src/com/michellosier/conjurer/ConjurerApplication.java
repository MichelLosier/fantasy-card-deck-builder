package com.michellosier.conjurer;

import java.util.*;

//https://stackoverflow.com/questions/4480334/how-to-call-a-method-stored-in-a-hashmap-java

public class ConjurerApplication {

    private static Scanner inputScanner =  new Scanner(System.in);
    private static Deck currentDeck;

    public static void main(String[] args) {
        System.out.println("New deck name:\n");
        String name = inputScanner.next();

        setCurrentDeck(new Deck(name));
        currentDeck.printCLInterface();
        currentDeck.performAction(inputScanner.next());

    }

    private static void setCurrentDeck(Deck deck){
        currentDeck = deck;
    }
}
