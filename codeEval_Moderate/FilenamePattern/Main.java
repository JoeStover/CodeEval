package FilenamePattern;

import java.io.*;
import java.util.ArrayList;

/**
 * Filename Pattern / Challenge 169 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/169/
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
				String[] parts = line.split(" ");
				// pattern is in the initial index
				String pattern = parts[0];
				// convert the challenges pattern rules to the java pattern
				// equivalents
				pattern = pattern.replace(".",  "\\.");
				pattern = pattern.replace("*", ".*");
				pattern = pattern.replace("?", ".");
				// holds our answers
				ArrayList<String> answers = new ArrayList<String>();
				// iterate through the individual filenames and apply pattern
				for(int i = 1; i < parts.length; i++)
				{
					if(parts[i].matches(pattern))
					{
						answers.add(parts[i]);
					}
				}
				if(answers.size() == 0)
				{
					System.out.print("-");
				}
				else
				{
					for(String answer : answers)
					{
						System.out.print(answer + " ");
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
