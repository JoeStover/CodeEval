package CardNumberValidation;

import java.io.*;

/**
 * Card Number Validation / Challenge 172 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/172/
 * 
 * @author Joe Stover
 * @version Nov 30, 2014
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
				String cardNumber = line.replaceAll("\\s+", "");
				int checkSum = Character.getNumericValue(cardNumber.charAt(cardNumber.length() - 1));
				int validity = 1; // 1 is true, 0 is false
				int sum = 0;
				boolean mustDouble = false;
				for(int i = cardNumber.length() - 1; i >= 0; i--)
				{
					int value = Character.getNumericValue(cardNumber.charAt(i));
					if(mustDouble)
					{
						value *= 2;
						if(value > 9)
						{
							value = ((value / 10) + (value % 10));
						}	
					}
					sum += value;
					mustDouble = !mustDouble;
				}
				if(sum % 10 != 0)
				{
					validity = 0;
				}
				System.out.println(validity);
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
