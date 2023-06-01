package com.cardgame.models;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private ArrayList<Player> players;
    private ArrayList<Card> standardDeck;
    private int currPlayerIndex;
    private Card topCard;

    Scanner scanner = new Scanner(System.in);

    public Game() {};

    public Game (ArrayList<Player> players) {
        this.currPlayerIndex = 0;
        this.players = players;
        this.topCard = null;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public ArrayList<Card> getStandardDeck() {
        return standardDeck;
    }

    public void setStandardDeck(ArrayList<Card> standardDeck) {
        this.standardDeck = standardDeck;
    }

    public int getCurrPlayerIndex() {
        return currPlayerIndex;
    }

    public void setCurrPlayerIndex(int currPlayerIndex) {
        this.currPlayerIndex = currPlayerIndex;
    }

    public Card getTopCard() {
        return topCard;
    }

    public void setTopCard(Card topCard) {
        this.topCard = topCard;
    }

    public int getNextPlayerIndex (int currPlayerIndex, boolean reverseOrder) {
        int numPlayers = players.size();
        int nextPlayerIndex;
        if (reverseOrder) {
            nextPlayerIndex = (currPlayerIndex - 1 + numPlayers) % numPlayers;
        }
        else {
            nextPlayerIndex = (currPlayerIndex + 1) % numPlayers;
        }
        return nextPlayerIndex;
    }

    public Card pickCards (ArrayList<Card> standardDeck) {
        return standardDeck.get(standardDeck.size()-1);
    }

    public void displayCards (Player player) {
        player.displayCards();
    }

    public void startGame (Game game) {
        int currPlayerIndex = game.getCurrPlayerIndex();
        boolean reverseOrder = false;

        while (true) {
            Player player = game.getPlayers().get(currPlayerIndex);
            Card topCard = game.getTopCard();
            System.out.println("##############################################################");
            System.out.println("Player" + (player.getPlayerName()) + "'s turn, please select a card");
            displayCards(player);
            if (topCard.getRank().equals(player.getBonus(0))) {
                currPlayerIndex = getNextPlayerIndex(currPlayerIndex, reverseOrder);
            }
            else if (topCard.getRank().equals(player.getBonus(1))) {
                reverseOrder = !reverseOrder;
            }
            else if (topCard.getRank().equals(player.getBonus(2))) {
                for (int i=0; i<2; i++) {
                    Card card = pickCards(game.getStandardDeck());
                    player.addCard(game.getPlayers().get(currPlayerIndex).getCardsInHand(), card);
                    player.removeCard(game.getStandardDeck(), card);
                }
                topCard = pickCards(game.getStandardDeck());
                player.removeCard(game.getStandardDeck(), topCard);
            }
            else if (topCard.getRank().equals(player.getBonus(3))) {
                for (int i=0; i<4; i++) {
                    Card card = pickCards(game.getStandardDeck());
                    player.addCard(game.getPlayers().get(currPlayerIndex).getCardsInHand(), card);
                    player.removeCard(game.getStandardDeck(), card);
                }
            }
        }
    }

}
