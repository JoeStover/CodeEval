package BeautifulStrings;

import java.io.*;
import java.util.*;

/**
 * Beautiful Strings / Challenge 83 / Easy
 * 
 * https://www.codeeval.com/open_challenges/83/
 * 
 * @author Joe Stover
 * @version Nov 13, 2014
 *
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
				HashMap<Character, Integer> letterCounts = 
						new HashMap<Character, Integer>();
				for(int i = 0; i < line.length(); i++)
				{
					char item = line.charAt(i);
					if(Character.isLetter(item))
					{
						if(letterCounts.containsKey(Character.toLowerCase(item)))
						{
							letterCounts.put(Character.toLowerCase(item), 
								letterCounts.get(Character.toLowerCase(item)) + 1);
						}
						else
						{
							letterCounts.put(Character.toLowerCase(item), 1);
						}
					}
				}
				Collection<Integer> items = letterCounts.values();
				Iterator<Integer> iter = items.iterator();
				ArrayList<Integer> list = new ArrayList<Integer>();
				int value = 26;
				int total = 0;
				while(iter.hasNext())
				{
					list.add(iter.next());
				}
				Collections.sort(list);
				for (int i = list.size() - 1; i >= 0; i--)
				{
					total = total + (list.get(i) * value);
					value--;
				}
				System.out.println(total);
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