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

            Game game = gameController.createGame(new Game());
//            gameController.displayCards(game, 0);
//            gameController.displayCards(game, 1);
//            gameController.displayCards(game, 2);
//            gameController.displayCards(game, 3);
//            ArrayList<Card> list = game.getStandardDeck();
//            for (int i=0; i<list.size(); i++)
//                System.out.println(list.get(i).getRank() +" "+ list.get(i).getSuit());
//            System.out.println(list.size());
            game.startGame(game);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
