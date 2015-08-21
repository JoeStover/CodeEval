package RacingChars;

import java.io.*;

/**
 * Racing Chars / Challenge 136 / Easy
 * 
 * https://www.codeeval.com/open_challenges/136/
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
			int prevIndex= -1;
			int index = -1;
			reader = generateInputReader(args);
			while((line = reader.readLine()) != null)
			{
				if(prevIndex == -1)
				{
					if(line.contains("C"))
					{
						index = line.indexOf("C");
						System.out.println(line.replace('C', '|'));
						prevIndex = index;
					}
					else
					{
						index = line.indexOf("_");
						System.out.println(line.replace('_', '|'));
						prevIndex = index;
					}
				}
				else
				{
					if(line.contains("C"))
					{
						index = line.indexOf("C");
						if(index < prevIndex)
						{
							System.out.println(line.replace('C', '/'));
						}
						else if(index == prevIndex)
						{
							System.out.println(line.replace('C', '|'));
						}
						else
						{
							System.out.println(line.replace('C', '\\'));
						}
						prevIndex = index;
					}
					else
					{
						index = line.indexOf("_");
						if(index < prevIndex)
						{
							System.out.println(line.replace('_', '/'));
						}
						else if(index == prevIndex)
						{
							System.out.println(line.replace('_', '|'));
						}
						else
						{
							System.out.println(line.replace('_', '\\'));
						}
						prevIndex = index;
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


