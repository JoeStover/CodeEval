package TrickOrTreat;

import java.io.*;
import java.util.*;

/**
 * Trick or Treat/ Challenge 220 / Easy
 * 
 * https://www.codeeval.com/open_challenges/220/
 * 
 * @author Joe Stover
 * @version Oct 30, 2015
 *
 */
public class Main 
{
	// container to hold values
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
		String[] parts = line.split(",\\ ");
		int totalKids = 0;
		int houses = 0;
		int totalCandies = 0;
		for(String part : parts)
		{
			String[] data = part.split(":\\ ");
			int num = Integer.parseInt(data[1]);
			if(data[0].equals("Vampires"))
			{
				totalCandies += 3 * num;
				totalKids += num;
			}
			else if(data[0].equals("Zombies"))
			{
				totalCandies += 4 * num;
				totalKids += num;
			}
			else if(data[0].equals("Witches"))
			{
				totalCandies += 5 * num;
				totalKids += num;
			}
			else if(data[0].equals("Houses"))
			{
				houses = num;
			}
		}
		totalCandies *= houses;
		System.out.println((int)(Math.floor(totalCandies / totalKids)));
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

