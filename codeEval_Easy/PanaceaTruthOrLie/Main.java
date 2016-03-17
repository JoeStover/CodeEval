package PanaceaTruthOrLie;

import java.io.*;

/**
 * Panacea - Truth or Lie / Challenge 237 / Easy
 * 
 * https://www.codeeval.com/open_challenges/237/
 * 
 * @author Joe Stover
 * @version Feb 26, 2016
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
				solveChallenge(line);
			}	
		}
		finally
		{
			reader.close();
		}
	}
	/**
	 * Solves the given challenge based on given input.
	 * 
	 * @param line as a String extracted from a given file
	 */
	public static void solveChallenge(String line)
	{
		// break up input into lists
		String[] parts = line.split("\\ \\|\\ ");
		String[] hexList = parts[0].split(" ");
		String[] binList = parts[1].split(" ");
		// process and store data
		int virusTotal = 0;
		int antiTotal = 0;
		for(String hex : hexList)
		{
			virusTotal += Integer.parseInt(hex, 16);
		}
		for(String bin : binList)
		{
			antiTotal += Integer.parseInt(bin, 2);
		}
		// "True" if the antivirus matches or exceeds the virus
		System.out.println((antiTotal >= virusTotal) ? "True" : "False");
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
