package RoadTrip;

import java.io.*;
import java.util.*;

/**
 * Road Trip / Challenge 124 / Easy
 * 
 * https://www.codeeval.com/open_challenges/124/
 * 
 * @author Joe Stover
 * @version Nov 19, 2014
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
				ArrayList<Integer> distances = new ArrayList<Integer>();
				String[] parts = 
						line.substring(0, line.length() - 1).split("\\; ");
				for(String part : parts)
				{
					int temp = Integer.parseInt(part.split(",")[1]);
					distances.add(temp);
				}
				Collections.sort(distances);
				System.out.print(distances.get(0) + ",");
				for(int i = 1; i < distances.size(); i++)
				{
					if(i < distances.size() - 1)
					{
						System.out.print((distances.get(i) - 
								distances.get(i - 1)) + ",");
					}
					else
					{
						System.out.println(distances.get(i) - 
								distances.get(i - 1));
					}
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
