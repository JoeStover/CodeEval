package TrailingString;

import java.io.*;

/**
 * Trailing String / Challenge 32 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/32/
 * 
 * @author Joe Stover
 * @version Jan 13, 2015
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
				if(!line.isEmpty())
				{
					String[] parts = line.split(",");
					// break the sentence and phrase into char arrays so they
					// are easier to work with when comparing
					char[] partA = parts[0].toCharArray();
					char[] partB = parts[1].toCharArray();
					System.out.println(Main.isTrailing(partA, partB));
				}
			}
		}
		finally
		{
			reader.close();
		}
	}
	/**
	 * Takes a sentence and phrase (in char array form) and checks if
	 * the phrase occurs at the end of the sentence.
	 * 
	 * @param sentence full sentence to check against
	 * @param phrase that we want to verify ends the sentence
	 * @return 1 if the phrase is the trailing string in the sentence, 0 otherwise
	 */
	public static int isTrailing(char[] sentence, char[] phrase)
	{
		// assume true until not
		int hasMatch = 1;
		// if the phrase is longer than the sentence, it def can't trail it...
		if(phrase.length > sentence.length)
		{
			hasMatch = 0;
		}
		else
		{
			// work backwards until you are through phrase or prove it doesn't
			// match
			for(int i = 1; i <= phrase.length && hasMatch == 1; i++)
			{
				if(sentence[sentence.length - i] != phrase[phrase.length - i])
				{
					hasMatch = 0;
				}
			}
		}		
		return hasMatch;
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
