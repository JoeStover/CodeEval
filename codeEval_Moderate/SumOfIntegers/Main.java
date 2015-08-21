package SumOfIntegers;

import java.io.*;

/**
 * Sum of Integers / Challenge 17 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/17/
 * 
 * @author Joe Stover
 * @version Dec 10, 2014
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
				String[] numbers = line.split(",");
				int largestSum = Integer.parseInt(numbers[0]);//set to beginning
				int currentSum = 0;
				for(int i = 0; i < numbers.length; i++)
                {
					currentSum += Integer.parseInt(numbers[i]);;
					 
                    if(currentSum > largestSum)
                    {
                    	largestSum = currentSum;
                    }
                    else if (currentSum < 0)
                    {
            	       currentSum = 0;
                    }
                }
				System.out.println(largestSum);
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
