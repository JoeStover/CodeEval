package FirstNonRepeatedCharacter;

import java.io.*;
import java.util.*;

/**
 * First Non-Repeated Character / Challenge 12 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/12/
 * 
 * @author Joe Stover
 * @version Nov 08, 2014
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
				LinkedHashSet<Character> solutionSet = new LinkedHashSet<Character>();
				LinkedHashSet<Character> testSet = new LinkedHashSet<Character>();
				for(int i = 0; i < line.length(); i++)
				{
					if(testSet.add(line.charAt(i)))
					{
						solutionSet.add(line.charAt(i));
					}
					else
					{
						solutionSet.remove(line.charAt(i));
					}
				}
				Iterator<Character> iter = solutionSet.iterator();
				System.out.println(iter.next());
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
