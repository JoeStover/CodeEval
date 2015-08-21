package NumberPairs;

import java.io.*;

/**
 * Number Pairs / Challenge 34 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/34/
 * 
 * @author Joe Stover
 * @version Mar 07, 2015
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
				String[] parts = line.split(";");
				int target = Integer.parseInt(parts[1]);
				String allPairs = "";
				String[] numbers = parts[0].split(",");
				int[] nums = new int[numbers.length];
				for(int i = 0; i < numbers.length; i++)
				{
					nums[i] = Integer.parseInt(numbers[i]);
				}
				int start = 0;
				int end = nums.length -1;
				while(start < end)
				{
					int sum = nums[start] + nums[end];
					if(sum == target)
					{
						allPairs += nums[start] + "," + nums[end] + ";";
						start++;
						end--;
					}
					else if(sum < target)
					{
						start++;
					}
					else if(sum > target)
					{
						end--;
					}
				}
				if(allPairs.isEmpty())
				{
					System.out.println("NULL");
				}
				else
				{
					System.out.println(allPairs.substring(0, allPairs.length() - 1));
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
