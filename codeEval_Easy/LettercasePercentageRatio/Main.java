package LettercasePercentageRatio;

import java.io.*;

/**
 * Lettercase Percentage Ratio / Challenge 147 / Easy
 * 
 * https://www.codeeval.com/open_challenges/147/
 * 
 * @author Joe Stover
 * @version Nov 06, 2014
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
				int upperCount = 0;
				int lowerCount = 0;
				int totalCount = line.length();
				
				for(int i = 0; i < line.length(); i++)
				{
					if(Character.isUpperCase(line.charAt(i)))
					{
						upperCount++;
					}
					else
					{
						lowerCount++;
					}
				}
				double upperPercent = 
						((double) upperCount / (double) totalCount) * 100;
				double lowerPercent = 
						((double) lowerCount / (double) totalCount) * 100;
				System.out.printf("lowercase: %.2f ", lowerPercent);
				System.out.printf("uppercase: %.2f \n", upperPercent);
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
