package BlackCard;

import java.io.*;
import java.util.*;

/**
 * Black Card / Challenge 222 / Easy
 * 
 * https://www.codeeval.com/open_challenges/222/
 * 
 * @author Joe Stover
 * @version Nov 15, 2015
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
				solveChallenge(line);
			}	
		}
		finally
		{
			reader.close();
		}
	}
	/**
	 * Solves the given challenge based on given input.
	 * 
	 * @param line as a String extracted from a given file
	 */
	public static void solveChallenge(String line)
	{
		String[] parts = line.split("\\ \\|\\ ");
		ArrayList<String> players = 
				new ArrayList<String>(Arrays.asList(parts[0].split(" ")));
		int blackSpot = Integer.parseInt(parts[1]) - 1;
		while(players.size() > 1)
		{
			players.remove(blackSpot % players.size());
		}
		System.out.println(players.get(0));
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

