package MultiplesOfANumber;

import java.io.*;

/**
 * Multiples of a Number / Challenge 116 / Easy
 * 
 * https://www.codeeval.com/open_challenges/116/
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
				String[] parts = line.split(",");
				int x = Integer.parseInt(parts[0]);
				int n = Integer.parseInt(parts[1]);
				int i = 1;
				boolean hasNoAnswer = true;
				while (hasNoAnswer)
				{
					if (x <= n * i)
					{
						System.out.println(n * i);
						hasNoAnswer = false;
					}
					else
					{
						i++;
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
