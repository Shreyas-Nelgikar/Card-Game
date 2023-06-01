package com.cardgame;

import com.cardgame.controller.GameController;
import com.cardgame.models.Card;
import com.cardgame.models.Game;
import com.cardgame.models.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main (String[] args) {

        GameController gameController = new GameController();
        Scanner scanner = new Scanner(System.in);

        try {

            int currPlayerIndex = 0;
            ArrayList<Player> players = new ArrayList<>();
            ArrayList<Card> standardDeck = new ArrayList<>();
            Card topCard = null;
            Game game = gameController.startGame(players, standardDeck, currPlayerIndex, topCard);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
