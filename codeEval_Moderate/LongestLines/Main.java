package LongestLines;

import java.io.*;
import java.util.*;

/**
 * Longest Lines / Challenge 2 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/2/
 * 
 * @author Joe Stover
 * @version Nov 15, 2014
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
			ArrayList<String> phrases = new ArrayList<String>();
			while((line = reader.readLine()) != null)
			{
				phrases.add(line);
			}
			int total = Integer.parseInt(phrases.get(0));
			phrases.remove(0);
			phrases = Main.lineLengthSort(phrases);
			for(int i = 1; i <= total; i++)
			{
				System.out.println(phrases.get(phrases.size() - 1));
				phrases.remove(phrases.size() - 1);
			}
		}
		finally
		{
			reader.close();
		}
	}
	
	/**
	 * Sorts an ArrayList of Strings based on length in ascending order.
	 * 
	 * TODO: Change this terrible bubble sort to quick or merge.
	 * 
	 * @param inArray the ArrayList to be sorted
	 * @return  ArrayList sorted by string length (ascending)
	 */
	public static ArrayList<String> lineLengthSort(ArrayList<String> inArray)
	{
		boolean hasSwapped = true;
		while (hasSwapped)
		{
			hasSwapped = false;
			for(int i = 1; i < inArray.size(); i++)
			{
				if(inArray.get(i - 1).length() > inArray.get(i).length())
				{
					String temp = inArray.get(i - 1);
					inArray.set(i - 1, inArray.get(i));
					inArray.set(i, temp);
					hasSwapped = true;
				}
			}
		}
		return inArray;
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
