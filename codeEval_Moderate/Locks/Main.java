package Locks;

import java.io.*;

/**
 * Locks / Challenge 153 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/153/
 * 
 * @author Joe Stover
 * @version Jan 15, 2015
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
				int doors = Integer.parseInt(parts[0]);
				int iterations = Integer.parseInt(parts[1]); 
				boolean[] lockedDoor = new boolean[doors]; 
				// all doors start unlocked (i.e. all lockedDoor = false)				
				for(int i = 0; i < iterations - 1; i++)
				{
					Main.passOne(lockedDoor);
					Main.passTwo(lockedDoor);
				}
				Main.lastPass(lockedDoor);
				System.out.println(Main.getUnlockedDoor(lockedDoor));
			}
		}
		finally
		{
			reader.close();
		}
	}
	/**
	 * Represents the "first pass" of the security guard. Guard starts at 
	 * beginning of corridor and locks every second door.
	 * 
	 * @param lockedDoor array representing a corridor of door locks. true if
	 *                   locked, false if unlocked.
	 */
	public static void passOne(boolean[] lockedDoor)
	{
		// start at 1, as index at 0 (2 is actually 1)
		for(int i = 1; i < lockedDoor.length; i = i + 2)
		{
			lockedDoor[i] = true; //he locks every other door
		}
	}
	/**
	 * Represents the "second pass" of the security guard. Guard starts at 
	 * beginning of corridor and changes the state of every third door to the 
	 * opposite state.
	 * 
	 * @param lockedDoor array representing a corridor of door locks. true if
	 *                   locked, false if unlocked.
	 */
	public static void passTwo(boolean[] lockedDoor)
	{
		// start at 2, as index at 0 (3 is actually 2)
		for(int i = 2; i < lockedDoor.length; i = i + 3)
		{
			lockedDoor[i] = !lockedDoor[i]; //swap lock status every 3rd door
		}
	}
	/**
	 * Represents the "last pass" of the security guard. Guard only changes the
	 * state of the last door in a row to the opposite state.
	 * 
	 * @param lockedDoor array representing a corridor of door locks. true if
	 *                   locked, false if unlocked.
	 */
	public static void lastPass(boolean[] lockedDoor)
	{
		lockedDoor[lockedDoor.length - 1] = 
				!lockedDoor[lockedDoor.length - 1]; //swap last door only
	}
	/**
	 * Gets the total count of unlocked doors in a corridor. 
	 * 
	 * @param lockedDoor array representing a corridor of door locks. true if
	 *                   locked, false if unlocked.
	 * @return           the total of unlocked doors in the corridor
	 */
	public static int getUnlockedDoor(boolean[] lockedDoor)
	{
		int result = 0;
		for(boolean locked : lockedDoor)
		{
			if(!locked) // add up all unlocked doors
			{
				result++;
			}
		}
		return result;
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
