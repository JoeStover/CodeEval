package SumToZero;

import java.io.*;

/**
 * Sum to Zero / Challenge 81 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/81/
 * 
 * @author Joe Stover
 * @version Feb 02, 2015
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
				String[] parts = line.split(",");
				int[] nums = new int[parts.length];
				for(int i = 0; i < parts.length; i++)
				{
					nums[i] = Integer.parseInt(parts[i]);
				}
				System.out.println(getWays(nums));
			}
		}
		finally
		{
			reader.close();
		}
	}
	
	/** 
	 * Gets total ways that 4 numbers in the array sum to zero.
	 * 
	 * @param numbers array of integers to check
	 * @return total ways in which the sum of 4 elements 
	 *         in this array results in zero.
	 */
	public static int getWays(int[] numbers)
	{
		int count = 0;
		// Unfortunately, need nested for's unless there is a better way that
		// I don't have time to figure out atm :)
		for(int i = 0; i < numbers.length; i++)
		{
			for(int j = i + 1; j < numbers.length; j++)
			{
				for(int k = j + 1; k < numbers.length; k++)
				{
					for(int m = k + 1; m < numbers.length; m++)
					{
						if(numbers[i] + numbers[j] + 
								numbers[k] + numbers[m] == 0)
						{
							count++;
						}
					}
				}
			}
		}
		return count;
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
