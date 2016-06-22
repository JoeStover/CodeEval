package MeetCocktailSort;

import java.io.*;

/**
 * Meet Cocktail Sort / Challenge 231 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/231/
 * 
 * @author Joe Stover
 * @version June 13, 2016
 */
public class Main 
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader= null;
		String line = null;
		try
		{
			reader= generateInputReader(args);
			while((line = reader.readLine()) != null)
			{
				System.out.println(solve(line));
			}
		}
		finally
		{
			reader.close();
		}
	}
	/**
	 * Gets the solution for this challenge based on line input.
	 * 
	 * @param line String to be solved based on challenge rules
	 * @return solution as a String
	 */
	public static String solve(String line)
	{
		String answer = "";
		String[] parts = line.split("\\ \\|\\ ");
		String[] array = parts[0].split(" ");
		int passes = Integer.parseInt(parts[1]);
		cocktailSort(array, passes);
		for(String num : array)
		{
			answer += num + " ";
		}
		return answer.trim();
	}
	/**
	 * Performs cocktail sort for a given number of iterations.
	 * 
	 * Cocktail sort is just a bubblesort that traverses both 
	 * directions of an array. One iteration moves each direction
	 * once and then shortens the array on either side by one.
	 * 
	 * @param array to be cocktail sorted
	 * @param passes number of passes to perform sort
	*/
	public static void cocktailSort(String[] array, int passes)
	{
		int start = 0;
		int end = array.length - 1;
		for(int pass = 0; pass < passes; pass++)
		{
			// sort forward
			for(int i = start + 1; i <= end; i++)
			{
				if(Integer.parseInt(array[i - 1]) > Integer.parseInt(array[i]))
				{
					swap(array, i - 1, i);
				}
			}
			// sort rewind
			for(int i = end - 2; i >= 0; i--)
			{
				if(Integer.parseInt(array[i]) > Integer.parseInt(array[i + 1]))
				{
					swap(array, i, i + 1);
				}
			}
			// shorten list for next iteration
			start++;
			end--;
		}
	}
	/**
	 * Swaps positions of 2 objects/primitives in an array.
	 *  
	 * @param array where swapping will occur
	 * @param i index of first item
	 * @param j index of second item
	 */
	public static void swap(String[] array, int i, int j)
	{
		String temp = array[i];
		array[i] = array[j];
		array[j] = temp;
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
