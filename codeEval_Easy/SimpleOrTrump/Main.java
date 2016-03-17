package SimpleOrTrump;

import java.io.*;
import java.util.*;

/**
 * Simple or Trump / Challenge 235 / Easy
 * 
 * https://www.codeeval.com/open_challenges/235/
 * 
 * @author Joe Stover
 * @version Feb 21, 2013
 * 
 * Note: def needs some clean up in my Card class.
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
				solveChallenge(line);
			}
		}
		finally
		{
			reader.close();
		}
	}
	/**
	 * Solves the given challenge based on given input.
	 * 
	 * @param line as a String extracted from a given file
	 */
	public static void solveChallenge(String line)
	{
		String[] parts = line.split("\\ \\|\\ ");
		String[] cards = parts[0].split(" ");
		String trump = parts[1];
		Card cardOne = new Card(cards[0]);
		Card cardTwo = new Card(cards[1]);
		System.out.println(cardOne.getHighCard(cardTwo, trump));
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
	/**
	 * Represents a card based on suit and value.
	 */
	public static class Card
	{
		public final String suit;
		public final String faceValue;
		public final int value;
		
		/**
		 * Constructs a card based on input.
		 * 
		 * @param input String to be converted into a card object
		 */
		public Card(String input)
		{
			this.faceValue = input.substring(0, input.length() - 1);
			this.suit = input.substring(input.length() - 1);
			char v = input.charAt(0);
			if(v == 'A')
			{
				this.value = 14;
			}
			else if(v == 'K')
			{
				this.value = 13;
			}
			else if(v == 'Q')
			{
				this.value = 12;
			}
			else if(v == 'J')
			{
				this.value = 11;
			}
			else
			{
				this.value = Integer.parseInt(input.replaceAll("[^0-9]", ""));
			}
		}
		/**
		 * Returns the highest card based on trump and value (or both if even).
		 * 
		 * @param other second card to which we are comparing "this" card
		 * @param trump suit that is trump for this round
		 * @return String representation of high card (or both cards if even)
		 * 
		 * NOTE: need to clean up the messy if/else's, but this is brute force
		 *       first attempt
		 */
		public String getHighCard(Card other, String trump)
		{
			String winner = "";
			// suits match (trump doesn't matter)
			if(this.suit.equals(other.suit))
			{
				if(this.value == other.value)
				{
					winner = this.toString() + " " + other.toString();
				}
				else
				{
					winner = (this.value > other.value) ?
							this.toString() : other.toString();
				}
			}
			// one has a trump
			else if(this.suit.equals(trump) || other.suit.equals(trump))
			{
				winner = (this.suit.equals(trump)) ? 
						this.toString() : other.toString();
			}
			// suit doesn't matter
			else
			{
				if(this.value == other.value)
				{
					winner = this.toString() + " " + other.toString();
				}
				else
				{
					winner = (this.value > other.value) ?
							this.toString() : other.toString();
				}
			}		
			return winner;
		}
		/**
		 * String representation of this card.
		 * 
		 * (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		public String toString()
		{
			return this.faceValue + suit;
		}
	}
}
