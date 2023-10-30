package com.skilldistillery.blackjack.entities;

public class Player {
	protected Hand hand;
	BlackJackHand blackJackHand = new BlackJackHand();
	
	public Player() {
		hand = new BlackJackHand();
	}
	public void displayPlayersHand() {
		System.out.println("Player Hand: "+ hand.toString());
		System.out.print("");
	}
	
	public void addCard(Card aCard) {
		hand.cards.add(aCard);
	}


	public Hand getHand() {
		return hand;
	}


	public void setHand(Hand hand) {
		this.hand = hand;
	}
	
	
}



