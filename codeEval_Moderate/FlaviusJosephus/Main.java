package FlaviusJosephus;

import java.io.*;
import java.util.*;

/**
 * Flavius Josephus / Challenge 75 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/75/
 * 
 * @author Joe Stover
 * @version Jan 26, 2015
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
				String[] parts = line.split(",");
				int killNum = Integer.parseInt(parts[1]);
				// queue will simulate circular linked list where non-killed go  
				// back to front of line
				Queue<Integer> victims = 
						new LinkedList<Integer>();
				String killOrder = "";
				for(int i = 0; i < Integer.parseInt(parts[0]); i++)
				{
					victims.add(i);
				}
				// kill every nth guy till empty
				while(victims.size() != 0)
				{
					// count to kill number 
					// 1) send lucky back to end of line (poll then offer)
					// 2) remove the dead (poll for good)
					for(int i = 1; i <= killNum; i++)
					{
						// dead
						if(i == killNum)
						{
							killOrder += victims.poll() + " ";
						}
						// lucky
						else
						{
							victims.offer(victims.poll());
						}
					}
				}
				System.out.println(killOrder.trim());				
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

