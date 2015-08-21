package SwapElements;

import java.io.*;

/**
 * Swap Elements / Challenge 112 / Easy
 * 
 * https://www.codeeval.com/open_challenges/112/
 * 
 * @author Joe Stover
 * @version Nov 15, 2014
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
				String[] parts = line.split("\\ : ");
				String[] list = parts[0].split(" ");
				String[] swaps = parts[1].split("\\, ");
				for(String swap : swaps)
				{
					String[] position = swap.split("-");
					String temp = list[Integer.parseInt(position[0])];
					list[Integer.parseInt(position[0])] =
							list[Integer.parseInt(position[1])];
					list[Integer.parseInt(position[1])] = temp; 
				}
				String answer = "";
				for(String number : list)
				{
					answer = answer + number + " ";
				}
				System.out.println(answer.trim());
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