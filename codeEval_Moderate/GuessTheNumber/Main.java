package GuessTheNumber;

import java.io.*;

/**
 * Guess the Number / Challenge 170 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/170/
 * 
 * @author Joe Stover
 * @version Nov 27, 2014
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
				/* 100 Lower Lower Higher Lower Lower Lower Yay!  : answer 13 */
				String[] parts = line.split(" ");
				double limit = Integer.parseInt(parts[0]);
				double floor = 0;
				double answer = Math.ceil(limit / 2);
				for(int i = 1; i < parts.length - 1; i++)
				{
					if(parts[i].equals("Lower"))
					{
						limit = answer - 1;
					}
					else if(parts[i].equals("Higher"))
					{
						floor = answer + 1;
					}
					answer = (int) Math.ceil((limit + floor) /2);
				}
				System.out.println((int) answer);
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
