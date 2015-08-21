package BalancedSmileys;

import java.io.*;

/**
 * Balanced Smileys / Challenge 84 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/84/
 * 
 * @author Joe Stover
 * @version Mar 01, 2015
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
				System.out.println(isBalanced(line));
			}
		}
		finally
		{
			reader.close();
		}
	}
	/**
	 * Check if smileys in a string are balanced. 
	 * 
	 * @param line String to be checked
	 * @return true if the smileys are balanced, false otherwise
	 */
	public static String isBalanced(String line)
	{
		String balanced = "NO";
		// total potential open parens
		int min = 0;
		int max = 0;
		char[] phrase = line.toCharArray();
		for(int i = 0; i < phrase.length; i++)
		{
			// check for open paren
			if(phrase[i] == '(')
			{
				max++;
				// check on smiley potential
				if(i == 0 || phrase[i -1] != ':')
				{
					min++;
				}
			}
			// manage closed paren
			else if(phrase[i] == ')')
			{
				// if min goes negative set to 0
				min = Math.max(0,  min - 1);
				if(i == 0 || phrase[i - 1] != ':')
				{
					// reduce paren count if paired with :
					max--;
					// if max ever drops below 0 we can break out of the phrase
					if(max < 0)
					{
						break;
					}
				}
			}
		}
		// as long as max is not negative and min reduces to 0, we are good
		if(max >= 0 && min == 0)
		{
			balanced = "YES";
		}
		return balanced;
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
