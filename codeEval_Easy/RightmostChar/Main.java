package RightmostChar;

import java.io.*;

/**
 * Rightmost Char / Challenge 31 / Easy
 * 
 * https://www.codeeval.com/open_challenges/31/
 * 
 * @author Joe Stover
 * @version Nov 12, 2014
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
				int position = -1;
				String[] parts = line.split(",");
				for(int i = 0; i < parts[0].length(); i++)
				{
					if(parts[0].charAt(i) == parts[1].charAt(0))
					{
						position = i;
					}
				}
				System.out.println(position);
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
