package MeetCombSort;

import java.io.*;

/**
 * Meet Comb Sort / Challenge 233 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/233/
 * 
 * @author Joe Stover
 * @version June 12, 2016
 */
public class Main 
{
	static final double SHRINK_FACTOR = 1.25;
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = null;
		String line = null;
		try
		{
			reader = generateInputReader(args);
			while((line = reader.readLine()) != null)
			{
				String[] array = line.split(" ");
				System.out.println(combSort(array));
			}
		}
		finally
		{
			reader.close();
		}
	}
	/**
	 * Uses comb sort algorithm to sort a passed in array in
	 * ascending orde (based on wikipedia pseudocode example 
	 * and challenge's specified shrink factor).
	 * 
	 * @param array to be sorted
	 * @return number of iterations needed to sort array
	 */
	public static int combSort(String[] array)
	{
		int gap = array.length;  
		boolean hasSwapped = true; 	
		int iterCount = 0;
		while(gap > 1 || hasSwapped)
		{
			if(gap > 1)
			{
				gap = (int)(gap / SHRINK_FACTOR);
			}
			hasSwapped = false;
			for(int i = 0; i + gap < array.length; i++)
			{
				if(Integer.parseInt(array[i]) >
						Integer.parseInt(array[i + gap]))
				{
					String temp = array[i];
					array[i] = array[i + gap];
					array[i + gap] = temp;
					hasSwapped = true;
				}
			}
			if(hasSwapped || gap > 1)
			{
				iterCount++;
			}		
		}		
		return iterCount;
	}
	public static void swap(int[] array, int i, int j)
	{
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
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
