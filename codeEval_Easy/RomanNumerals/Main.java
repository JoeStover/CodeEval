package RomanNumerals;

import java.io.*;

/**
 * Roman Numerals / Challenge 106 / Easy
 * 
 * https://www.codeeval.com/open_challenges/106/
 * 
 * @author Joe Stover
 * @version Nov 07, 2014
 */
public class Main 
{
	public static void main(String[] args) throws IOException 
	{
		// create a template to grab from
		String[] ones = {"","I","II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
		String[] tens = {"","X","XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
		String[] hundreds = {"","C","CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
		String[] thousands = {"","M","MM", "MMM"};
		
		BufferedReader reader = null;
		String line = null;
		try
		{
			reader = generateInputReader(args);
			while((line = reader.readLine()) != null)
			{
				String number = String.format("%04d", Integer.parseInt(line));
				String thousandsPlace = 
						thousands[Character.getNumericValue(number.charAt(0))];
				String hundredsPlace = 
						hundreds[Character.getNumericValue(number.charAt(1))];
				String tensPlace = 
						tens[Character.getNumericValue(number.charAt(2))];
				String onesPlace = 
						ones[Character.getNumericValue(number.charAt(3))];
				
				System.out.println(
						thousandsPlace + hundredsPlace + tensPlace + onesPlace);
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
