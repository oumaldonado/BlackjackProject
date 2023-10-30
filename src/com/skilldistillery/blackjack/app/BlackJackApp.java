package com.skilldistillery.blackjack.app;

import java.util.Iterator;
import java.util.Scanner;

import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Player;

public class BlackJackApp {
	private Dealer dealer = new Dealer();
	private Player player = new Player();
	private Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		BlackJackApp app = new BlackJackApp();
		app.run();

	}

	public void run() {
		mainMenu();

	}

	public void mainMenu() {
		int userChoice = 0;
		boolean status = true;

		System.out.println(" BlackJack Game");
		System.out.println(" Press 1 to Play");
		System.out.println(" Press 2 to Quit");
		userChoice = kb.nextInt();
		switch (userChoice) {
		case 1:
			startGame();
			break;

		case 2:
			System.out.println("You selected Quit \n\nEnjoy your day!!! ");
			status = false;
			break;
		default:
			System.out.println("invaid entry");

		}

	}

	public void clear() {
		int playerHand = player.getHand().getHandValue();
		int dealerHand = dealer.getHand().getHandValue();
		dealerHand = 0;
		playerHand = 0;
	}

	public void inGameMenu() {
		int inGameStatus = 0;
		int userInput = 0;

		while (inGameStatus != 2) {
			System.out.println("1 for Hit  \t 2 for hold ");
			userInput = kb.nextInt();

			if (userInput == 1) {
				player.displayPlayersHand();
				System.out.println("        ");
				dealToPlayer();
				System.out.println("       ");
				player.displayPlayersHand();

			} else if (userInput == 2) {

				inGameStatus = userInput;

			} else {
				System.out.println("Invalid selection");
			}

		}
	}

	public void startGame() {
		dealer.shuffle();
		dealToPlayer();
		dealToDealer();
		System.out.println("Dealer has a face down card\n");
		dealToPlayer();
		dealToDealer();
		dealer.display();
		System.out.println(" ");
		inGameMenu();
		dealersTurn();
		checkForWinner();

	}

	public void dealToPlayer() {
		System.out.println("Dealing to player.......\n");
		player.addCard(dealer.deal());
		System.out.print("Total: " + player.getHand().getHandValue() + " ");
		player.displayPlayersHand();

	}

	public void dealToDealer() {
		dealer.addCard(dealer.deal());
		System.out.println(" ");
	}

	public void checkForBlackJack() {
		int playerCurrentHandSum = player.getHand().getHandValue();
		int dealerCurrentHandSum = dealer.getHand().getHandValue();
		if (playerCurrentHandSum == 21 && dealerCurrentHandSum == 21) {
			System.out.println();
			System.out.println();
			System.out.println("\tPush!!!");
			System.out.println();
			System.out.println();

		} else if (playerCurrentHandSum == 21) {
			System.out.println();
			System.out.println("\tPlayer wins!!!");
			System.out.println();
			System.out.println("dealer had: " + dealerCurrentHandSum);
			System.out.println();

		} else if (dealerCurrentHandSum == 21) {
			System.out.println();
			System.out.println();
			System.out.println("\tDealer wins!!!");
			System.out.println();
			System.out.println("Dealer had: " + dealerCurrentHandSum);

		}
	}

	public void checkForBust() {
		int playerCurrentHandSum = player.getHand().getHandValue();
		int dealerCurrentHandSum = dealer.getHand().getHandValue();
		if (playerCurrentHandSum > 21) {
			System.out.println();
			System.out.println("\tPlayer Bust!!!");
			System.out.println();
			System.out.println("Dealer Wins!!!");
			System.out.println();
			System.out.println("Dealer had: " + dealerCurrentHandSum);
		} else if (dealerCurrentHandSum > 21) {
			System.out.println();
			System.out.println("\tDealer Bust!!!");
			System.out.println();
			System.out.println("\tPlayer Wins!!!");
			System.out.println();
			System.out.println("Dealer had: " + dealerCurrentHandSum);
		}

	}

	public void checkForWinner() {
		checkForBlackJack();
		checkForBust();
		neitherBustOrBlack();

	}

	public void neitherBustOrBlack() {
		int dealersHand = dealer.getHand().getHandValue();
		int playerDifference = 21 - player.getHand().getHandValue();
		int dealerDiffrence = 21 - dealer.getHand().getHandValue();
		if (playerDifference > dealerDiffrence && dealerDiffrence > 0) {
			System.out.println();
			System.out.println();
			System.out.println("\tDealer wins!!!");
			System.out.println();
			System.out.println("Dealer had: " + dealersHand);

		} else if (dealerDiffrence > playerDifference && playerDifference > 0) {
			System.out.println();
			System.out.println();
			System.out.println("\tPlayer wins!!!");
			System.out.println();
			System.out.println("Dealer had: " + dealersHand);
		}

	}

	public void dealersTurn() {
		int dealersHand = dealer.getHand().getHandValue();
		int playersHand = player.getHand().getHandValue();
		try {
			if (playersHand <= 21) {

				while (dealersHand < 17) {
					dealToDealer();
					dealersHand = dealer.getHand().getHandValue();
				}
			}

		} catch (IndexOutOfBoundsException e) {
			System.out.println("dealer Bust!");
		}

	}
}
