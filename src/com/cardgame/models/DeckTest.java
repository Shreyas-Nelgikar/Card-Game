package com.cardgame.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    @Test
    void drawCards() {
        Deck deck = new Deck();
        assertNotEquals(deck.drawCards(1, 52), deck.drawCards(1, 52));
    }
}