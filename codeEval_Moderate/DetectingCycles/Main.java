package DetectingCycles;

import java.io.*;
import java.util.*;

/**
 * Detecting Cycles / Challenge 5 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/5/
 * 
 * @author Joe Stover
 * @version Dec 03, 2014
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
				String[] numbers = line.split(" ");
				LinkedHashSet<String> trial = new LinkedHashSet<String>();
				LinkedHashSet<String> cycle = new LinkedHashSet<String>();
				int counter = 0;
				boolean done = false;
				while(!done && counter < numbers.length)
				{
					if(!trial.add(numbers[counter]))
					{
						if(!cycle.add(numbers[counter]))
						{
							done = true;
						}
					}
					counter++;
				}
				Iterator<String> iter = cycle.iterator();
				while(iter.hasNext())
				{
					System.out.print(iter.next() + " ");
				}
				System.out.println();
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
