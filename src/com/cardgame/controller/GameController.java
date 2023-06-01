package com.cardgame.controller;

import com.cardgame.models.Card;
import com.cardgame.models.Game;
import com.cardgame.models.Player;

import java.util.ArrayList;

public class GameController {

    public Game startGame (ArrayList<Player> players, ArrayList<Card> standardDeck, int currPlayerIndex, Card topCard) {
        Game game = new Game(players);
        game.setTopCard(topCard);
        game.setStandardDeck(standardDeck);
        game.setPlayers(players);
        return game;
    }

    public void displayCards (Game game, int currPlayerIndex) {
        game.displayCards(game.getPlayers().get(currPlayerIndex));
    }

}
