package JollyJumpers;

import java.io.*;
import java.util.*;

/**
 * Jolly Jumpers / Challenge 43 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/43/
 * 
 * @author Joe Stover
 * @version July 23, 2016
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
				System.out.println((isJolly(line)) ? "Jolly" : "Not jolly");
			}
		}
		finally
		{
			reader.close();
		}
	}
	/**
	 * Determines if the String input converts to a "jolly jumper" according
	 * to the challenge rules:
	 * 
	 * "A sequence of n > 0 integers where the absolute values of the differences 
	 * between successive elements cover all possible values 1 through n - 1"
	 * 
	 * Logic:
	 * 1) Only Jolly if differences are 1 to n - 1, so can keep track with BitSet.
	 *    BitSet is one less than array length being checked where cardinality is
	 *    the length of the BitSet (no repeats).
	 * 2) isJolly fails if any difference is negative or greater than n - 1
	 *       
	 * @param line to be tested
	 * @return true if this line input is a jolly jumper, false otherwise
	 */
	public static boolean isJolly(String line)
	{
		boolean hasJolly = true;
		String[] num = line.split(" ");
		// BitSet contains differences (array length - 1)
		int bitLength = Integer.parseInt(num[0]) - 1; 
		// Remember: Offset the BitSet by 1 since zero index
		BitSet diffSet = new BitSet(bitLength);
		// our "jolly" array is from 1 to n - 1 (index 0 held size)
		for(int i = 2; i < num.length && hasJolly; i++)
		{
			int diff = Math.abs(
					Integer.parseInt(num[i - 1]) - Integer.parseInt(num[i]));
			if(diff < 1 || diff > bitLength)
			{
				hasJolly = false;
			}
			else
			{
				diffSet.set(diff - 1);
			}
		}
		hasJolly = diffSet.cardinality() == bitLength;
		return hasJolly;		
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

