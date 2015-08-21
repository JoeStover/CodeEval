package StringsAndArrows;

import java.io.*;

/**
 * Strings and Arrows / Challenge 203 / Easy
 * 
 * https://www.codeeval.com/open_challenges/203/
 * 
 * @author Joe Stover
 * @version Jul 03, 2015
 */
public class Main 
{
	// set some constants to prevent "magic" arrows ;-)
	public static final String LEFT_ARROW = "<--<<";
	public static final String RIGHT_ARROW = ">>-->";
	public static final int ARROW_LENGTH = 5;
	
	public static void main(String[] args) throws IOException 
	{
		BufferedReader reader = null;
		String line = null;
		try
		{
			reader = generateInputReader(args);
			while((line = reader.readLine()) != null)
			{
				int arrowCount = 0;
				for(int i = 0; i < line.length() - 4; i++)
				{
					String temp = line.substring(i, i + ARROW_LENGTH);
					if(temp.equals(LEFT_ARROW) || temp.equals(RIGHT_ARROW))
					{
						arrowCount++;
					}
				}
				System.out.println(arrowCount);
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

