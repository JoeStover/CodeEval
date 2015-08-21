package MinimumCoins;

import java.io.*;

/**
 * Minimum Coins / Challenge 74 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/74/
 * 
 * "You are given 3 coins of value 1, 3 and 5. You are also given a total 
 *  which you have to arrive at. Find the minimum number of coins to arrive 
 *  at it."
 * 
 * @author Joe Stover
 * @version Jan 26, 2015
 */
public class Main 
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader reader = null;
		String line = null;
		try
		{
			reader = generateInputReader(args);
			while((line = reader.readLine()) != null)
			{
				int total = Integer.parseInt(line);
				int coinCount = 0;
				while(total > 0)
				{
					if(total >= 5)
					{
						coinCount += total / 5;
						total %= 5;
					}
					else if(total >= 3)
					{
						coinCount += total / 3;
						total %= 3;
					}
					else
					{
						coinCount += total / 1;
						total %= 1;
					}
				}
				System.out.println(coinCount);
			}
		}
		finally
		{
			reader.close();
		}
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
