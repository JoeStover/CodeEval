package HappyNumbers;

import java.io.*;

/**
 * Happy Numbers / Challenge 39 / Easy
 * 
 * https://www.codeeval.com/open_challenges/39/
 * 
 * @author Joe Stover
 * @version Nov 15, 2014
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
				System.out.println(Main.getHappiness(line));
			}	
		}
		finally
		{
			reader.close();
		}
	}
	/**
	 * Returns the happiness of a number based on rules specified in the 
	 * challenge description.
	 * 
	 * @param number the number being checked for "happiness"
	 * @return 1 if the number is "happy", 0 otherwise
	 */
	public static int getHappiness(String number)
	{
		int sum = 0;
		int counter = 20;
		String temp = number;
		while(counter > 0)
		{
			for(int i = 0; i < temp.length(); i++)
			{
				sum = (int) (sum + Math.pow(Character.getNumericValue
						(temp.charAt(i)), 2));
			}
			if(sum == 1)
			{
				return sum;
			}
			temp = sum + "";
			sum = 0;
			counter--;
		}
		return sum;
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
