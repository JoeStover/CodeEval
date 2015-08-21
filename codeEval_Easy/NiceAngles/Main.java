package NiceAngles;

import java.io.*;

/**
 * Nice Angles / Challenge 160 / Easy
 * 
 * https://www.codeeval.com/open_challenges/160/
 * 
 * @author Joe Stover
 * @version Nov 11, 2014
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
				double angle = Double.parseDouble(line);
				double whole = angle - (angle % 1);
				double mins = (angle % 1) * 60;
				double seconds = (mins % 1) * 60;
				System.out.printf("%.0f.%02.0f'%02.0f\"\n", 
						whole, Math.floor(mins), Math.floor(seconds));
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
