package PredictTheNumber;

import java.io.*;

/**
 * Predict the Number / Challenge 125 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/125/
 * 
 * "The sequence "011212201220200112 ..." is constructed as follows:
 *  first goes 0, and then the following action is repeated: 
 *  existing part is added to the right, but 0 is replaced with 1, 1 with 2, 
 *  and 2 with 0.
 *  
 *  Example:
 *      0 -> 01 -> 0112 -> 01121220 -> ...
 *      
 *  Determine nth position in sequence."
 * 
 * @author Joe Stover
 * @version Jan 24, 2015
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
				String seq = "0";
				long n = Long.parseLong(line);
				String binary = Long.toBinaryString(n);
				int count = 0;
				for(int i = 0; i < binary.length(); i++)
				{
					if(binary.substring(i, i + 1).equals("1"))
					{
						count++;
					}
				}
				System.out.println(count % 3);
			}
		}
		finally
		{
			reader.close();
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