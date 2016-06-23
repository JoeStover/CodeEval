package RepeatedSubstring;

import java.util.*;
import java.io.*;

/**
 * Repeated Substring / Challenge 53 / Hard
 * 
 * https://www.codeeval.com/open_challenges/53/
 * 
 * Note: This approach will not pass instances where
 *       the repeated string overlaps. Need to rework 
 *       algorithm. This is a simple first attempt based
 *       on reviewing pseudocode examples from Stanford.
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
				System.out.println(longestRepeatedString(line));
			}
		}
		finally
		{
			reader.close();
		}
	}
    /**
     * Gets the longest prefix common to 2 strings.
     * 
     * @param s1 first string prefix to be compared
     * @param s2 second string prefix to be compared
     * @return String longest prefix common to both String inputs
     */
    public static String longestCommonPrefix(String s1, String s2)
    {
    	// determine shortest string for iteration purposes
    	int minLength = Math.min(s1.length(), s2.length());
    	for(int i = 0; i < minLength; i++)
    	{
    		// upon mismatch, return previous matches
    		if(s1.charAt(i) != s2.charAt(i))
    		{
    			return s1.substring(0, i);
    		}
    	}
    	// strings match, so just return min
    	return s1.substring(0, minLength);
    }
    /**
     * Finds the longest repeated substring in a given string.
     * 
     * @param line String to be searched
     * @return longest repeating substring, 
     * 		   or NONE if no such substring exists
     */
    public static String longestRepeatedString(String line)
    {
    	// holds a list of suffixes to compare
    	String[] suffixes = new String[line.length()];
    	for(int i = 0; i < line.length(); i++)
    	{
    		suffixes[i] = line.substring(i, line.length());
    	}
    	// sort suffixes to place potential matches near each other 
    	// then compare
    	Arrays.sort(suffixes);
    	String longestRepeat = "";
    	for(int i = 0; i < suffixes.length - 1; i++)
    	{
    		String temp = longestCommonPrefix(suffixes[i], suffixes[i + 1]);
    		if(temp.length() > longestRepeat.length())
    		{
    			longestRepeat = temp;
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

