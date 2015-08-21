package CompressedSequence;

import java.io.*;

/**
 * Compressed Sequence / Challenge 128 / Easy
 * 
 * https://www.codeeval.com/open_challenges/128/
 * 
 * @author Joe Stover
 * @version Nov 19, 2014
 *
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
				String[] numbers = line.split(" ");
				int count = 1;
				String number = numbers[0];
				if(numbers.length == 1)
				{
					System.out.println(count + " " + number);
				}
				else
				{
					for(int i = 1; i < numbers.length; i++)
					{
						if(number.equals(numbers[i]))
						{
							count++;
						}
						else
						{
							System.out.print(count + " " + number + " ");
							number = numbers[i];
							count = 1;
						}
					}
					System.out.println(count + " " + number);
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

