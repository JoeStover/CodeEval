package MultiplyLists;

import java.io.*;

/**
 * Multiply Lists / Challenge 113 / Easy
 * 
 * https://www.codeeval.com/open_challenges/113/
 * 
 * "You have 2 lists of positive integers. Write a program which multiplies
 *  corresponding elements in these lists."
 * 
 * @author Joe Stover
 * @version Nov 13, 2014
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
				String[] numbers = line.split("\\|");
				String[] listOne = numbers[0].trim().split(" ");
				String[] listTwo = numbers[1].trim().split(" ");
				for(int i = 0; i < listOne.length; i++)
				{
					System.out.print(Integer.parseInt(listOne[i]) * 
							Integer.parseInt(listTwo[i]) + " ");
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
