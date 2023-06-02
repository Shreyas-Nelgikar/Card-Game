package com.cardgame;

import com.cardgame.controller.GameController;
import com.cardgame.models.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main (String[] args) {

        GameController gameController = new GameController();

        try {

            GameIntialisation gameIntialisation = new GameIntialisation();
            int noOfPlayers = gameIntialisation.initializeNoOfPlayers();
            ArrayList<Player> players = gameIntialisation.initializePlayers(noOfPlayers);
            Game game = gameController.createGame(players, noOfPlayers);
            gameController.startGame(game);




        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
