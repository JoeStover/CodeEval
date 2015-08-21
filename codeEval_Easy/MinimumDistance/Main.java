package MinimumDistance;

import java.io.*;
import java.util.*;

/**
 * Minimum Distance / Challenge 189 / Easy
 * 
 * https://www.codeeval.com/open_challenges/189/
 * 
 * @author Joe Stover
 * @version Mar 28, 2015
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
				int friendCount = Integer.parseInt(parts[0]);
				int[] addresses = new int[friendCount];
				// convert to a list of int addresses
				for(int i = 1; i < parts.length; i++)
				{
					addresses[i - 1] = Integer.parseInt(parts[i]);
				}
				// sort our list low to high to give range
				Arrays.sort(addresses);
				System.out.println(getMinDistanceSum(addresses));
			}
			
		}
		finally
		{
			reader.close();
		}
	}
	/**
	 * Gets the minimum sum of distances between an array of integers.
	 * 
	 * @param addresses array of house locations
	 * @return the minimum sum of distances from a specific location
	 */
	public static int getMinDistanceSum(int[] addresses)
	{
		int minAddr = addresses[0];
		int maxAddr = addresses[addresses.length - 1];
		int currAddr = minAddr;
		int minDistSum = Integer.MAX_VALUE;
		while(currAddr <= maxAddr)
		{
			int temp = 0;
			for(int addr : addresses)
			{
				temp += (Math.abs(addr - currAddr));
			}
			if(temp < minDistSum)
			{
				minDistSum = temp;
			}
			currAddr++;
		}
		return minDistSum;
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
