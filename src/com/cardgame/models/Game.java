package com.cardgame.models;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private ArrayList<Player> players;
    private ArrayList<Card> standardDeck;
    private int currPlayerIndex;
    private Card topCard;
    private Deck deck;
    private GameState gameState;
    private CardRank cardRank;
    private int noOfPlayers;

    Scanner scanner = new Scanner(System.in);


    public static Builder getBuilder() {
        return new Builder();
    }

    private Game (ArrayList<Player> players, int noOfPlayers) {
        this.currPlayerIndex = 0;
        this.players = players;
        this.noOfPlayers = noOfPlayers;
        this.standardDeck = getDrawPile();
        this.topCard = getFirstTopCard(standardDeck);
        this.gameState = GameState.IN_PROGRESS;
    }

    public static class Builder {

        private ArrayList<Player> players;
        private int noOfPlayers;

        private Builder () {
            this.players = new ArrayList<>();
            this.noOfPlayers = 0;
        }

        public Builder setPlayers(ArrayList<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setNoOfPlayers(int noOfPlayers) {
            this.noOfPlayers = noOfPlayers;
            return this;
        }

        public Game build () {
            return new Game(players, noOfPlayers);
        }
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

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public Card getTopCard() {
        return topCard;
    }

    public void setTopCard(Card topCard) {
        this.topCard = topCard;
    }

    public int getNoOfPlayers() {
        return noOfPlayers;
    }

    public void setNoOfPlayers(int noOfPlayers) {
        this.noOfPlayers = noOfPlayers;
    }

    public ArrayList<Card> getDrawPile () {
        Deck deck = new Deck();
        ArrayList<ArrayList<Card>> cards = deck.drawCards(1, 52);
        ArrayList<Card> standardDeck = cards.get(0);
        return standardDeck;
    }

    public  Card getFirstTopCard (ArrayList<Card> cards) {
        int random = (int) (Math.random() * (52) + 0);
        Card card = cards.get(random);
        return card;
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

    public void gameState (Game game) {
        if (game.getStandardDeck().isEmpty())
            game.setGameState(GameState.DRAW);
    }

    public void startGame (Game game) {


        int currPlayerIndex = game.getCurrPlayerIndex();
        boolean reverseOrder = false;

        while (game.gameState == GameState.IN_PROGRESS) {

            Player player = game.getPlayers().get(currPlayerIndex);
            Card topCard = game.getTopCard();

            System.out.println("##############################################################");
            System.out.println("Cards Left : " + game.getStandardDeck().size());

            if (topCard.getRank().equals(CardRank.A)) {

                if (game.getStandardDeck().size() == 1) {
                    System.out.println("The game is draw as there are no cards available to draw");
                    break;
                }

                System.out.println( player.getPlayerName() + "'s turn has been skipped");
                topCard = pickCards(game.getStandardDeck());
                player.removeCard(game.getStandardDeck(), topCard);

            }

            else if (topCard.getRank().equals(CardRank.King)) {

                if (game.getStandardDeck().size() == 1) {
                    System.out.println("The game is draw as there are no cards available to draw");
                    break;
                }

                reverseOrder = !reverseOrder;
                topCard = pickCards(game.getStandardDeck());
                player.removeCard(game.getStandardDeck(), topCard);
                currPlayerIndex = getNextPlayerIndex(currPlayerIndex, reverseOrder);
                System.out.println("Direction of the game has been reversed");
            }

            else if (topCard.getRank().equals(CardRank.Queen)) {

                if (game.getStandardDeck().size() < 2) {
                    System.out.println("The game is draw as there are no cards available to draw");
                    break;
                }


                for (int i=0; i<2; i++) {
                    Card card = pickCards(game.getStandardDeck());
                    player.addCard(game.getPlayers().get(currPlayerIndex).getCardsInHand(), card);
                    player.removeCard(game.getStandardDeck(), card);
                }
                topCard = pickCards(game.getStandardDeck());
                player.removeCard(game.getStandardDeck(), topCard);
                System.out.println((player.getPlayerName()) + " has picked 2 cards");
            }

            else if (topCard.getRank().equals(CardRank.Joker)) {


                if (game.getStandardDeck().size() < 4) {
                    System.out.println("The game is draw as there are no cards available to draw");
                    break;
                }

                for (int i=0; i<4; i++) {
                    Card card = pickCards(game.getStandardDeck());
                    player.addCard(game.getPlayers().get(currPlayerIndex).getCardsInHand(), card);
                    player.removeCard(game.getStandardDeck(), card);
                }
                topCard = pickCards(game.getStandardDeck());
                player.removeCard(game.getStandardDeck(), topCard);
                System.out.println((player.getPlayerName()) + " has picked 4 cards");
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
                    displayCards(player);
                    System.out.println("TopCard " + topCard.getRank() + " " + topCard.getSuit());
                    System.out.println("Player " + (player.getPlayerName()) + " doesn't have a topCard so will pick a card from deck");
                    Card card = pickCards(game.getStandardDeck());
                    player.addCard(game.getPlayers().get(currPlayerIndex).getCardsInHand(), card);
                    player.removeCard(game.getStandardDeck(), card);
                }
            }

            if (game.getPlayers().get(currPlayerIndex).hasWon())
                game.setGameState(GameState.WIN);

            gameState(game);

            if (game.getGameState() == GameState.DRAW)
                System.out.println("The game is draw as there are no cards available to draw");
            else if (game.getGameState() == GameState.WIN)
                System.out.println( (player.getPlayerName()) + " has won the game");

            game.setTopCard(topCard);
            currPlayerIndex = getNextPlayerIndex(currPlayerIndex, reverseOrder);
            game.setCurrPlayerIndex(currPlayerIndex);
        }

    }

}
