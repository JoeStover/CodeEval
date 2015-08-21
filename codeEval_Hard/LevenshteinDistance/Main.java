package LevenshteinDistance;

import java.io.*;
import java.util.*;

/**
 * Levenshtein Distance / Challenge 51 / Hard
 * 
 * https://www.codeeval.com/open_challenges/51/
 * 
 * NOTE: Messed up the Lev Algo, need to debug and refactor. Only getting a %55
 *       completion on CodeEval. DP is a weak point for me, so pretty sure I missed
 *       something in the translation.
 * 
 * @author Joe Stover
 * @version Aug 05, 2015
 */
public class Main 
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = null;
		String line = null;
		ArrayList<String> words = new ArrayList<String>();
		ArrayList<String> list = new ArrayList<String>();
		try
		{
			reader = generateInputReader(args);
			line = reader.readLine();
			while(!line.equals("END OF INPUT"))
			{
				words.add(line);
				line = reader.readLine();
			}
			while((line = reader.readLine()) != null)
			{
				list.add(line);
			}
			for(String word : words)
			{
				int friendCount = 0;
				for(String test : list)
				{
					int dist = levDist(word, test);
					if(levDist(word, test) <= 1)
					{
						friendCount++;
					}
				}
				System.out.println(friendCount);
			}
		}
		finally
		{
			reader.close();
		}
	}
	/**
	 * Determines the levenshtein distance between 2 strings.
	 * 
	 * @param sOne first string to compare
	 * @param sTwo second string to compare
	 * @return the levenshtein distance between the 2 input strings
	 * 
	 * TODO: Need to refactor and debug this implementation of the algorithm.
	 * 
	 * 		 See https://en.wikipedia.org/wiki/Levenshtein_distance to review
	 *       what I missed.
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
