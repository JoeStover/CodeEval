package RollerCoaster;

import java.io.*;

/**
 * Roller Coaster / Challenge 156 / Easy
 * 
 * https://www.codeeval.com/open_challenges/156/
 * 
 * @author Joe Stover
 * @version Nov 06, 2014
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
				boolean isUp = true;
				for (int i = 0; i < line.length(); i++)
				{
					if(Character.isLetter(line.charAt(i)))
					{
						if(isUp)
						{
							System.out.print(Character.toUpperCase(line.charAt(i)));
							isUp = false;
						}
						else
						{
							System.out.print(Character.toLowerCase(line.charAt(i)));
							isUp = true;
						}
					}
					else
					{
						System.out.print(line.charAt(i));
					}
				}
				System.out.println("");
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
