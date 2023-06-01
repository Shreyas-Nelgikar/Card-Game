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

    public boolean playerHasTopCard (Player player, Card topCard) {
        for (Card cards: player.getCardsInHand()) {
            if (cards.getRank().equals(topCard.getRank()) || cards.getSuit().equals(topCard.getSuit()))
                return true;
        }
        return false;
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
            if (topCard.getRank().equals(player.getBonus(0))) {
                System.out.println( player.getPlayerName() + "'s turn has been skipped");
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
                topCard = pickCards(game.getStandardDeck());
                player.removeCard(game.getStandardDeck(), topCard);
            }
            else {
                if (playerHasTopCard(player, topCard)) {
                    System.out.println("Player " + (player.getPlayerName()) + "'s turn, please select a card");
                    displayCards(player);
                    System.out.println("TopCard " + topCard.getRank() + " " + topCard.getSuit());
                    int select = scanner.nextInt();
                    Card card = game.getPlayers().get(currPlayerIndex).getCardsInHand().get(select);
                    while (!player.hasPlayableCard(card, topCard)) {
                        select = scanner.nextInt();
                        card = game.getPlayers().get(currPlayerIndex).getCardsInHand().get(select);
                    }
                    topCard = card;
                    player.removeCard(game.getPlayers().get(currPlayerIndex).getCardsInHand(), card);
                }
                else {
                    Card card = pickCards(game.getStandardDeck());
                    player.addCard(game.getPlayers().get(currPlayerIndex).getCardsInHand(), card);
                    player.removeCard(game.getStandardDeck(), card);
                }
            }
            game.setTopCard(topCard);
            if (game.getPlayers().get(currPlayerIndex).getCardsInHand().size() == 0) {
                System.out.println(player.getPlayerName() + " has won the game");
                break;
            }
            if (game.getStandardDeck().size() == 0) {
                System.out.println("Draw");
                break;
            }
            currPlayerIndex = getNextPlayerIndex(currPlayerIndex, reverseOrder);
            game.setCurrPlayerIndex(currPlayerIndex);
        }
    }

}
