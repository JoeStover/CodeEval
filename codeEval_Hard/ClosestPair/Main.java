package ClosestPair;

import java.awt.Point;
import java.io.*;
import java.util.ArrayList;

/**
 * Closest Pair / Challenge 51 / Hard
 * 
 * https://www.codeeval.com/open_challenges/51/
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
			int count = Integer.parseInt(reader.readLine());
			while(count != 0)
			{
				ArrayList<Point> points = new ArrayList<Point>();
				double shortestDist = 0.0;
				for(int i = 1; i <= count; i++)
				{
					String[] parts = reader.readLine().split(" ");
					if(parts.length == 2)
					{
						points.add(new Point(Integer.parseInt(parts[0]), 
								Integer.parseInt(parts[1])));
					}
				}
				for(Point point : points)
				{
					for(int i = 0; i < points.size(); i++)
					{
						if(point.equals(points.get(i)))
						{
							// skip it, same point
						}
						else
						{
							// set the first distance if distance was 0.0
							if(shortestDist == 0.0)
							{
								shortestDist = point.distance(points.get(i));
							}
							else if(shortestDist > point.distance(points.get(i)))
							{
								shortestDist = point.distance(points.get(i));
							}
						}
					}
				}
				if (shortestDist < 100000)
				{
					System.out.printf("%.4f\n", shortestDist);
				}
				else
				{
					System.out.println("INFINITY");
				}
				count = Integer.parseInt(reader.readLine()); 
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

