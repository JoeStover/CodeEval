package NotSoClever;

import java.io.*;
import java.util.*;

/**
 * Not So Clever / Challenge 232 / Easy
 * 
 * https://www.codeeval.com/open_challenges/232/
 * 
 * @author Joe Stover
 * @version Feb 21, 2013
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
	public static void solveChallenge(String input)
	{
		String[] parts = input.split("\\ \\|\\ ");
		String[] array = parts[0].split(" ");
		int iterCount = Integer.parseInt(parts[1]);
		stupidSort(array, iterCount);
		String solution = Arrays.toString(array).replace(",", "");
		System.out.println(solution.substring(1, solution.length() - 1));	
	}
	/**
	 * Calls stupid sort for the specified iterations.
	 * 
	 * @param array     array to be sorted
	 * @param iterCount number of passes to be made by stupid sort
	 */
	public static void stupidSort(String[] array, int iterCount)
	{
		for(int i = 1; i <= iterCount; i++)
		{
			stupidSort(array);
		}
	}
	/**
	 * Makes a single pass of "stupid sort" (an even more stupid version of
	 * a bubble sort).
	 * 
	 * @param array that is to be sorted
	 */
	public static void stupidSort(String[] array)
	{
		boolean hasSwapped = false;
		for(int i = 1; i <= array.length && !hasSwapped; i++)
		{
			if(Integer.parseInt(array[i - 1]) > Integer.parseInt(array[i]))
			{
				String temp = array[i - 1];
				array[i - 1] = array[i];
				array[i] = temp;
				hasSwapped = true;
			}
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
