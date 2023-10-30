package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> deck = new ArrayList<>(52);

	public Deck() {
		Suit[] suits = Suit.values();
		Rank[] ranks = Rank.values();

		for (Rank rank : ranks) {
			for (Suit suit : suits) {
				Card aCard = new Card(suit, rank);
				deck.add(aCard);
			}
		}
	}

	public int checkDeckSize() {
		return deck.size();
	}

	public Card dealCard() {
		Card someCardFromDeck = null;
		someCardFromDeck = deck.remove(0);
		return someCardFromDeck;
	}

	public void shuffle() {
		Collections.shuffle(deck);

	}

}
