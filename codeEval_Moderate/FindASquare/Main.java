package FindASquare;

import java.awt.Point;
import java.io.*;
import java.util.HashSet;

/**
 * Find a Square / Challenge 101 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/101/
 * 
 * @author Joe Stover
 * @version Nov 30, 2014
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
				/*
				   - e.g. (1,6), (6,7), (2,7), (9,1)
				*/
				// 1st point
				Point x1y1 = new Point
						(Character.getNumericValue(line.charAt(1)), 
								Character.getNumericValue(line.charAt(3)));
				// 2nd point
				Point x2y2 = new Point
						(Character.getNumericValue(line.charAt(8)), 
								Character.getNumericValue(line.charAt(10)));
				// 3rd point
				Point x3y3 = new Point
						(Character.getNumericValue(line.charAt(15)), 
								Character.getNumericValue(line.charAt(17)));
				// 4th point
				Point x4y4 = new Point
						(Character.getNumericValue(line.charAt(22)), 
								Character.getNumericValue(line.charAt(24)));
				// set used to verify number of equal distances
				HashSet<Double> set = new HashSet<Double>();
				set.add(x1y1.distance(x2y2));
				set.add(x1y1.distance(x3y3));
				set.add(x1y1.distance(x4y4));
				set.add(x2y2.distance(x3y3));
				set.add(x2y2.distance(x4y4));
				set.add(x3y3.distance(x4y4));
				if(set.size() == 2)
				{
					System.out.println("true");
				}
				else
				{
					// more than 2 distances
					System.out.println("false");
				}
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
