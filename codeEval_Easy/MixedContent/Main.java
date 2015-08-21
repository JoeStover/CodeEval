package MixedContent;

import java.io.*;
import java.util.ArrayList;

/**
 * Mixed Content / Challenge 115 / Easy
 * 
 * https://www.codeeval.com/open_challenges/115/
 * 
 * @author Joe Stover
 * @version Nov 12, 2014
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
				ArrayList<String> words = new ArrayList<String>();
				ArrayList<String> numbers = new ArrayList<String>();
				for(String part : parts)
				{
					if(Character.isDigit(part.charAt(0)))
					{
						numbers.add(part);
					}
					else
					{
						words.add(part);
					}
				}
				if(words.size() == 0)
				{
					for(int i = 0; i < numbers.size(); i++)
					{
						if(i < numbers.size() - 1)
						{
							System.out.print(numbers.get(i) + ",");
						}
						else
						{
							System.out.print(numbers.get(i) + "\n");
						}
					}
				}
				else if(numbers.size() == 0)
				{
					for(int i = 0; i < words.size(); i++)
					{
						if(i < words.size() - 1)
						{
							System.out.print(words.get(i) + ",");
						}
						else
						{
							System.out.print(words.get(i) + "\n");
						}
					}
				}
				else
				{
					for(int i = 0; i < words.size(); i++)
					{
						if(i < words.size() - 1)
						{
							System.out.print(words.get(i) + ",");
						}
						else
						{
							System.out.print(words.get(i) + "|");
						}
					}
					for(int i = 0; i < numbers.size(); i++)
					{
						if(i < numbers.size() - 1)
						{
							System.out.print(numbers.get(i) + ",");
						}
						else
						{
							System.out.print(numbers.get(i) + "\n");
						}
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