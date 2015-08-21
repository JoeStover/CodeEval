package ReadMore;

import java.io.*;

/**
 * Read More / Challenge 167 / Easy
 * 
 * https://www.codeeval.com/open_challenges/167/
 * 
 * @author Joe Stover
 * @version Nov 05, 2014
 */
public class Main 
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader reader = null;
		String line = null;
		try
		{
			reader = generateInputReader(args);
			while((line = reader.readLine()) != null)
			{
			if(line.length() > 55)
			{
				String trimmed = line.substring(0, 40);
				if (trimmed.contains(" "))
				{
					int lastSpace = trimmed.lastIndexOf(" ");
					trimmed = line.substring(0, lastSpace);
				}
				System.out.println(trimmed.trim() + "... <Read More>");
			}
			else
			{
				System.out.println(line);
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
