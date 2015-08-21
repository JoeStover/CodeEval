package StringMask;

import java.io.*;

/**
 * String Mask / Challenge 199 / Easy
 * 
 * https://www.codeeval.com/open_challenges/199/
 * 
 * @author Joe Stover
 * @version Jun 10, 2015
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
				for(int i = 0; i < parts[0].length(); i++)
				{
					if(parts[1].charAt(i) == '1')
					{
						System.out.print(
								Character.toUpperCase(parts[0].charAt(i)));
					}
					else
					{
						System.out.print(parts[0].charAt(i));
					}
				}
				System.out.println();
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
