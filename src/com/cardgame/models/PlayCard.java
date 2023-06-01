package com.cardgame.models;

public class PlayCard {

    private Player player;

    PlayCard(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
