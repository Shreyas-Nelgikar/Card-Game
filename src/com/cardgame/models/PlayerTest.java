package com.cardgame.models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    ArrayList<Card> list = new ArrayList<>();
    ArrayList<Card> list2 = new ArrayList<>();
    ArrayList<Card> list3 = new ArrayList<>();

    @Test
    void hasPlayableCard() {
        list.add(new Card(CardRank.One, CardSuit.Heart));
        list.add(new Card(CardRank.Three, CardSuit.Club));
        list.add(new Card(CardRank.A, CardSuit.Spade));
        list.add(new Card(CardRank.King, CardSuit.Diamond));
        Player player = new Player(1, "xyz", list);
        Card topCard1 = new Card(CardRank.A, CardSuit.Heart);
        Card topCard2 = new Card(CardRank.A, CardSuit.Spade);
        assertEquals(true, player.hasPlayableCard(list.get(2), topCard2));
        assertNotEquals("Please re-select a Card that matches Rank or Suit of the topCard", player.hasPlayableCard(list.get(1), topCard1));
    }

    @Test
    void hasWon() {
        Player player1 = new Player(1, "xyz", list);
        Player player2 = new Player(2, "abc", list2);
        assertEquals(false, player1.hasWon());
        assertEquals(true, player2.hasWon());
    }

    @Test
    void addCrad() {
        Card card = new Card(CardRank.Ten, CardSuit.Heart);
        ArrayList<Card> list3 = new ArrayList<>(list);
        list3.add(card);
        Player player1 = new Player(1, "xyz", list);
        player1.addCard(list, card);
        assertArrayEquals(new ArrayList[]{list3}, new ArrayList[]{list});
    }

    @Test
    void removeCrad() {
        Card card = new Card(CardRank.One, CardSuit.Heart);
        ArrayList<Card> list3 = new ArrayList<>(list);
        Player player1 = new Player(1, "xyz", list);
        player1.removeCard(list, card);
        player1.removeCard(list3, card);
        assertArrayEquals(new ArrayList[]{list3}, new ArrayList[]{list});
    }
}