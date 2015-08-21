package UniqueElements;

import java.io.*;
import java.util.*;

/**
 * Unique Elements / Challenge 29 / Easy
 * 
 * https://www.codeeval.com/open_challenges/29/
 * 
 * @author Joe Stover
 * @version Nov 14, 2014
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
				String answer = "";
				LinkedHashSet<String> set = new LinkedHashSet<String>();
				String[] parts = line.split(",");
				for(String part : parts)
				{
					set.add(part);
				}
				Iterator<String> iter = set.iterator();
				while(iter.hasNext())
				{
					answer = answer + iter.next() + ",";
				}
				System.out.println(answer.substring(0, answer.length() - 1));
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
