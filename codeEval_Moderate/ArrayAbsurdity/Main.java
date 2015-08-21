package ArrayAbsurdity;

import java.io.*;

/**
 * Array Absurdity / Challenge 41 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/41/
 * 
 * Note: Was in a hurry, should refactor for constant space.
 * 
 * @author Joe Stover
 * @version Nov 07, 2014
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
				String[] parts = line.split(";");
				String[] tempArray = new String[Integer.parseInt(parts[0])];
				String[] list = parts[1].split(",");
				for(int i = 0; i < list.length; i++)
				{
					int temp = Integer.parseInt(list[i]);
					if(tempArray[temp] == null)
					{
						tempArray[temp] = temp + "";
					}
					else
					{
						System.out.println(temp);
						break;
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
