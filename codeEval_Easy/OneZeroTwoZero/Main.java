package OneZeroTwoZero;

import java.io.*;
/**
 * One Zero, Two Zero / Challenge 217 / Easy
 * 
 * https://www.codeeval.com/open_challenges/217/
 * 
 * @author Joe Stover
 * @version Oct. 11, 2015
 *
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
				System.out.println(getBinaryZeroes(line));
			}	
		}
		finally
		{
			reader.close();
		}
	}
	/**
	 * Takes challenge input, which includes a count of binary zeroes and a
	 * number range (1 to n, inclusive), and determines how many numbers in that
	 * range contain the binary zero count given.
	 * 
	 * @param input String containing 2 numbers, zero count and range respectively
	 *        (e.g. 2 5)
	 * @return count of decimal numbers in the given range that contain the specific
	 *         zero count when converted to binary
	 */
	public static int getBinaryZeroes(String input)
	{
		String[] parts = input.split(" ");
		int totalZeroes = Integer.parseInt(parts[0]);
		int range = Integer.parseInt(parts[1]);
		int count = 0;
		for(int i = 1; i <= range; i++)
		{
			String binary = Integer.toBinaryString(i);
			if(binary.length() - binary.replaceAll("0", "").length() == 
					totalZeroes)
			{
				count++;
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

