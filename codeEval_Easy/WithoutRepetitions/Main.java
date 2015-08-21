package WithoutRepetitions;

import java.io.*;

/**
 * Without Repetitions / Challenge 173 / Easy
 * 
 * https://www.codeeval.com/open_challenges/173/
 * 
 * @author Joe Stover
 * @version Dec 08, 2014
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
				StringBuilder temp = new StringBuilder(line);
				for(int i = 1; i < temp.length(); i++)
				{
					char first = temp.charAt(i - 1);
					char second = temp.charAt(i);
					if(first == second)
					{
						temp.deleteCharAt(i - 1);
						i--;  // back up 1 if delete to prevent skipping too far
					}
				}
				System.out.println(temp);
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
