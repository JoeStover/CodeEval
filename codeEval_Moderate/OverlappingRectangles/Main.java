package OverlappingRectangles;

import java.io.*;

/**
 * Overlapping Rectangles / Challenge 70 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/70/
 * 
 * @author Joe Stover
 * @version Jan 23, 2015
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
				// -3,3,-1,1,1,-1,3,-3
				// 0 - Axupperleft, 1 - Ayupperleft, 
				// 2 - Axlowerright, 3 - Aylowerright,
				// 4 - Bxupperleft, 5 - Byupperleft, 
				// 6 - Bxlowerright, 7 - Bylowerright
				String[] parts = line.split(",");
				// Rectangle 1
				int pointOneX = Integer.parseInt(parts[0]);
				int pointOneY = Integer.parseInt(parts[1]);
				int pointTwoX = Integer.parseInt(parts[2]);
				int pointTwoY = Integer.parseInt(parts[3]);
				// Rectangle 2
				int pointThreeX = Integer.parseInt(parts[4]);
				int pointThreeY = Integer.parseInt(parts[5]);
				int pointFourX = Integer.parseInt(parts[6]);
				int pointFourY = Integer.parseInt(parts[7]);
				if(pointTwoY <= pointThreeY && pointOneY >= pointFourY &&
						pointTwoX >= pointThreeX && pointOneX <= pointFourX)
				{
					System.out.println("True");
				}
				else
				{
					System.out.println("False");
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
