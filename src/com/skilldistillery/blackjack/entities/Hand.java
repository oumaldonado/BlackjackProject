package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	

	protected List<Card> cards;
	public Hand() {
		cards = new ArrayList<>();
		
	}
	
	public abstract int getHandValue();
	
	public void addCard(Card card) {
		
	}
	
	public void clear () {
		
	}
	

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	
	
	
	
	
}
