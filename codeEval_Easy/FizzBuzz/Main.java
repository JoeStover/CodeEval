package FizzBuzz;

import java.io.*;

/**
 * Fizz Buzz / Challenge 1 / Easy
 * 
 * https://www.codeeval.com/open_challenges/1/
 * 
 * @author Joe Stover
 * @version Nov 08, 2014
 */
public class Main 
{	
	public static void main (String[] args) throws IOException
	{
		BufferedReader reader = null;
		String line = null;
		try
		{
			reader = generateInputReader(args);
			while((line = reader.readLine()) != null)
			{
				String[] parts = line.split("\\s");
				int x = Integer.parseInt(parts[0]);
				int y = Integer.parseInt(parts[1]);
				int count = Integer.parseInt(parts[2]);
				String answer = "";				
				for (int i = 1; i <= count; i++)
				{
					if ((i % x == 0) && (i % y == 0))
					{
						answer = answer + "FB ";
					}
					else if (i % x == 0)
					{
						answer = answer + "F ";
					}
					else if(i % y == 0)
					{
						answer = answer + "B ";
					}
					else
					{
						answer = answer + i + " ";
					}
				}
				System.out.println(answer);
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
