package JustifyTheText;

import java.io.*;
import java.util.ArrayList;

/**
 * Justify the Text / Challenge 177 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/177/
 * 
 * @author Joe Stover
 * @version Jan 25, 2015
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
				for(String section : Main.justifyText(line))
				{
					System.out.println(section);
				}
			}
		} 
		finally
		{
			reader.close();
		}
	}
	/**
	 * Get an array of "spacings" based on a given word count and total spaces
	 * available.
	 * 
	 * @param wordCount   int representing word count in a line
	 * @param totalSpaces int representing total spaces in a line
	 * @return            array of spacings to be used in a line
	 */
	public static String[] getSpacings(int wordCount, int totalSpaces)
	{
		// number of space segments is one less than total words
		String[] spaces = new String[wordCount - 1];
		int mainSpaces = totalSpaces / (wordCount - 1);
		int extraSpaces = totalSpaces % (wordCount - 1);
		// insert mainSpaces
		for(int i = 0; i < wordCount - 1; i++)
		{
			// hacky way to insert dynamic spacing
			spaces[i] = new String(new char[mainSpaces]).replace("\0", " ");
			// append the leftovers to the front of the array
			if(extraSpaces > 0)
			{
				spaces[i] += " ";
				extraSpaces--;
			}
		}
		return spaces;
	}
	/**
	 * Converts a line into multiple lines if it exceeds 80 character limit.
	 * 
	 * @param line the line to be converted into multiple lines
	 * @return an array of lines if input exceeds 80 chars
	 */
	public static ArrayList<String> breakUpLines(String line)
	{
		ArrayList<String> justLines = new ArrayList<String>();
		// convert lines into new lines while greater than 80 chars
		while(line.length() > 80)
		{
			int index = line.lastIndexOf(' ', 80);
			justLines.add(line.substring(0, index));
			line = line.substring(index).trim();
		}
		// catch last line, or line if it is less then 80
		justLines.add(line);
		
		return justLines;
	}
	/**
	 * Converts a line so that it is justified to an 80 char line.
	 * 
	 * @param line to be converted
	 * @return line justified to fill 80 char rule per line
	 */
	public static String convertLine (String line)
	{
		String convertedLine = "";
		String[] words = line.split(" ");
		int spaceCount = 80 - line.replace(" ", "").length();
		int wordCount = words.length;
		String[] spacings = Main.getSpacings(wordCount, spaceCount);
		for(int i = 0; i < spacings.length; i++)
		{
			convertedLine += words[i] + spacings[i];
		}
		// add last word
		convertedLine += words[words.length - 1];
		return convertedLine;		
	}
	/**
	 * Takes a line and justifies it to an 80 character width. Lines longer
	 * than 80 chars are converted into multiple lines stretched to match 80 
	 * char width. (Last line is not stretched to 80 char width).
	 * 
	 * @param line to be converted
	 * @return ArrayList containing the 80 char justified lines
	 */
	public static ArrayList<String> justifyText(String line)
	{
		ArrayList<String> result = Main.breakUpLines(line);
		// convert all but last line
		for(int i = 0; i < result.size() - 1; i++)
		{
			result.set(i, Main.convertLine(result.get(i)));
		}
		return result;
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
