package StringRotation;

import java.io.*;

/**
 * String Rotation / Challenge 76 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/76/
 * 
 * @author Joe Stover
 * @version Jan 21, 2015
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
				String result = "False";
				// 1) verify that the strings are the same length
				// 2) if we produce a new string made of the first combined,
				//    the rotated string should be inside of it (will throw -1
				//    if it isn't)
				if((parts[0].length() == 
						parts[1].length()) && 
							((parts[0] + parts[0]).indexOf(parts[1]) != -1))
				{
					result = "True";
				}
				System.out.println(result);
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
