package RepeatedSubstring;

import java.util.*;
import java.io.*;

/**
 * Repeated Substring / Challenge 53 / Hard
 * 
 * https://www.codeeval.com/open_challenges/53/
 * 
 * Note: First approach used suffix array and sort to 
 *       place those suffixes near each other for efficiency.
 *       Unfortunately, it breaks for the "substrings cannot
 *       overlap" constraint, and I was unsure how to broach that
 *       and keep the suffix tree.
 *       
 *       This approach is far less efficient, but covers that
 *       constraint. Will refactor again when I have time to
 *       cover suffix tree PLUS no overlap.
 * 
 * @author Joe Stover
 * @version June 23, 2016
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
				System.out.println((repeatedSubstring(line)));
			}
		}
		finally
		{
			reader.close();
		}
	}
    public static String repeatedSubstring(String line)
    {
    	String longestRepeat = "";
    	// get 1/2 the string for a partition to iterate through
    	// accounting for odd length
    	int partition = (line.length() / 2) + (line.length() % 2);    
    	// set boundaries  
    	for(int i = 0; i < partition; i++)
    	{
    		// iterate through current boundaries
    		for(int j = i; j <= partition; j++)
        	{
        		// check left
        		String leftSub = line.substring(i, j);
        		String leftTest = line.substring(j);
        		if(leftTest.contains(leftSub))
        		{
        			// make sure our sub is larger than current and not
        			// all spaces
        			if(leftSub.length() > longestRepeat.length() &&
        					!leftSub.trim().isEmpty())
        			{
        				longestRepeat = leftSub;
        			}
        		}
        		// check right
        		String rightSub = line.substring(line.length() - 1 - j, 
        				line.length() - 1);
        		String rightTest = line.substring(0, line.length() - 1 - j);
        		if(rightTest.contains(rightSub))
        		{
        			// make sure our sub is larger than current and not
        			// all spaces
        			if(rightSub.length() > longestRepeat.length() &&
        					!rightSub.trim().isEmpty())
        			{
        				longestRepeat = rightSub;
        			}
        		}
        	}
    	}
    	return (longestRepeat.trim().isEmpty()) ? "NONE" : longestRepeat;
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

