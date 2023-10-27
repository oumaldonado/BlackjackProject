package com.skilldistillery.blackjack.entities;

public enum Suit {
	HEARTS("Hearts"),
	SPADES("Spades"), 
	CLUBS("Clubs"), 
	DIAMONDS("Diamonds");

	private String name;
	Suit(String aName) {
		name = aName;
	}


	@Override
	public String toString() {
		return name;

	}

//	public String getName() {
//		return name;
//	}
}
