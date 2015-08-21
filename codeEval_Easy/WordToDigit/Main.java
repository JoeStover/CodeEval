package WordToDigit;

import java.io.*;
import java.util.HashMap;

/**
 * Word to Digit / Challenge 104 / Easy
 * 
 * https://www.codeeval.com/open_challenges/104/
 * 
 * @author Joe Stover
 * @version Nov 12, 2014
 */
public class Main 
{
	public static void main(String[] args) throws IOException
	{
		HashMap <String, String> numbers = new HashMap <String, String>();
		numbers.put("zero", "0");
		numbers.put("one", "1");
		numbers.put("two", "2");
		numbers.put("three", "3");
		numbers.put("four", "4");
		numbers.put("five", "5");
		numbers.put("six", "6");
		numbers.put("seven", "7");
		numbers.put("eight", "8");
		numbers.put("nine", "9");
		BufferedReader reader = null;
		String line = null;
		try
		{
			reader = generateInputReader(args);
			while((line = reader.readLine()) != null)
			{
				String[] parts = line.split(";");
				for(String part : parts)
				{
					System.out.print(numbers.get(part));
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
