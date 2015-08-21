package CountingPrimes;

import java.io.*;

/**
 * Counting Primes / Challenge 63 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/63/
 * 
 * @author Joe Stover
 * @version Nov 24, 2014
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
				int count = 0;
				String[] parts = line.split(",");
				for(int i = Integer.parseInt(parts[0]); 
						i <= Integer.parseInt(parts[1]); i++)
				{
					if(Main.isPrime(i))
					{
						count++;
					}
				}
				System.out.println(count);
			}
		}
		finally
		{
			reader.close();
		}
	}
	/**
	 * Verifies if a number is prime.
	 * 
	 * @param num to be checked
	 * @return true if input is prime, false otherwise
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
