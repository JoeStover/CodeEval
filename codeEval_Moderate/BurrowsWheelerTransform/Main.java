package BurrowsWheelerTransform;

import java.io.*;
import java.util.*;

/**
 * Burrows-Wheeler Transform / Challenge 184 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/184/
 * 
 * @author Joe Stover
 * @version Aug 16, 2015
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
				// strip line of EOL pipe
				line = line.substring(0, line.length() - 1);
				System.out.println(inverseBWT(line));
			}
		}
		finally
		{ 
			reader.close();
		}
	}	
	/**
	 * Recreates original text that has been compressed using the Burrows-Wheeler
	 * Transform algorithm.
	 * 
	 * Algorithm is slightly converted version of the pseudo-code and explanation
	 * found here: https://en.wikipedia.org/wiki/Burrows%E2%80%93Wheeler_transform
	 * 
	 * @param line containing compressed text
	 * @return the inverse of the transformed String input
	 */
	public static String inverseBWT(String line)
	{
		String inverted = "";
		// contains the compressed line we want to add to in order to invert
		char[] compressed = line.toCharArray();
		// create an array of strings to build the solution on
		String[] inverse = new String[line.length()];
		for(int i = 0; i < inverse.length; i++)
		{
			// fill with empties to initialize strings
			inverse[i] = "";
		}
		// repeat steps for length of the compressed string
		for(int step = 0; step < line.length(); step++)
		{
			// step 1) add original, compressed part to beginning of our arrays
			for(int i = 0; i < inverse.length; i++)
			{
				inverse[i] = compressed[i] + inverse[i];
			}
			// step 2) sort
			Arrays.sort(inverse);
		}
		for(String temp : inverse)
		{
			// answer has the EOF char at the end
			if(temp.charAt(temp.length() - 1) == '$')
			{
				inverted = temp;
			}
		}
		return inverted;
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
