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

        try {

            Game game = new Game();
            game.createGame();
            game = gameController.startGame(game.getPlayers(), game.getStandardDeck(),
                    game.getCurrPlayerIndex(), game.getTopCard());
//            gameController.displayCards(game, currPlayerIndex);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
