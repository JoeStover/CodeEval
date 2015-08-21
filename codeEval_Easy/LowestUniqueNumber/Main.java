package LowestUniqueNumber;

import java.io.*;
import java.util.*;

/**
 * Lowest Unique Number / Challenge 103 / Easy
 * 
 * https://www.codeeval.com/open_challenges/103/
 * 
 * @author Joe Stover
 * @version Nov 12, 2014
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
				int winnerSpot = 0;
				HashSet<String> testSet = new HashSet<String>();
				String[] numbers = line.split(" ");
				ArrayList<String> uniqueList = new ArrayList<String>();	
				ArrayList<String> answerList = new ArrayList<String>();	
				for(String number : numbers)
				{
					if(testSet.add(number))
					{
						uniqueList.add(number);
					}
					else
					{
						uniqueList.remove(number);
					}	
					answerList.add(number);
				}
				if(!uniqueList.isEmpty())
				{
					Collections.sort(uniqueList);
					winnerSpot = answerList.indexOf(uniqueList.get(0)) + 1;
				}
				System.out.println(winnerSpot);			
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