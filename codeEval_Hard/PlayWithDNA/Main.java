package PlayWithDNA;

import java.io.*;
import java.util.*;

/**
 * Play with DNA / Challenge 126 / Hard
 * 
 * https://www.codeeval.com/open_challenges/126/
 * 
 * @author Joe Stover
 * @version Apr 02, 2015
 * 
 * NOTE: Something is wrong with my algo, need to debug and refactor. 
 * 		 Only getting a %75 completion on CodeEval. It is probably my lev distance
 *       method because I am only %55 complete on that challenge too :)
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
				String[] parts = line.split(" ");
				String dnaSegment = parts[0];
				int misMax = Integer.parseInt(parts[1]);
				String dnaSeq = parts[2];
				System.out.println(
						getMatchingSegments(dnaSegment, dnaSeq, misMax));
			}	
		}
		finally
		{
			reader.close();
		}
	}
	/**
	 * Gets all matching DNA segments within a DNA sequence within a degree of 
	 * allowable mismatches per segment.
	 * 
	 * @param segment String DNA segment to be found in a sequence
	 * @param dnaSeq String  sequence we are searching to find matching DNA segment
	 * @param misMax int     max number of allowable mismatch (minimum of the 
	 *                       total number of substitutions, deletions, and  
	 *                       insertions that must be performed on a DNA slice to
	 *                       completely match a given segment.)
	 * @return String of all occurrences of the matching segment in alphabetical
	 *         order, or "No Match" if no matches exist in this sequence
	 */
	public static String getMatchingSegments(
			String segment, String dnaSeq, int misMax)
	{
		String matches = "";
		// hashmap holds an array list to store segments based on 
		// matching criteria (misMax)
		HashMap<Integer, ArrayList<String>> map =
				new HashMap<Integer, ArrayList<String>>();
		// load a new ArrayList to hold matches of mismatch type
		for(int i = 0; i <= misMax; i++)
		{
			map.put(i, new ArrayList<String>());
		}
		// check segment against all equal length subStrings and add if matches
		// our misMax criteria
		for(int i = 0; i < dnaSeq.length() - segment.length(); i++)
		{
			String tempMatch = dnaSeq.substring(i, i + segment.length());
			int tempMisses = levDist(segment, tempMatch);
			if(map.containsKey(tempMisses))
			{
				map.get(tempMisses).add(tempMatch);
			}
		}
		
		// load our matches in order
		for(int i = 0; i <= misMax; i++)
		{
			ArrayList<String> tempList = map.get(i);
			Collections.sort(tempList);
			if(!tempList.isEmpty())
			{
				for(String match : tempList)
				{
					matches += match + " ";
				}
			}
		}
		return (!matches.isEmpty()) ? matches.trim() : "No match";
	}
	/**
	 * Determines the levenshtein distance between 2 strings.
	 * (see https://en.wikipedia.org/wiki/Levenshtein_distance for more details)
	 * 
	 * @param sOne first string to compare
	 * @param sTwo second string to compare
	 * @return the levenshtein distance between the 2 input strings
	 * 
	 * TODO: Refactor this after I fix my submission for the Levenshtein Distance
	 *       challenge on CodeEval.
	 */
	public static int levDist(String sOne, String sTwo) 
	{                                                                                                                                	 
	    // arrays to contain levenshtein distances                                                      
	    int[] cost = new int[sOne.length() + 1];                                                     
	    int[] newCost = new int[sOne.length() + 1];                                                  
	 
	    // cost of skipping prefix in first string                                
	    for (int i = 0; i < sOne.length() + 1; i++)
	    {
	    	cost[i] = i;
	    }	 
	    // transformation cost for each letter in first string                                    
	    for (int j = 1; j < sTwo.length() + 1; j++) 
	    {                                                
	    	// cost of skipping prefix in string two                             
	        newCost[0] = j;                                                             
	 
	        // cost of transformation of each letter in the first string                                
	        for(int i = 1; i < sOne.length() + 1; i++) 
	        {                                             
	            // match costs for current letter at index for string one and two                             
	            int match = (sOne.charAt(i - 1) == sTwo.charAt(j - 1)) ? 0 : 1;             
	 
	            // cost per transform type                              
	            int replacment = cost[i - 1] + match;                                 
	            int insertion  = cost[i] + 1;                                         
	            int deletion  = newCost[i - 1] + 1;                                  	 
	            // only retain cost of best outcome                                                   
	            newCost[i] = Math.min(Math.min(insertion, deletion), replacment);
	        }                                                                           
	 
	        // swap our arrays                                                 
	        int[] swap = cost; 
	        cost = newCost; 
	        newCost = swap;                          
	    }                                                                               
	 
	    // distance will be the final value in our cost array taking into
	    // account all of the transforms made in both strings
	    return cost[sOne.length()];  
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
