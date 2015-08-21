package SelfDescribingNumbers;

import java.io.*;
import java.util.HashMap;

/**
 * Self Describing Numbers / Challenge 40 / Easy
 * 
 * https://www.codeeval.com/open_challenges/40/
 * 
 * @author Joe Stover
 * @version Nov 19, 2014
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
				int isSelfDescribing = 1;
				HashMap<Integer, Integer> numberCount = 
						new HashMap<Integer, Integer>();
				for(int i = 0; i < line.length(); i++)
				{
					int num = Character.getNumericValue(line.charAt(i)); 
					if(numberCount.containsKey(num))
					{
						numberCount.put(num, numberCount.get(num) + 1);
					}
					else
					{
						numberCount.put(num, 1);
					}
				}
				for(int i = 0; i < line.length(); i++)
				{
					int num = Character.getNumericValue(line.charAt(i)); 
					int count = 0;
					if(numberCount.get(i) != null)
					{
						count = numberCount.get(i);
					}
					if(count != num)
					{
						isSelfDescribing = 0;
					}
				}
				System.out.println(isSelfDescribing);
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

