package SetIntersection;

import java.io.*;
import java.util.*;

/**
 * Set Intersection / Challenge 30 / Easy
 * 
 * https://www.codeeval.com/open_challenges/30/
 * 
 * @author Joe Stover
 * @version Nov 14, 2014
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
				String[] parts = line.split(";");
				String[] partOne = parts[0].split(",");
				String[] partTwo = parts[1].split(",");		
				List<String> listOne = new ArrayList<String>();
				List<String> listTwo = new ArrayList<String>();
				for(String part : partOne)
				{
					listOne.add(part);
				}
				for(String part : partTwo)
				{
					listTwo.add(part);
				}
				listOne.retainAll(listTwo);
				String answer = listOne.toString().replace(" ", "");
				System.out.println(answer.substring(1, answer.length() - 1));
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
