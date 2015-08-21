package StringPermutations;

import java.util.*;
import java.io.*;

/**
 * String Permutations / Challenge 14 / Hard
 * 
 * https://www.codeeval.com/open_challenges/14/
 * 
 * @author Joe Stover
 * @version Feb 27, 2015
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
				HashSet<String> set = getAllPermutations(line);
				String[] result = set.toArray(new String[set.size()]);
				Arrays.sort(result);
				for(int i = 0; i < result.length - 1; i++)
				{
					System.out.print(result[i] + ",");
				}
				System.out.println(result[result.length - 1]);
			}
			reader.close();
		}
		finally
		{
			reader.close();
		}
	}
	/**
	 * Gets all permutations of a given string without repetitions.
	 * 
	 * @param line the string to be checked
	 * @return a set of all permutations of the input string
	 */
	public static HashSet<String> getAllPermutations(String line)
	{
		// store results
	    HashSet<String> permutations = new HashSet<String>();
	    // check empty string (base case)
	    if (line == "")
	    {
	    	return permutations;
	    }
	    // get our first letter
	    String letter = line.substring(0, 1);
	    // recurse while greater than 1
	    if(line.length() > 1)
	    {
	    	// break first letter off the line and save it
	    	line = line.substring(1);
	    	// need another set to hold return value
	    	HashSet<String> set = getAllPermutations(line);
	    	// iterate through our hold set
	    	for(String temp : set)
	    	{
	    		// recurse on swapped letter line
	    		for(int i = 0; i <= temp.length(); i++)
	    		{
	    			permutations.add(temp.substring(0, i) + letter + temp.substring(i));
	    		}
	    	}    	
	    }
	    else
	    {
	    	permutations.add(letter);
	    }        
	    return permutations;
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
