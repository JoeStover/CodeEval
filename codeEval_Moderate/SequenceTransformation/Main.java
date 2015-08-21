package SequenceTransformation;

import java.io.*;

/**
 * Sequence Transformation / Challenge 130 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/130/
 * 
 * @author Joe Stover
 * @version Feb 08, 2015
 * 
 * 1. "0" can be transformed into non empty sequence of letters "A" ("A", "AA", "AAA" etc.) 
 * 2. "1" can be transformed into non empty sequence of letters "A" ("A", "AA", "AAA" etc.) 
 *     or to non empty sequence of letters "B" ("B", "BB", "BBB" etc) e.g.
 *     
 * TODO: Tried the obvious solution first (regex) which, as expected, timed out
 *       on longer test inputs.
 *       
 *       Need to come up with a DP solution that works backwards from the premise
 *       that the "AB" parameter can only be bound by a finite number of regex patterns
 *       from the first parameter(1's and 0's).
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
				String[] parts = line.split(" ");
				String binary = parts[0];
				String letters = parts[1];
				System.out.println(validate(binary, letters));
			}
		}
		finally
		{
			reader.close();
		}
	}
	/*TODO: Need to complete this*/
	public static String validate(String bin, String let)
	{
		String isPossible = "Yes";
		
		return isPossible;
	}
	/*TODO: Need to complete this*/
	public static String[][] allPossibleBins(String let)
	{
		String[][] bins = new String[let.length()][let.length()];
		
		return bins;
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


