package ChainInspection;

import java.io.*;
import java.util.*;

/**
 * Chain Inspection / Challenge 119 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/119/
 * 
 * @author Joe Stover
 * @version Aug 25, 2015
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
				System.out.println(inspectChain(line));
			}
		}
		finally
		{
			reader.close();
		}
	}	
	/**
	 * Takes a string representation of a chain and verifies if it is "GOOD" or "BAD".
	 * 
	 * @param line the chain to be inspected
	 * @return "GOOD" if it is a good chain, "BAD" otherwise
	 */
	public static String inspectChain(String line)
	{
		Map<String, String> linkMap = new HashMap<String, String>();
		String[] chain = line.split(";");
		for(String link : chain)
		{
			String[] temp = link.split("-");
			if(!linkMap.containsKey(temp[0]))
			{
				linkMap.put(temp[0], temp[1]);
			}
		}
		return (isCompleteChain(linkMap, chain.length)) ? "GOOD" : "BAD"; 
	}
	/**
	 * Checks if the map of chain links constitutes a complete chain (can traverse
	 * from "BEGIN" link to "END" link, utilizing all given links in map).
	 * 
	 * @param linkMap      map representation of chain links to be tested
	 * @param chainLength  length of the original chain
	 * @return             "GOOD" if this is a complete chain, "BAD" otherwise
	 */
	public static boolean isCompleteChain(Map<String, String> linkMap, int chainLength)
	{
		String lastLink = "BEGIN";
		int counter = 0;
		// jump out if can't find next link, hit the end, or we hit a cycle
		// i.e. made more moves than there are links
		while(lastLink != null && !lastLink.equals("END") && counter <= chainLength)
		{
			String temp = linkMap.get(lastLink);
			// set to null if chain points to itself
			lastLink = (lastLink.equals(temp)) ? null : temp;
			// keep track of used chains
			counter++;
		}
		// only true if we hit the end and used all links
		return lastLink != null && lastLink.equals("END") && counter == chainLength;
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