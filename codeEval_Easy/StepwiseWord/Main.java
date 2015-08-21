package StepwiseWord;

import java.io.*;
import java.util.*;

/**
 * Stepwise Word / Challenge 202 / Easy
 * 
 * https://www.codeeval.com/open_challenges/202/
 * 
 * @author Joe Stover
 * @version Jul 01, 2015
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
				System.out.println(getStepWise(line));
			}
		}
		finally
		{
			reader.close();
		}
	}
	/**
	 * Finds the longest word in a line and converts it to a "stepwise word".
	 * 
	 * @param line to be parsed and converted
	 * @return string containing the longest word in the line converted to "stepwise"
	 */
	public static String getStepWise(String line)
	{
		LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer, String>();
		String[] words = line.split(" ");
		int maxLength = 0;
		for(String word : words)
		{
			if(!map.containsKey(word.length()))
			{
				map.put(word.length(), word);
			}
			maxLength = (word.length() > maxLength) ? 
					word.length() : maxLength;
		}
		return convertToStep(map.get(maxLength));
	}
	/**
	 * Takes a word and converts it to a "stepwise" word
	 * 
	 * @param input string to be converted
	 * @return a "stepwise" word in string format
	 */
	public static String convertToStep(String input)
	{
		String answer = "";
		String buffer = "";
		for(char x : input.toCharArray())
		{
			answer += buffer + x + " ";
			buffer += "*";
		}
		return answer.trim();
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

