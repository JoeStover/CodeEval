package CalculateDistance;

import java.io.*;

/**
 * Calculate Distance / Challenge 99 / Easy
 * 
 * https://www.codeeval.com/open_challenges/99/
 * 
 * @author Joe Stover
 * @version Nov 12, 2014
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
				String[] coords = line.substring(1, line.length() - 1).split("\\) \\(");
				String[] pointOne = coords[0].split(", ");
				String[] pointTwo = coords[1].split(", ");
				int x1 = Integer.parseInt(pointOne[0]);
				int y1 = Integer.parseInt(pointOne[1]);
				int x2 = Integer.parseInt(pointTwo[0]);
				int y2 = Integer.parseInt(pointTwo[1]);
				int distance = (int) Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1) , 2));
				System.out.println(distance);
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