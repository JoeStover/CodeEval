package SimpleSorting;

import java.io.*;
import java.util.Arrays;

/**
 * Simple Sorting / Challenge 91 / Easy
 * 
 * https://www.codeeval.com/open_challenges/91/
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
				String[] array = line.split(" ");
				double[] answer = new double[array.length];
				for (int i = 0; i < array.length; i++)
				{
					answer[i] = Double.parseDouble(array[i]);
				}
				Arrays.sort(answer);
				for(double element : answer)
				{
					System.out.printf("%.3f ", element);
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
