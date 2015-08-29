package ChardonnayOrCabernet;

import java.io.*;

/**
 * Chardonnay or Cabernet / Challenge 211 / Easy
 * 
 * https://www.codeeval.com/open_challenges/211/
 * 
 * @author Joe Stover
 * @version Aug 28, 2015
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
				String[] parts = line.split("\\s\\|\\s");
				System.out.println(findWine(parts[0].split(" "), parts[1]));
			}
		}
		finally
		{
			reader.close();
		}
	}	
	/**
	 * Finds and returns a String of all wines in a list of wines that 
	 * contain all letters in a string that are being guessed. 
	 * Letters can be in any order in the wine name and still "match" the 
	 * pattern. 
	 * 
	 * @param wineList array of potential wines to match
	 * @param guess    String pattern to match against
	 * @return         String containing each wine that matches the guess, 
	 *                 "False" if no match exists
	 */
	public static String findWine(String[] wineList, String guess)
	{
		String answer = "";
		for(String wine : wineList)
		{
			if(findWine(wine, guess))
			{
				answer += wine + " ";
			}
		}
		return (answer.isEmpty()) ? "False" : answer.trim();
	}
	/**
	 * Compares a potential wine name to a string of letters that are "guessed"
	 * to be in that name. Letters can be in any order in the wine name and 
	 * still "match" the pattern. 
	 * 
	 * @param wine   String name of the wine to match
	 * @param guess  String pattern to match against
	 * @return       true if wine contains all letters, false otherwise
	 */
	public static boolean findWine(String wine, String guess)
	{
		// base case where all letters in guess have been used
		if(guess.isEmpty())
		{
			return true;
		}
		// check if the first letter in guess is in the wine name
		if(wine.contains(guess.substring(0, 1)))
		{
			// reduce each param by found letter and recurse
			return findWine(wine.replaceFirst(guess.substring(0, 1),
					""), guess.substring(1));
		}
		// return if it is found that a letter in guess is not contained in wine
		return false;
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
