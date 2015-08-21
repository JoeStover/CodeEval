package SplitTheNumber;

import java.io.*;

/**
 * Split the Number / Challenge 131 / Easy
 * 
 * https://www.codeeval.com/open_challenges/131/
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
				String[] parts = line.split(" ");
				String operator = "";
				if(line.contains("+"))
				{
					operator = "+";
				}
				else
				{
					operator = "-";
				}
				int position = parts[1].indexOf(operator);
				int first = Integer.parseInt(parts[0].substring(0, position));
				int second = Integer.parseInt(parts[0].substring(position));
				if(operator.equals("+"))
				{
					System.out.println(first + second);
				}
				else
				{
					System.out.println(first - second);
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
