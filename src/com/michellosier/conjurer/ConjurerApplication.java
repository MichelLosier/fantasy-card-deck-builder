package com.michellosier.conjurer;

import com.michellosier.clitools.CLICommand;
import com.michellosier.clitools.EntityCLI;
import com.michellosier.clitools.CLIRouter;

import java.util.*;


public class ConjurerApplication {

    private static Scanner inputScanner =  new Scanner(System.in);
    private static Deck currentDeck;

    public static void main(String[] args) {
        boolean exit = false;
        Scanner input = new Scanner(System.in);

        CLIRouter router = new CLIRouter();


        //initialize CLI for a test deck
        Deck deck1 = new Deck("test");

        EntityCLI deckCLI = new DeckCLI(deck1);
        deckCLI.build();

        router.addInterface(deckCLI);

        while(exit == false){
            String nextLine = input.nextLine();
            if(nextLine.matches("exit")) {
                exit = true;
                return;
            }

            try {
                CLICommand cmd = new CLICommand(nextLine);
                router.routeCommand(cmd);
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
