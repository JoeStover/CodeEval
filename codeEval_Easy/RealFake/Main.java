package RealFake;

import java.io.*;

/**
 * Real Fake / Challenge 227 / Easy
 * 
 * https://www.codeeval.com/open_challenges/227/
 * 
 * @author Joe Stover
 * @version Jan 3, 2016
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
				System.out.println(luhnCheck(line));
			}
		}
		finally
		{
			reader.close();
		}
	}
	/**
	 * Simple Luhn Algorithm implementation to check a passed in credit card
	 * number. DOES NOT utilize end digit checksum, per challenge instructions.
	 * 
	 * @param cardNum  String representation of a card number to be checked
	 * @return String "Real" if number is legit, "Fake" otherwise
	 */
	public static String luhnCheck(String cardNum)
	{
		String validity = "Real"; //initial validity is true
		cardNum = cardNum.replaceAll("\\s+",  ""); //cleans up the input number
		int sum = 0; // maintain test sum of card nums
		for(int i = 0; i < cardNum.length(); i++)
		{
			int val = Character.getNumericValue(cardNum.charAt(i));
			if(i % 2 == 0)
			{
				val *= 2;
			}
			sum += val;
		}
		if(sum % 10 != 0)
		{
			validity = "Fake";
		}
		return validity;
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

