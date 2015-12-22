package Testing;

import java.io.*;

/**
 * Testing / Challenge 225 / Easy
 * 
 * https://www.codeeval.com/open_challenges/225/
 * 
 * @author Joe Stover
 * @version Dec 22, 2015
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
				System.out.println(solveChallenge(line));
			}
		}
		finally
		{
			reader.close();
		}		
	}
	/**
	 * Takes in a line of input and outputs solution.
	 * 
	 * @param line from input.txt to be parsed
	 * @return solution for that line of data
	 */
	public static String solveChallenge(String line)
	{
		String[] parts = line.split("\\s\\|\\s");
		return getPriority(
				getBugCount(parts[0].toCharArray(), parts[1].toCharArray()));
	}
	/**
	 * Gets the bug count by comparing two char arrays.
	 * 
	 * @param s1 char array representing the developer string
	 * @param s2 char array representing the design string
	 * @return integer representing number of differences between the 2 inputs
	 */
	public static int getBugCount(char[] s1, char[]s2)
	{
		int bugCount = 0;
		for(int i = 0; i < s1.length; i++)
		{
			if(s1[i] != s2[i])
			{
				bugCount++;
			}
		}
		return bugCount;
	}
	/**
	 * Returns the priority for a specific bug count.
	 * 
	 * @param bugCount int count of total bugs for a line
	 * @return String representation of the bug counts priority
	 */
	public static String getPriority(int bugCount)
	{
		String priority = "";
		if(bugCount == 0)
		{
			priority = "Done";
		}
		else if(bugCount <= 2)
		{
			priority = "Low";
		}
		else if(bugCount <= 4)
		{
			priority = "Medium";
		}
		else if(bugCount <= 6)
		{
			priority = "High";
		}
		else if(bugCount > 6)
		{
			priority = "Critical";
		}
		return priority;
	}
	/**
	 * Generates a BufferedReader for a file, either from passed in
	 * arguments or an input.txt file based on relation to this class.
	 * 
	 * @param args array of arguments passed to Main. If not empty, check
	 * 		  first index for an input file name.
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
