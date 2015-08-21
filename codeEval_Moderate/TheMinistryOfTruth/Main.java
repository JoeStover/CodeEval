package TheMinistryOfTruth;

import java.io.*;
import java.util.*;

/**
 * The Ministry of Truth / Challenge 143 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/143/
 * 
 * @author Joe Stover
 * @version Aug 02, 2015
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
				// sanitize our line for multiple spaces
				line = line.replaceAll(" +", " ");
				System.out.println(doubleSpeakify(line));
			}
		}
		finally
		{
			reader.close();
		}
	}
	/**
	 * Takes a line from the input file and breaks it into a real phrase and
	 * fake phrase. Phrases are compared for matches. Returns matching fake
	 * phrases, blocking out the rest of the real phrase with '_'.
	 * 
	 * Returns "I cannot fix history" if the real phrase cannot be converted.
	 * 
	 * @param line that is to be converted to "double speak"
	 * @return a sanitized line of double speak for The Ministry of Truth
	 */
	public static String doubleSpeakify(String line)
	{
		String result = "";
		String[] parts = line.split(";");
		List<String> oldPhrase = new ArrayList<String>();
		List<String> newPhrase = new ArrayList<String>();
		oldPhrase = new ArrayList<String>(Arrays.asList(parts[0].split(" ")));
		// make sure we don't have an empty 2nd half like:  foo; vs foo;bar
		if(parts.length != 2)
		{
			// just add something so the arraylist works and creates our blank
			newPhrase.add("");	
		}
		else
		{
			// we have a real split
			newPhrase = 
					new ArrayList<String>(Arrays.asList(parts[1].split(" ")));
		}
		for (Iterator<String> iterOld = oldPhrase.iterator(); iterOld
				.hasNext();) {
			String oldWord = iterOld.next();
			result += obfuscateWord(oldWord, newPhrase) + " ";
		}
		// must use all parts of new phrase or no doublespeak
		if (!newPhrase.isEmpty()) {
			result = "I cannot fix history";
		}
		return result.trim();
	}
	/**
	 * Compares a real word to a list of "approved," fake words from the Ministry.
	 * 
	 * If one of the "fake" words matches the "real" word, the fake word replaces
	 * the real one and "blanks out" the rest of the real word with '_'s. The fake
	 * word is then removed from the list, as it has been "used".
	 *  
	 * If there is not match, the method, instead, returns "I cannot fix history". 
	 * 
	 * @param realWord the word the ministry wants to obfuscate
	 * @param fakeWords a list of pre-approved words to match against the real one
	 * @return a string replacement for the real word based on the fake word list
	 *         if there is a match, with '_' blocking out the parts that do not match
	 *         If there is no match at all, returns "I cannot fix history". 
	 */
	public static String obfuscateWord(String realWord, 
			List<String> fakeWords)
	{
		String result = "";
		boolean found = false;
		for(Iterator<String>iter = fakeWords.iterator(); 
				iter.hasNext() && !found;)
		{
			String fake = iter.next();
			if(realWord.contains(fake))
			{
				realWord = realWord.replaceFirst(fake, "*");
				realWord = realWord.replaceAll("[^*]", "_");
				realWord = realWord.replace("*", fake);
				result = realWord;
				iter.remove();
				found = true;
			}
		}
		if(result.isEmpty())
		{
			result = realWord.replaceAll("\\w", "_");
		}
		return result.trim();
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
