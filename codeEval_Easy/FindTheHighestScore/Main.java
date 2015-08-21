package FindTheHighestScore;

import java.io.*;
import java.util.Arrays;

/**
 * Find The Highest Score / Challenge 208 / Easy
 * 
 * https://www.codeeval.com/open_challenges/208/
 * 
 * @author Joe Stover
 * @version Aug 07, 2015
 */
public class Main 
{	
	public static void main (String[] args) throws IOException
	{
		BufferedReader reader = null;
		String line = null;
		try
		{
			reader = generateInputReader(args);
			while((line = reader.readLine()) != null)
			{
				System.out.println(getHighestScores(line));
			}
		}
		finally
		{
			reader.close();
		}
	}
	/**
	 * Searches a generated table and obtains the highest score
	 * per row.
	 * 
	 * @param line input to be searched
	 * @return a string representing the highest scores per line
	 */
	public static String getHighestScores(String line)
	{
		String hiScores = "";
		int[][] table = generateTable(line);
		for(int[] row : table)
		{
			Arrays.sort(row);
			hiScores += row[row.length - 1] + " ";
		}
		
		return hiScores;
	}
	/**
	 * Generates a table of scores based on line input.
	 * Note: flips rows for columns so it is easier to sort later.
	 * 
	 * @param line input to be placed into table
	 * @return a table of integer scores to sort
	 */
	public static int[][] generateTable(String line)
	{
		String[] rows = line.split("\\s\\|\\s");
		int[][] table = new int [rows[0].split(" ").length][rows.length];
		// change cols to rows in table for simple sorting later 
		// (i.e. you can sort an array of arrays(rows...)
		int i = 0;
		int j = 0;
		for(String row : rows)
		{			
			String[] cols = row.split("\\s");
			for(String col : cols)
			{
				table[i][j] = Integer.parseInt(col);
				i++;
			}
			i = 0;
			j++;
		}
		
		return table;
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

