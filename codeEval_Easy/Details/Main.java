package Details;

import java.io.*;

/**
 * Details / Challenge 183 / Easy
 * 
 * https://www.codeeval.com/open_challenges/183/
 * 
 * @author Joe Stover
 * @version Feb 14, 2015
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
				String[] rows = line.split(",");
				int moves = Integer.MAX_VALUE; // look for smaller moves
				for(String row : rows)
				{
					// make sure we don't have a "touch" first
					if(row.contains("XY"))
					{
						moves = 0;
					}
					else
					{
						// count "." by getting diff in lengths if removed
						int count = row.length() - row.replace(".", "").length();
						if(count < moves)
						{
							moves = count;
						}
					}
				}	
				System.out.println(moves);
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
