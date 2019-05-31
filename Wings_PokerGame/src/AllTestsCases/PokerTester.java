package AllTestsCases;

import static org.junit.jupiter.api.Assertions.*;
import javax.swing.*;
import java.awt.*;

import PokerGame_GUI.Cards;

import org.junit.jupiter.api.Test;

class PokerTester {

	@Test
	public void Cardstest() {
		//fail("Not yet implemented");
		Cards cards = new Cards();
		String actual = cards.getRandCard();
		assertNotSame(cards.getRandCard(),actual,"First two pick are not random");
		actual = cards.getRandCard();
		assertNotSame(cards.getRandCard(),actual,"Second two pick are not random");
		actual = cards.getRandCard();
		assertNotSame(cards.getRandCard(),actual,"Third two pick are not random");
		actual = cards.getRandCard();
		assertNotSame(cards.getRandCard(),actual,"Fourth two pick are not random");
		actual = cards.getRandCard();
		assertNotSame(cards.getRandCard(),actual,"Fifth two pick are not random");
		
		
		//check for all distinct cards
		cards = new Cards();
		JLabel[][] checker = cards.gameCardsLabel();
		assertNotSame(cards.gameCardsLabel()[1],checker,"These arrays should be different");
		
	}
	
	@Test 
	public void check52Cards() {
		
	}

}
