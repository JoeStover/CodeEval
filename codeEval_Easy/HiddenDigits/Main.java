package HiddenDigits;

import java.io.*;
import java.util.*;

/**
 * Hidden Digits / Challenge 122 / Easy
 * 
 * https://www.codeeval.com/open_challenges/122/
 * 
 * @author Joe Stover
 * @version Nov 12, 2014
 */
public class Main 
{
	public static void main(String[] args) throws IOException
	{
		// load a map of character -> numbers for finding digits
		HashMap<Character, Integer> digits = new HashMap<Character, Integer>();
		String letters = "abcdefghij";
		for (int i = 0; i < letters.length(); i++)
		{
			digits.put(letters.charAt(i), i);
		}
		BufferedReader reader = null;
		String line = null;
		try
		{
			reader = generateInputReader(args);
			while((line = reader.readLine()) != null)
			{
				String answer = "";
				for(int i = 0; i < line.length(); i++)
				{
					if(digits.get(line.charAt(i)) != null)
					{
						answer += digits.get(line.charAt(i));
					}
					else if(Character.isDigit(line.charAt(i)))
					{
						answer += line.charAt(i);
					}
				}
				if(answer.isEmpty())
				{
					System.out.println("NONE");
				}
				else
				{
					System.out.println(answer);
				}
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