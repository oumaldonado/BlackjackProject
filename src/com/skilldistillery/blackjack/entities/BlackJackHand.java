package com.skilldistillery.blackjack.entities;

public class BlackJackHand extends Hand{
	protected Card card;
	public BlackJackHand() {}
	@Override
	public int getHandValue() {
		int valueOfCards = 0;
		for (Card card : cards) {
			valueOfCards+= card.getValue();
			
		}
		return valueOfCards;
	}
	public boolean isBlackJack() {
		if(card.getValue() == 21) {
			return true;
		}
		return false ;
		
	}
	public boolean isBust() {
		if (card.getValue() > 21) {
			return true;
		}
			
		return false;
		
	}
	@Override
	public String toString() {
		return " " + cards + " ";
	}
	
	
	

}
