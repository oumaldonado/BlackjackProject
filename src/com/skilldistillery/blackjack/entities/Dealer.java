package com.skilldistillery.blackjack.entities;

public class Dealer extends Player {
	Deck deck;

	public Dealer() {
		getDeck();
	}

	public void getDeck() {
		deck = new Deck();

	}

	public void displayDealersHand() {
		System.out.println("Dealers Hand: " + hand.toString());
	}

	public void display() {
		System.out.println("Dealer's hand: " + hand.getCards().get(1) + " and a face down card ");

	}

	public Card deal() {
		return deck.dealCard();

	}

	public void shuffle() {
		deck.shuffle();
	}

	public void clear() {
		deck = null;
		deck = new Deck();
	}

}
