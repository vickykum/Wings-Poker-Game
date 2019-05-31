/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PokerGame_GUI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author kotin
 */
public class Evaluate {
    
    public void bubbleSort(int arr[])
        {
            for (int i = 0; i < 4; i++)
            {
                for (int j = 0; j < 4 - i; j++)
                {
                    if (arr[j] > arr[j + 1])
                    {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        }

	public String get_cardName(String playerLabel) {
		String cardNum = playerLabel.substring(0, playerLabel.length() - 1);
		switch (cardNum) {
		case "A":
			return "14";
		case "K":
			return "13";
		case "Q":
			return "12";
		case "J":
			return "11";
		default:
			return cardNum;
		}
	}

	public String get_suitName(String playerLabel) {
		return playerLabel.substring(playerLabel.length() - 1);
	}
    
    // calculates the highCard
	public int highCard(ArrayList<String> playerLabels) {
		int highCardNum = 0;
		for (int i = 0; i < 5; i++) {
			int card1 = Integer.parseInt(get_cardName(playerLabels.get(i)));
                        
			if (highCardNum <= card1) {
				highCardNum = card1;
			}
		}
		return highCardNum;
	}
        
        //one pair
        public int onePair(ArrayList<String> playerLabels) {
            int cardLabel;
            int type = 0;
            Map<Integer, Integer> frequencyCount = new HashMap<Integer, Integer>();
            for (int i = 0; i < 5; i++) {
                cardLabel = Integer.parseInt(get_cardName(playerLabels.get(i)));
                if (frequencyCount.containsKey(cardLabel)) {
                    int frequency = frequencyCount.get(cardLabel);
                    frequency++;
                    frequencyCount.put(cardLabel, frequency);
                }
                else {
                    frequencyCount.put(cardLabel, 1);
                }
            }
            for (int key: frequencyCount.values()) {
                if (key == 2)
                    type = 15;
            }
            return type;
        }
        
        //two different pairs
        public int twoPair(ArrayList<String> playerLabels) {
            int cardLabel;
            int type = 0;
            int numPair = 0;
            Map<Integer, Integer> frequencyCount = new HashMap<Integer, Integer>();
            for (int i = 0; i < 5; i++) {
                cardLabel = Integer.parseInt(get_cardName(playerLabels.get(i)));
                if (frequencyCount.containsKey(cardLabel)) {
                    int frequency = frequencyCount.get(cardLabel);
                    frequency++;
                    frequencyCount.put(cardLabel, frequency);
                }
                else {
                    frequencyCount.put(cardLabel, 1);
                }
            }
            for (int key: frequencyCount.values())
                if (key == 2)
                    numPair++;
            if (numPair == 2)
                type = 16;
            return type;
        }
        
        // Any three numerically matching cards
        public int threeOfAKind(ArrayList<String> playerLabels) {
            int cardLabel;
            int type =0;
            Map<Integer, Integer> frequencyCount = new HashMap<Integer, Integer>();
            for (int i = 0; i < 5; i++) {
                cardLabel = Integer.parseInt(get_cardName(playerLabels.get(i)));
                if (frequencyCount.containsKey(cardLabel)) {
                    int frequency = frequencyCount.get(cardLabel);
                    frequency++;
                    frequencyCount.put(cardLabel, frequency);
                }
                else {
                    frequencyCount.put(cardLabel, 1);
                }
            }
            for (int cardFreq: frequencyCount.values())
                if (cardFreq == 3)
                    type = 17;
                else
                    type = 0;
            return type;
        }
        
        // all 5 cards are consecutive 
        public int straight(ArrayList<String> playerLabels) {
            int[] cardLabel = new int[5];
            int type =0;
            for (int i = 0; i < 5; i++) {
                cardLabel[i] = Integer.parseInt(get_cardName(playerLabels.get(i)));
            }
            bubbleSort(cardLabel);
            for (int i = 0; i < 4; i++)
            {
                if((cardLabel[i + 1] - cardLabel[i]) == 1)
                    type = 18;
                else
                    type = 0;
            }
            return type;
        }
        
        // all cards have the same suit
        public int flush(ArrayList<String> playerLabels) {
            String[] cardSuit = new String[5];
            int type = 0;
            int check = 0;
            for (int i = 0; i < 5; i++) {
                cardSuit[i] = get_suitName(playerLabels.get(i));
            }
            String firstSuit = cardSuit[0];
            for (int i = 0; i < 5; i++)
            {
                if (cardSuit[i].contains(firstSuit))
                    check++;
            }
            if (check == 5)
                return 19;
            else
                return 0;
        }
        
        //a three of a kind and a pair
        public int fullHouse(ArrayList<String> playerLabels) {
            int type = 0;
            if ((threeOfAKind(playerLabels) == 17) && (onePair(playerLabels) == 15))
                type = 20;
            else
                type = 0;
            return type;
        }
        
        //Any four numerically matching cards
        public int fourOfAKind(ArrayList<String> playerLabels) {
            int cardLabel;
            int type =0;
            Map<Integer, Integer> frequencyCount = new HashMap<Integer, Integer>();
            for (int i = 0; i < 5; i++) {
                cardLabel = Integer.parseInt(get_cardName(playerLabels.get(i)));
                if (frequencyCount.containsKey(cardLabel)) {
                    int frequency = frequencyCount.get(cardLabel);
                    frequency++;
                    frequencyCount.put(cardLabel, frequency);
                }
                else {
                    frequencyCount.put(cardLabel, 1);
                }
            }
            for (int cardFreq: frequencyCount.values())
                if (cardFreq == 4)
                    type = 21;
                else
                    type = 0;
            return type;
        }
        
        //combination of staroght and flush
        public int straightFlush(ArrayList<String> playerLabels) {
            int type =0;
            if ((straight(playerLabels) == 18))
                if ((flush(playerLabels) == 19))
                    type = 22;
                else
                    type = 0;
            else
                type = 0;
            return type;
        }
        
        //The best possible hand in Texas hold'em is the combination of 
        //ten, jack, queen, king, ace, all of the same suit
        public int royalFlush(ArrayList<String> playerLabels) {
            int type = 0;
            int[] cardLabel = new int[5];
            if(flush(playerLabels) == 19){
                for (int i = 0; i < 5; i++) {
                    cardLabel[i] = Integer.parseInt(get_cardName(playerLabels.get(i)));
                }
                bubbleSort(cardLabel);
                if ((cardLabel[0] == 10) && (cardLabel[1] == 11) && (cardLabel[2] == 12) && (cardLabel[3] == 13) && (cardLabel[4] == 14))
                    type = 23;
            }
            else
                type = 0;
            return type;
        }
        
        // Each poker rule is associated with an integer value such that the highCard will be till 14 which is an Ace
        // All other values are like one pair as 15, two pair as 16 and so on until royal flush which is 23
        // each player gets the value based on the hand he has using the evaluateHand function
        public int evaluateHand(ArrayList<String> playerLabels) {
            int handCount = 0;
            if (royalFlush(playerLabels) == 23)
                handCount = 23;
            else if (straightFlush(playerLabels) == 22)
                handCount = 22;
            else if (fourOfAKind(playerLabels) == 21)
                handCount = 21;
            else if (fullHouse(playerLabels) == 20)
                handCount = 20;
            else if (flush(playerLabels) == 19)
                handCount = 19;
            else if (straight(playerLabels) == 18)
                handCount = 18;
            else if (threeOfAKind(playerLabels) == 17)
                handCount = 17;
            else if (twoPair(playerLabels) == 16)
                handCount = 16;
            else if (onePair(playerLabels) == 15)
                handCount = 15;
            else 
                handCount = highCard(playerLabels);
            return handCount;
        } 
}
