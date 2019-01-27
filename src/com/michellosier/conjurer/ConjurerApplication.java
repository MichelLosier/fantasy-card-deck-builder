package com.michellosier.conjurer;

import java.util.*;

//https://stackoverflow.com/questions/4480334/how-to-call-a-method-stored-in-a-hashmap-java

public class ConjurerApplication {

    private static Scanner inputScanner =  new Scanner(System.in);
    private static Deck currentDeck;

    public static void main(String[] args) {
        boolean exit = false;
        Scanner input = new Scanner(System.in);

        //initialize CLI for a test deck
        Deck deck1 = new Deck("test");
        DeckCLI deckCLI = new DeckCLI(deck1);
        deckCLI.build();

        while(exit == false){
            String nextLine = input.nextLine();
            if(nextLine.matches("exit")) {
                exit = true;
                return;
            }

            try {
                CLICommand cmd = new CLICommand(nextLine);
                deckCLI.handleCommand(cmd);
            } catch(Exception e){
                e.printStackTrace();
            }

        }
        input.close();

    }

    private static void setCurrentDeck(Deck deck){
        currentDeck = deck;
    }
}
