package WordSearch;

import java.io.*;
import java.util.*;

/**
 * Word Search / Challenge 65 / Hard
 * 
 * https://www.codeeval.com/open_challenges/65/
 * 
 * @author Joe Stover
 * @version Aug. 17, 2015
 * 
 * TODO: Need to complete actual logic and add to CodeEval for evaluation.
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
				
			}
		}
		finally
		{
			reader.close();
		}
	}
	
	/**
	 * Builds a new, hard coded grid based on the challenge description.
	 *  
	 * @return a matrix of hard coded tiles that default to "unused".
	 */
	public static Tile[][] buildGrid()
	{
		Tile[][] grid = 
			{{new Tile('A'), new Tile('B'), new Tile('C'), new Tile('E')},
			{new Tile('S'), new Tile('F'), new Tile('C'), new Tile('S')},
			{new Tile('A'), new Tile('D'), new Tile('E'), new Tile('E')}};
		
		return grid;
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
	/**
	 * Represents Grid tiles. A tile has a character value and is either
	 * used or unused during a search.
	 */
	static class Tile
	{
		// would set to private and encapsulate if this was more than a challenge
		char value;
		boolean isUsed;
		/**
		 * Constructor for Tile class.
		 * 
		 * @param inValue the char value of this tile
		 */
		public Tile(char inValue)
		{
			this.value = inValue;
			// a new tile starts out unused
			this.isUsed = false;
		}
	}
}
