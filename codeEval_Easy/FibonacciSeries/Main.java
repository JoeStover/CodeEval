package FibonacciSeries;

import java.io.*;

/**
 * Fibonacci Series / Challenge 22 / Easy
 * 
 * https://www.codeeval.com/open_challenges/22/
 * 
 * @author Joe Stover
 * @version Nov 06, 2014
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
				int input = Integer.parseInt(line);
				System.out.println(fib(input));
			}
		}
		finally
		{
			reader.close();
		}
	}
	/* standard recursive fib (which you would either want to use 
	 * dynamic programming or iteration for large numbers, 
	 * as recursion is ridiculously wasteful for this...) */
	public static int fib(int num)
	{
		if (num == 1 || num == 0)
		{
			return num;
		}
		return fib(num - 1) + fib(num - 2);
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
