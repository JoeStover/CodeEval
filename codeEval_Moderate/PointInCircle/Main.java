package PointInCircle;

import java.io.*;

/**
 * Point in Circle / Challenge 98 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/98/
 * 
 * @author Joe Stover
 * @version Jan 26, 2015
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
				// clean up the line so we only have values left
				line = line.replace("Center: (", "");
				line = line.replace("); Radius:", ",");
				line = line.replace("; Point: (", ", ");
				line = line.replace(")", "");
				// split line up to get the doubles
				String[] values = line.split(", ");
				double centerX = Double.parseDouble(values[0]);
				double centerY = Double.parseDouble(values[1]);
				double radius = Double.parseDouble(values[2]);
				double pointX = Double.parseDouble(values[3]);
				double pointY = Double.parseDouble(values[4]);
				// return if point is in circle
				System.out.println(
						(Math.pow((pointX - centerX), 2)) + 
							(Math.pow((pointY - centerY), 2)) < 
								(Math.pow(radius, 2)));
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
