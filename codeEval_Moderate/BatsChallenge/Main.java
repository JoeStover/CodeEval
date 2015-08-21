package BatsChallenge;

import java.io.*;
import java.util.*;

/**
 * Bats Challenge / Challenge 146 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/146/
 * 
 * @author Joe Stover
 * @version Feb 07, 2015
 */
public class Main 
{
	// bat can only hang 6cm from a building
	public static final int LIMIT = 6;
	
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
				int length = Integer.parseInt(parts[0]); // wire length
				int dist = Integer.parseInt(parts[1]); // distance bats like to keep between them
				int initBats = Integer.parseInt(parts[2]); // bats already on wire
				Stack<Integer> batPositions = new Stack<Integer>();
				// if there were bats already on line, load their positions from
				// the left over parts array
				if(initBats > 0)
				{
					// feed the leftover ints from parts (which are the bat positions
					for(int i = initBats + 2; i > 2; i--)
					{
						batPositions.push(Integer.parseInt(parts[i]));
					}
				}
				int spot = LIMIT; // first avail apot
				int moreBats = 0; // amt of bats we will add if room available
				int leftLimit = LIMIT; // left wall
				int rightLimit = length - LIMIT; // right wall
				if(!batPositions.empty())
				{
					// 1) set a previous bat to keep track of
					// 2) initially set to LIMIT - dist 
					//    so we can put in first position if empty
					int prevBat =  leftLimit - dist;
					while(!batPositions.empty())
					{
						while(spot <= batPositions.peek() - dist)
						{
							// make sure we didn't start on an existing bat
							if(spot == prevBat + dist)
							{
								// place bat
								moreBats++;
								prevBat = spot;
								spot += dist;
							}
							else
							{
								spot = prevBat + dist;
							}								
						}
						// if we break from the while, pop another bat
						prevBat = batPositions.pop();
					}
					while(spot <= rightLimit)
					{
						if(spot == prevBat + dist)
						{
							moreBats++;
							prevBat = spot;
							spot += dist;
						}
						else
						{
							spot = prevBat + dist;
						}
					}
				}
				else
				{
					while(spot <= length - LIMIT)
					{
						moreBats++;
						spot += dist;
					}
				}
				System.out.println(moreBats);
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
