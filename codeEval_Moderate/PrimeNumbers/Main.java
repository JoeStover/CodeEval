package PrimeNumbers;

import java.io.*;

/**
 * Prime Numbers / Challenge 46 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/46/
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
				String answer = "";
				int limit = Integer.parseInt(line);
				for(int i = 2; i < limit; i++)
				{
					if(Main.isPrime(i))
					{
						answer = answer + i + ",";
					}
				}
				System.out.println(answer.substring(0, answer.length() - 1));
			}
		}
		finally
		{
			reader.close();
		}
	}
	/**
	 * Determines if a given number is prime.
	 * 
	 * @param num to be checked
	 * @return true if prime, false otherwise
	 */
	public static boolean isPrime(int num)
	{
		for(int i = 2; i <= num/2; i++)
		{
			if(num % i == 0)
			{
				return false;
			}
		}
		return true;
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
