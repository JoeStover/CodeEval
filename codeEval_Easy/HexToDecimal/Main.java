package HexToDecimal;

import java.io.*;

/**
 * Hex to Decimal / Challenge 67 / Easy
 * 
 * https://www.codeeval.com/open_challenges/67/
 * 
 * Note: Should probably break out the transformation logic into its own method
 * 		 for encapsulation and reuse sake...
 * 
 * @author Joe Stover
 * @version Nov 18, 2014
 */
public class Main 
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader reader = null;
		String line = null;
		try
		{
			reader = generateInputReader(args);
			while((line = reader.readLine()) != null)
			{
				int decimal = 0;
				for(int i = 0; i < line.length(); i++)
				{
					if(Character.isDigit(line.charAt(i)))
					{
						decimal += Character.getNumericValue(line.charAt(i)) * 
								Math.pow(16, (line.length() - 1) - i);
					}
					else if(line.charAt(i) == 'a')
					{
						decimal += 10 * Math.pow(16, (line.length() - 1) - i);
					}	
					else if(line.charAt(i) == 'b')
					{
						decimal += 11 * Math.pow(16, (line.length() - 1) - i);
					}
					else if(line.charAt(i) == 'c')
					{
						decimal += 12 * Math.pow(16, (line.length() - 1) - i);
					}
					else if(line.charAt(i) == 'd')
					{
						decimal += 13 * Math.pow(16, (line.length() - 1) - i);
					}
					else if(line.charAt(i) == 'e')
					{
						decimal += 14 * Math.pow(16, (line.length() - 1) - i);
					}
					else if(line.charAt(i) == 'f')
					{
						decimal += 15 * Math.pow(16, (line.length() - 1) - i);
					}
				}
				System.out.println(decimal);
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
