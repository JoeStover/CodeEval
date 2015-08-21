package PokerHands;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

/**
 * Poker Hands / Challenge 86 / Hard
 * 
 * https://www.codeeval.com/open_challenges/86/
 * 
 * @author Joe Stover
 * @version Jan 20, 2015
 */
public class Main 
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = null;
		String line = null;
		try
		{
			reader = generateInputReader(args);
			while((line = reader.readLine()) != null)
			{
				String[] parts = line.split(" ");
				String[] leftHand = 
					{parts[0], parts[1], parts[2], parts[3], parts[4]};
				String[] rightHand = 
					{parts[5], parts[6], parts[7], parts[8], parts[9]};
				sortHandDescending(leftHand);
				Main.sortHandDescending(rightHand);
				System.out.println(Main.findWinningHand(leftHand, rightHand));
			}
		}
		finally
		{
			reader.close();
		}
	}
	/**
	 * Simple bubbleSort for hand in descending order 
	 * High card -> Low card 
	 * 
	 * @param the hand that needs sorting
	 */
	public static void sortHandDescending(String[] hand)
	{
		if(hand.length > 1)
		{
			for(int count = 0; count < hand.length; count++)
			{
				for(int i = 1; i < hand.length; i++)
				{
					if(Main.getValue(hand[i - 1]) < 
							Main.getValue(hand[i]))
					{
						String temp = hand[i - 1];
						hand[i - 1] = hand[i];
						hand[i] = temp;
					}
				}
			}
		}
	}
	/**
	 * Converts the "string" value of a card to its
	 * numeric equivalent.
	 * 
	 * @param the card whose value we are determining
	 * @return the numeric value of the card
	 */
	public static int getValue(String card)
	{
		char id = card.charAt(0);
		int value = 0;
		if(Character.isDigit(id))
		{
			value = Character.getNumericValue(id);
		}
		else if(id == 'T')
		{
			value = 10;
		}
		else if(id == 'J')
		{
			value = 11;
		}
		else if(id == 'Q')
		{
			value = 12;
		}
		else if(id == 'K')
		{
			value = 13;
		}
		else if(id == 'A')
		{
			value = 14;
		}
		return value;
	}
	/**
	 * Determines whether a hand is a royal flush by checking
	 * for a straight, flush, and then exact sequence.
	 * 
	 * @param hand to be checked
	 * @return true if a royal flush, false otherwise
	 */
	public static boolean isRoyalFlush(String[] hand)
	{
		boolean hasRoyal = false;
		if(Main.isFlush(hand) && Main.isStraight(hand))
		{
			if(hand[0].charAt(0) == 'A' && 
					hand[1].charAt(0) == 'K' &&
						hand[2].charAt(0) == 'Q' &&
							hand[3].charAt(0) == 'J' &&
								hand[4].charAt(0) == 'T')
			{
				hasRoyal = true;
			}
		}
		
		return hasRoyal;
	}
	/**
	 * Determines whether a hand is a royal flush by checking
	 * for a straight and flush.
	 * 
	 * @param hand to be checked
	 * @return true if a flush, false otherwise
	 */
	public static boolean isStraightFlush(String[] hand)
	{
		boolean hasFlush = false;
		if(Main.isFlush(hand) && Main.isStraight(hand))
		{
			hasFlush = true;
		}
		return hasFlush;
	}
	/**
	 * Determines whether or not this hand contains a for of a kind
	 * and the high card, if so.
	 * 
	 * @param hand to be checked
	 * @return if true, returns positive face value of 4 of kind
	 *         if false, returns -1
	 */
	public static int isFourOfAKind(String[] hand)
	{
		int hasFourOfAKind = -1;
		HashMap<Integer, Integer> matches = new HashMap<Integer, Integer>();
		for(int i = 0; i < hand.length; i++)
		{
			int faceValue = Main.getValue(hand[i]);
			if(matches.containsKey(faceValue))
			{
				matches.put(faceValue, matches.get(faceValue) + 1);
			}
			else
			{
				matches.put(faceValue, 1);
			}
		}
		for (Entry<Integer, Integer> entry : matches.entrySet()) 
		{
	        if(entry.getValue() == 4)
	        {
	        	hasFourOfAKind = entry.getKey();
	        }
	    }	
		return hasFourOfAKind;
	}
	/**
	 * Determines if this hand is a full house and high card, if so.
	 * 
	 * @param hand to be checked
	 * @return if true, returns positive face value of high card
	 *         if false, returns -1
	 */
	public static int isFullHouse(String[] hand)
	{
		int hasFullHouse = -1;
		HashMap<Integer, Integer> matches = new HashMap<Integer, Integer>();
		for(int i = 0; i < hand.length; i++)
		{
			int faceValue = Main.getValue(hand[i]);
			if(matches.containsKey(faceValue))
			{
				matches.put(faceValue, matches.get(faceValue) + 1);
			}
			else
			{
				matches.put(faceValue, 1);
			}
			if(matches.containsValue(3) && matches.containsValue(2))
			{
				for (Entry<Integer, Integer> entry : matches.entrySet()) 
				{
			        if(entry.getValue() == 3)
			        {
			        	hasFullHouse = entry.getKey();
			        }
			    }
			}
		}
		return hasFullHouse;
	}
	/**
	 * Determines if the suit value of all cards are equal
	 * 
	 * @param hand to be checked
	 * @return true if hand is a flush, false otherwise
	 */
	public static boolean isFlush(String[] hand)
	{
		char suit = hand[0].charAt(1);
		boolean hasFlush = true;
		int counter = 1;
		while(hasFlush && counter < hand.length)
		{
			if(suit != hand[counter].charAt(1))
			{
				hasFlush = false;
			}
			counter++;
		}	
		return hasFlush;
	}
	/**
	 * Determines if this hand is a straight (sequential values)
	 * 
	 * @param hand to be checked
	 * @return true if it is a straight, false otherwise
	 */
	public static boolean isStraight(String[] hand)
	{
		boolean hasStraight = true;
		int counter = 1;
		while(hasStraight && counter < hand.length)
		{
			if(Main.getValue(hand[counter-1]) 
					!= Main.getValue(hand[counter]) + 1)
			{
				hasStraight = false;
			}
			counter++;
		}
		return hasStraight;
	}
	/**
	 * Determines if this hand is a three of a kind and high card, if so.
	 * 
	 * @param hand to be checked
	 * @return if true, returns positive face value of high card
	 *         if false, returns -1
	 */
	public static int isThreeOfAKind(String[] hand)
	{
		int hasThreeOfAKind = -1;
		HashMap<Integer, Integer> matches = new HashMap<Integer, Integer>();
		for(int i = 0; i < hand.length; i++)
		{
			int faceValue = Main.getValue(hand[i]);
			if(matches.containsKey(faceValue))
			{
				matches.put(faceValue, matches.get(faceValue) + 1);
			}
			else
			{
				matches.put(faceValue, 1);
			}
		}
		for (Entry<Integer, Integer> entry : matches.entrySet()) 
		{
	        if(entry.getValue() == 3)
	        {
	        	hasThreeOfAKind = entry.getKey();
	        }
	    }	
		return hasThreeOfAKind;
	}
	/**
	 * Determines if this hand is two pair and an integer that
	 * represents the high and low card in that pair.
	 * (e.g. 43, would represent AD  4S  4H  3S  3S)
	 * 
	 * This value is the value as described by this.getValue(). So it
	 * is the numeric value, not A, K, Q, etc.
	 * (e.g. 1413, would represent AD  AS  KH  KS  3S) 
	 * 
	 * @param hand to be checked
	 * @return if true, returns positive face value of high card and low card
	 * 	                as described above
	 *         if false, returns -1
	 */
	public static int isTwoPair(String[] hand)
	{
		int hasTwoPair = -1;
		HashMap<Integer, Integer> matches = new HashMap<Integer, Integer>();
		for(int i = 0; i < hand.length; i++)
		{
			int faceValue = Main.getValue(hand[i]);
			if(matches.containsKey(faceValue))
			{
				matches.put(faceValue, matches.get(faceValue) + 1);
			}
			else
			{
				matches.put(faceValue, 1);
			}	
		}
		int count = 0;
		String highCards = "";
		for (Entry<Integer, Integer> entry : matches.entrySet()) 
		{				
	        if(entry.getValue() == 2)
	        {
	        	if(count == 0)
	        	{
	        		highCards += entry.getValue();
	        	}
	        	else
	        	{
	        		if(entry.getValue() > Integer.parseInt(highCards))
	        		{
	        			highCards = entry.getValue() + highCards;
	        		}
	        		else
	        		{
	        			highCards += entry.getValue();
	        		}
	        	}
	        	count++;
	        }
			if(count == 2)
			{
				hasTwoPair = Integer.parseInt(highCards);
			}
		}		
		return hasTwoPair;
	}
	/**
	 * Determines if this hand is a one pair and high card, if so.
	 * 
	 * Note: I could check if it contains 2 and return a -1 if so; however,
	 * this.isTwoPair() gets called before this function, and would prevent
	 * this function call if it is true (i.e. returns a positive number).
	 * 
	 * @param hand to be checked
	 * @return if true, returns positive face value of high card
	 *         if false, returns -1
	 */
	public static int isOnePair(String[] hand)
	{
		int hasOnePair = -1;
		HashMap<Integer, Integer> matches = new HashMap<Integer, Integer>();
		for(int i = 0; i < hand.length; i++)
		{
			int faceValue = Main.getValue(hand[i]);
			if(matches.containsKey(faceValue))
			{
				matches.put(faceValue, matches.get(faceValue) + 1);
			}
			else
			{
				matches.put(faceValue, 1);
			}
		}
		for (Entry<Integer, Integer> entry : matches.entrySet()) 
		{
	        if(entry.getValue() == 2)
	        {
	        	hasOnePair = entry.getKey();
	        }
	    }	
		return hasOnePair;
	}
	/**
	 * Determines the winning hand in a game of poker.
	 * 
	 * @param leftHand in the game
	 * @param rightHand in the game
	 * @return the String describing which hand won (leftHand = "left",
	 *         rightHand = "right", "none" if there is a tie)
	 */
	public static String findWinningHand(String[] leftHand, String[] rightHand)
	{
		String winner = "";
		/* Move through the PokerHand hierarchy and set the winner */
		// ROYAL FLUSH
		if(Main.isRoyalFlush(leftHand) && 
				!Main.isRoyalFlush(rightHand))
		{
			winner = "left";
		}
		else if(!Main.isRoyalFlush(leftHand) && 
					Main.isRoyalFlush(rightHand))
		{
			winner = "right";
		}
		else if(Main.isRoyalFlush(leftHand) && Main.isRoyalFlush(leftHand))
		{
			winner = "none";
		}
		// STRAIGHT FLUSH
		else if(Main.isStraightFlush(leftHand) && 
					!Main.isStraightFlush(rightHand))
		{
			winner = "left";
		}
		else if(!Main.isStraightFlush(leftHand) && 
					Main.isStraightFlush(rightHand))
		{
			winner = "right";
		}
		else if(Main.isStraightFlush(leftHand) && 
					Main.isStraightFlush(rightHand))
		{
			if(Main.getValue(leftHand[0]) > 
					Main.getValue(rightHand[0]))
			{
				winner = "left";
			}
			else if(Main.getValue(leftHand[0]) < 
						Main.getValue(rightHand[0]))
			{
				winner = "right";
			}
			else if(Main.getValue(leftHand[0]) == 
						Main.getValue(rightHand[0]))
			{
				winner = "none";
			}
		}
		// FOUR OF A KIND 
		else if(Main.isFourOfAKind(leftHand) >  
					Main.isFourOfAKind(rightHand))
		{
			winner = "left";
		}
		else if(Main.isFourOfAKind(leftHand) <  
					Main.isFourOfAKind(rightHand))
		{
			winner = "right";
		}
		// FULL HOUSE
		else if(Main.isFullHouse(leftHand) > 
					Main.isFullHouse(rightHand))
		{
			winner = "left";
		}
		else if(Main.isFullHouse(leftHand) < 
					Main.isFullHouse(rightHand))
		{
			winner = "right";
		}
		// FLUSH
		else if(Main.isFlush(leftHand) && !Main.isFlush(rightHand))
		{
			winner = "left";
		}
		else if(!Main.isFlush(leftHand) && Main.isFlush(rightHand))
		{
			winner = "right";
		}
		else if(Main.isFlush(leftHand) && Main.isFlush(rightHand))
		{
			// now we need to test card by card
			winner = Main.compareHandsByCardValue(leftHand, rightHand);
		}
		// STRAIGHT
		else if(Main.isStraight(leftHand) && 
					!Main.isStraight(rightHand))
		{
			winner = "left";
		}
		else if(!Main.isStraight(leftHand) && 
					Main.isStraight(rightHand))
		{
			winner = "right";
		}
		else if(Main.isStraight(leftHand) && 
					Main.isStraight(rightHand))
		{
			if(Main.getValue(leftHand[0]) > 
					Main.getValue(rightHand[0]))
			{
				winner = "left";
			}
			else if(Main.getValue(leftHand[0]) < 
						Main.getValue(rightHand[0]))
			{
				winner = "right";
			}
		}
		// THREE OF A KIND
		else if(Main.isThreeOfAKind(leftHand) > 
					Main.isThreeOfAKind(rightHand))
		{
			winner = "left";
		}
		else if(Main.isThreeOfAKind(leftHand) < 
					Main.isThreeOfAKind(rightHand))
		{
			winner = "right";
		}
		// TWO PAIR
		else if(Main.isTwoPair(leftHand) > 
					Main.isTwoPair(rightHand))
		{
			winner = "left";
		}
		else if(Main.isTwoPair(leftHand) < 
					Main.isTwoPair(rightHand))
		{
			winner = "right";
		}
		else if(Main.isTwoPair(leftHand) == 
					Main.isTwoPair(rightHand) &&
						Main.isTwoPair(leftHand) != -1)
		{
			// if same, compare entire hand
			winner = Main.compareHandsByCardValue(leftHand, rightHand);
		}
		// ONE PAIR
		else if(Main.isOnePair(leftHand) >
					Main.isOnePair(rightHand))
		{
			winner = "left";
		}
		else if(Main.isOnePair(leftHand) <
					Main.isOnePair(rightHand))
		{
			winner = "right";
		}
		else if(Main.isOnePair(leftHand) == 
				Main.isOnePair(rightHand))
		{			
			// now we need to test card by card
			winner = Main.compareHandsByCardValue(leftHand, rightHand);
		}
		// HIGH CARD
		else
		{
			winner = Main.compareHandsByCardValue(leftHand, rightHand);
		}	
		return winner;
	}
	/**
	 * Compares hands by each value in descending order.
	 * 
	 * @param leftHand in the game
	 * @param rightHand in the game
	 * @return "left" if left hand is better, "none" if tied hands, "right"
	 *         if right hand is better
	 */
	public static String compareHandsByCardValue(String[] leftHand, 
			String[] rightHand)
	{
		String comparison = "none";
		int count = 0;
		while(comparison.equals("none") && count < 5)
		{
			if(Main.getValue(leftHand[count]) > 
				Main.getValue(rightHand[count]))
			{
				comparison = "left";
			}
			else if(Main.getValue(leftHand[count]) < 
				Main.getValue(rightHand[count]))
			{
				comparison = "right";
			}
			count++;
		}		
		return comparison;
	}
	/**
	 * Generates a BufferedReader for a file, either from passed in
	 * arguments or an input.txt file based on relation to this class.
	 * 
	 * @param args array of arguments passed to Main. If no args, finds
	 *             input.txt based on class location
	 * @return a BufferedReader based on input file
	 * @throws IOException if file is not found
	 */
	public static BufferedReader generateInputReader(String[] args) 
			throws IOException
	{
		if(args.length == 0)
		{
			InputStream stream = Main.class.getResourceAsStream("input.txt");
			return new BufferedReader(new InputStreamReader(stream));
		}
		else
		{
			return new BufferedReader(new FileReader(args[0]));
		}
	}
}