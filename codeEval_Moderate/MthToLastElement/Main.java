package MthToLastElement;

import java.io.*;

/**
 * Mth to Last Element / Challenge 10 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/10/
 * 
 * @author Joe Stover
 * @version Nov 24, 2014
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
				String[] parts = line.split(" ");
				int m = Integer.parseInt(parts[parts.length - 1]);
				if(m > parts.length - 1)
				{
					// do nothing, hit next line
				}
				else
				{
					System.out.println(parts[(parts.length - 1) - m]);
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
