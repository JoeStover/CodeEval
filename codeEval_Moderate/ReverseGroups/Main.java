package ReverseGroups;

import java.io.*;
import java.util.Arrays;

/**
 * Reverse Groups / Challenge 71 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/71/
 * 
 * @author Joe Stover
 * @version Jan 22, 2015
 */
public class Main 
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader reader = null;
		String line = null;
		try
		{
			reader = generateInputReader(args);
			while((line = reader.readLine()) != null)
			{
				String[] parts = line.split(";");
				int k = Integer.parseInt(parts[1]);
				String[] groups = parts[0].split(",");
				Main.reverseByGroup(groups, k);
				String answer = Arrays.toString(groups);
				System.out.println(answer.substring
							(1, answer.length() - 1).replace(" ", ""));
			}
		}
		finally
		{
			reader.close();
		}
	}
	/** 
	 * Reverses the values of an array, k items at a time.
	 * 
	 * @param groups the array to be reversed
	 * @param k      number of items in the array to reverse at a time
	 */
	public static void reverseByGroup(String[] groups, int k)
	{
		for(int i = 0; (i + k) - 1 < groups.length; i += k)
		{
			for(int j = 0; j < k / 2; j++)
			{
				String temp = groups[i + j];
				groups[i + j] = groups[(i + k - j) - 1];
				groups[(i + k - j) - 1] = temp;
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