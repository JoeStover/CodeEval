package ArmstrongNumbers;

import java.io.*;

/**
 * Armstrong Numbers / Challenge 82 / Easy
 * 
 * https://www.codeeval.com/open_challenges/82/
 * 
 * @author Joe Stover
 * @version Nov 15, 2014
 *
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
				System.out.println(Main.isArmstrong(line));
			}	
		}
		finally
		{
			reader.close();
		}
	}
	/**
	 * "An Armstrong number is an n-digit number that is equal to the sum of 
	 * the n'th powers of its digits."
	 * 
	 * @param number to be checked
	 * @return "True" if it is, "False" otherwise
	 */
	public static String isArmstrong(String number)
	{
		int sum = 0;
		int size = number.length();
		for (int i = 0; i < number.length(); i++)
		{ 
			int value = Character.getNumericValue(number.charAt(i));
			sum = sum + (int) Math.pow(value, size);
		}
		if(sum == Integer.parseInt(number))
		{
			return "True";
		}
		else
		{
			return "False";
		}
	}
	/**
	 * Generates a BufferedReader for a file, either from passed in
	 * arguments or an input.txt file based on relation to this class.
	 * 
	 * @param args array of arguments passed to Main. If not empty, check
	 * 		  first index for an input file name.
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