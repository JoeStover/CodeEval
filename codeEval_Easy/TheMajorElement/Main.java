package TheMajorElement;

import java.io.*;
import java.util.*;

/**
 * The Major Element / Challenge 132 / Easy
 * 
 * https://www.codeeval.com/open_challenges/132/
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
			while((line = reader.readLine()) != null)
			{
				String answer = "None";
				String[] elements = line.split(",");
				HashMap<String, Integer> container = 
						new HashMap<String, Integer>();
				for(String element : elements)
				{
					if(container.containsKey(element))
					{
						container.put(element, container.get(element) + 1);
					}
					else
					{
						container.put(element, 1);
					}
				}
				Set<String> keys = container.keySet();
				Iterator<String> iter = keys.iterator();
				while(iter.hasNext())
				{
					String num = iter.next();
					int count = container.get(num);
					if(elements.length/2 < count)
					{
						answer = num;
					}
				}
				System.out.println(answer);
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