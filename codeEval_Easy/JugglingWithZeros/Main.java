package JugglingWithZeros;

import java.io.*;

/**
 * Juggling with Zeros / Challenge 149 / Easy
 * 
 * https://www.codeeval.com/open_challenges/149/
 * 
 * @author Joe Stover
 * @version Nov 11, 2014
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
				String binary = "";
				for (int i = 0; i < parts.length; i = i + 2)
				{
					if(parts[i].equals("0"))
					{
						binary = binary + parts[i + 1];
					}
					else
					{
						for(int j = 0; j < parts[i + 1].length(); j++)
						{
							binary = binary + "1";
						}
					}
				}
				System.out.println(Long.parseLong(binary, 2));
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
