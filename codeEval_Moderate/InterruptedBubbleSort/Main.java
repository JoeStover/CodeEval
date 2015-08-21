package InterruptedBubbleSort;

import java.io.*;

/**
 * Interrupted Bubble Sort/ Challenge 158 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/158/
 * 
 * @author Joe Stover
 * @version Nov 07, 2014
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
				String[] parts = line.split("[|]");
				String[] array = parts[0].split(" ");
				long steps = Long.parseLong(parts[1].trim());
				int[] sortedList = partialBubbleSort(array, steps);
				for(int i = 0; i < sortedList.length; i++)
				{
					System.out.print(sortedList[i] + " ");
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
	 * Performs a bubble sort on the passed in array up to the given step.
	 * 
	 * @param inArray array to be "partially" bubble sorted
	 * @param inSteps number of steps to move through bubble sort
	 * @return partially sorted list
	 */
	public static int[] partialBubbleSort(String[] inArray, long inSteps)
	{
		boolean hasSwapped = true;
		int[] list = new int[inArray.length];
		for(int i = 0; i < list.length; i++)
		{
			list[i] = Integer.parseInt(inArray[i]);
		}
		int counter = 0;
		while (hasSwapped && counter < inSteps)
		{
			hasSwapped = false;
			for(int i = 1; i < list.length; i++)
			{
				if(list[i - 1] > list[i])
				{
					int temp = list[i - 1];
					list[i - 1] = list[i];
					list[i] = temp;
					hasSwapped = true;
				}
			}
			counter++;
		}
		return list;
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
