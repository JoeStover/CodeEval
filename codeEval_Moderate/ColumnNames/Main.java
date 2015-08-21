package ColumnNames;

import java.io.*;
import java.util.*;

/**
 * Column Names / Challenge 197 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/197/
 * 
 * @author Joe Stover
 * @version Jun 02, 2015
 * 
 * Note: Only 95% complete on CodeEval. I have a bug when value is a multiple of
 * 26. Still need to debug and fix that simple logic error.
 */
public class Main 
{
	// constant to hold map of value to letter
	static final HashMap<Integer,String> MAP = 
			new HashMap<Integer,String>();
	static
	{
		MAP.put(1, "A");
		MAP.put(2, "B");
		MAP.put(3, "C");
		MAP.put(4, "D");
		MAP.put(5, "E");
		MAP.put(6, "F");
		MAP.put(7, "G");
		MAP.put(8, "H");
		MAP.put(9, "I");
		MAP.put(10, "J");
		MAP.put(11, "K");
		MAP.put(12, "L");
		MAP.put(13, "M");
		MAP.put(14, "N");
		MAP.put(15, "O");
		MAP.put(16, "P");
		MAP.put(17, "Q");
		MAP.put(18, "R");
		MAP.put(19, "S");
		MAP.put(20, "T");
		MAP.put(21, "U");
		MAP.put(22, "V");
		MAP.put(23, "W");
		MAP.put(24, "X");
		MAP.put(25, "Y");
		MAP.put(26, "Z");
	}
	public static void main(String[] args) throws IOException 
	{
		BufferedReader reader = null;
		String line = null;
		try
		{
			reader = generateInputReader(args);
			while((line = reader.readLine()) != null)
			{
				int col = Integer.parseInt(line);
				System.out.println(generateColName(col));
			}
		}
		finally
		{
			reader.close();
		}
	}
	// basically base-26, with only letter representation
	
	/**
	 * Generates a string column name based on the numeric value.
	 * 
	 * @param col integer value of a column
	 * @return String alpha representation of the input number
	 * 
	 * TODO: Fix columns returning null when input is a multiple of 26.
	 */
	public static String generateColName(int col)
	{
		String name = "";
		Stack<Integer> converter = new Stack<Integer>();
		while(col > 26)
		{
			converter.push(col % 26);
			col /= 26;
		}
		converter.push(col);
		while(!converter.isEmpty())
		{
			name += MAP.get(converter.pop());
		}
		return name;
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
