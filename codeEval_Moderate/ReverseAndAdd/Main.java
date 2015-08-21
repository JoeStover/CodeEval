package ReverseAndAdd;

import java.io.*;

/**
 * Reverse and Add / Challenge 45 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/45/
 * 
 * @author Joe Stover
 * @version Dec 17, 2014
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
				int counter = 0;
				// repeat until line is a palindrome
				while(!Main.isPalindrome(line))
				{
					// keep adding number and its reverse until it is a pali
					line = (Integer.parseInt(line) + 
								Integer.parseInt(
										Main.reverseNumber(
												line))) + "";
					// keep track of iterations
					counter++;
				}
				System.out.printf("%d %s\n", counter, line);
			}
		}
		finally
		{
			reader.close();
		}
	}
	/**
	 * Determines if passed in number is a palindrome
	 * 
	 * @param inNumber to be checked
	 * @return true if palindrome, false otherwise
	 */
	public static boolean isPalindrome(String inNumber)
	{
		if (inNumber.length() < 2)
		{
			return true;
		}
		if (inNumber.charAt(0) != inNumber.charAt(inNumber.length() - 1))
		{
			return false;
		}
		return isPalindrome(inNumber.substring(1, inNumber.length() -1));
	}
	/**
	 * Reverses a passed in number.
	 * 
	 * @param inNumber String number to be reversed
	 * @return reversed number as a String
	 */
	public static String reverseNumber(String inNumber)
	{
		StringBuffer number = new StringBuffer(inNumber + "");
		return number.reverse().toString();
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
