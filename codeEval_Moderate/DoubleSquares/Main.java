package DoubleSquares;

import java.io.*;

/**
 * Double Squares / Challenge 33 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/33/
 * 
 * @author Joe Stover
 * @version Feb 05, 2015
 */
public class Main 
{
	public static void main(String[] args) throws IOException 
	{
		BufferedReader reader = null;
		try
		{
			reader = generateInputReader(args);
			int lineCount = Integer.parseInt(reader.readLine());
			for(int count = 0; count < lineCount; count++)
			{
				int num = Integer.parseInt(reader.readLine());
				System.out.println(getDblSquareCount(num));
			}
		}
		finally
		{
			reader.close();
		}
	}
	
	/**
	 * Gets the total ways the given number can be written as the sum of 2
	 * squares.
	 * 
	 * @param number integer to be tested
	 * @return total count squared sums for this number
	 */
	public static int getDblSquareCount(int number)
	{
		int count = 0;
		// cut prob set down by just dealing with sqrt of number
		int range = (int) Math.sqrt(number);
		for(int i = 0; i <= range + 1; i++)
		{
			// check for squares within our range
			double temp = Math.sqrt(number - i * i);
			// number is only sqrd if it is whole
			if(temp >= i && temp == (int)temp)
			{
				count++;
			}
		}		
		return count;
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
