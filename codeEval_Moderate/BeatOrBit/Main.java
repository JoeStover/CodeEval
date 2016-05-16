package BeatOrBit;

import java.io.*;

/**
 * Beat or Bit / Challenge 236 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/236/
 * 
 * @author Joe Stover
 * @version May 16, 2016
 *
 */
public class Main 
{
	/**
	 * Main method executed to solve this challenge.
	 * 
	 * @param args[0] contains input file name
	 */
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
	 * Solves the given challenge for each passed in line.
	 * 
	 * @param line input to be solved for this challenge
	 */
	public static void solveChallenge(String line)
	{
		String[] binArray = line.split("\\ \\|\\ ");
		String solution = "";
		for(String num : binArray)
		{
			solution += grayCodeToDec(num) + " | ";
		}
		System.out.println(solution.substring(0, solution.length() - 3));
	}
	/**
	 * Decodes an encrypted, gray code, binary number to decimal.
	 * 
	 * @param bin number that has been encrypted with gray code
	 * @return decimal number corresponding to encrypted gray code binary
	 */
	public static int grayCodeToDec(String bin)
	{
		int num = Integer.parseInt(bin, 2); // convert binary to useable int
		int bitMask; // mask increments by a single right shift until mask becomes 0
	    for (bitMask = num >> 1; bitMask != 0; bitMask = bitMask >> 1)
	    {
	        num = num ^ bitMask; // xor based on current mask increment
	    }
	    return num;
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
