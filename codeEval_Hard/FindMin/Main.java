package FindMin;

import java.io.*;
import java.util.*;

/**
 * Find Min / Challenge 85 / Hard
 * 
 * https://www.codeeval.com/open_challenges/85/
 * 
 * @author Joe Stover
 * @version Sept 18, 2015
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
				System.out.println(findMin(line));
			}
		}
		finally
		{
			reader.close();
		}
	}
	
	/**
	 * Given the first k values of m, calculates the nth value of the array.
	 * 
	 * "Given positive integers a, b, c and r, the known values of m can be 
	 *  calculated as follows: 
     *  	m[0] = a 
	 *		m = (b * m[i - 1] + c) % r, 0 < i < k "
	 *
	 * @param line representing the 6 positive ints above (n,k,a,b,c,r)
	 * @return nth element of m
	 */
	public static int findMin(String line)
	{
		String[] input = line.split(",");
		// fill variables from the problem statement
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		int a = Integer.parseInt(input[2]);
		int b = Integer.parseInt(input[3]);
		int c = Integer.parseInt(input[4]);
		int r = Integer.parseInt(input[5]);
		// gather values through k
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(a);
		for(int i = 1; i < k; i++)
		{
			// use given equation to build out array
			nums.add((b * nums.get(nums.size() - 1) + c) % r);
		}
		// According to problem statement:
		// for each index i, where k <= i < n, m is the minimum non-negative 
		// integer which is *not* contained in the previous *k* values of m. 
		for(int i = k; i < n; i++)
		{
			int value = 0;
			boolean done = false;
			while(!done)
			{
				if(nums.subList(nums.size() - k, nums.size()).contains(value))
				{
					// if value is in the subset, increment it til it isn't
					value++;
				}
				else
				{
					done = true;
				}
			}
			nums.add(value);
		}
		return nums.get(nums.size() - 1);
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