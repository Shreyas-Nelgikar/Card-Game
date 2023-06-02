package com.cardgame.controller;

import com.cardgame.models.*;

import java.util.ArrayList;
import java.util.Scanner;

public class GameController {

    Scanner scanner = new Scanner(System.in);

    public Game createGame(ArrayList<Player> players, int noOfPlayers) {

        return Game.getBuilder()
                .setPlayers(players)
                .setNoOfPlayers(noOfPlayers)
                .build();
    }

    public void startGame (Game game) {
        game.startGame(game);
    }


    public void displayCards (Game game, int currPlayerIndex) {
        game.displayCards(game.getPlayers().get(currPlayerIndex));
    }

}
