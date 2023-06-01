package com.cardgame;

import com.cardgame.controller.GameController;
import com.cardgame.models.Card;
import com.cardgame.models.Deck;
import com.cardgame.models.Game;
import com.cardgame.models.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main (String[] args) {

        GameController gameController = new GameController();
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();

        try {

            int currPlayerIndex = 0;
            ArrayList<ArrayList<Card>> inHandCards = deck.drawCards(4, 5);
            ArrayList<Player> players = new ArrayList<>();
            players.add(new Player(1, "Luffy", inHandCards.get(0)));
            players.add(new Player(2, "SABO", inHandCards.get(1)));
//            players.add(new Player(2, "SABO", inHandCards.get(2)));
//            players.add(new Player(2, "SABO", inHandCards.get(3)));
            ArrayList<Card> standardDeck = new ArrayList<>();
            Card topCard = null;
            Game game = gameController.startGame(players, standardDeck, currPlayerIndex, topCard);
            gameController.displayCards(game, currPlayerIndex);
            gameController.displayCards(game, 1);
//            gameController.displayCards(game, 2);
//            gameController.displayCards(game, 3);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
