package ComparePoints;

import java.io.*;

/**
 * Compare Points / Challenge 192 / Easy
 * 
 * https://www.codeeval.com/open_challenges/192/
 * 
 * @author Joe Stover
 * @version Apr 23, 2015
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
				System.out.println(getDirection(line.split(" ")));			
			}			
		}
		finally
		{
			reader.close();
		}
	}
	public static String getDirection(String[] coords)
	{
		String direction = "";
		int hereX = Integer.parseInt(coords[0]);
		int hereY = Integer.parseInt(coords[1]);
		int thereX = Integer.parseInt(coords[2]);
		int thereY = Integer.parseInt(coords[3]);
		if(hereX == thereX && hereY == thereY)
		{
			direction = "here";
		}
		else if(hereX == thereX && hereY < thereY)
		{
			direction = "N";
		}
		else if(hereX < thereX && hereY < thereY)
		{
			direction = "NE";
		}
		else if(hereX < thereX && hereY == thereY)
		{
			direction = "E";
		}
		else if(hereX < thereX && hereY > thereY)
		{
			direction = "SE";
		}
		else if(hereX == thereX && hereY > thereY)
		{
			direction = "S";
		}
		else if(hereX > thereX && hereY > thereY)
		{
			direction = "SW";
		}
		else if(hereX > thereX && hereY == thereY)
		{
			direction = "W";
		}
		else if(hereX > thereX && hereY < thereY)
		{
			direction = "NW";
		}
		return direction;
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
