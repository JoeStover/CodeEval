package SortMatrixColumns;

import java.io.*;
import java.util.*;

/**
 * Sort Matrix Columns / Challenge 200 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/200/
 * 
 * @author Joe Stover
 * @version Jul 07, 2015
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
				ArrayList<ArrayList<Integer>> matrix = 
						buildMatrix(line);
				sortMatrixCols(matrix);
				System.out.println(matrixToString(matrix));
			}
		}
		finally
		{
			reader.close();
		}		
	}
	/**
	 * Builds a matrix out of a string representation. Matrix is nested ArrayLists
	 * with a slight departure to convention. This nest is "column" first instead of
	 * "row" first. This is to facilitate the shift of columns more easily to
	 * match the rules of this challenge. Swaps are now one operation as opposed
	 * to moving each individual row per column in a int[][].
	 * 
	 * @param line that represents a matrix
	 * @return nested ArrayList where outter list is col and inner is row.
	 */
	public static ArrayList<ArrayList<Integer>> buildMatrix(String line)
	{
		ArrayList<ArrayList<Integer>> cols = 
				new ArrayList<ArrayList<Integer>>();
		String[] rows = line.split(" \\| ");
		for(String row : rows)
		{
			// add a col to our master list per array row
			cols.add(new ArrayList<Integer>());
		}
		// now set up our cols of rows
		for(int i = 0; i < rows.length; i++)
		{
			String[] tempCols = rows[i].split(" ");
			for(int j = 0; j < rows.length; j++)
			{
				cols.get(j).add(Integer.parseInt(tempCols[j]));
			}
		}			
		return cols;
	}
	/**
	 * Sorts a matrix (represented by nested ArrayLists) based on the rules
	 * outlined by this challenge:
	 * 
	 * "sort the columns in the matrix by first row in ascending order. If the 
	 *  numbers in the first line are equal - you should sort it by the lowest 
	 *  number of second line, if numbers in the second line are also equal you 
	 *  should sort it by the next row etc."
	 * 
	 * @param cols the ArrayList<ArrayList<Integer>> to be sorted
	 */
	public static void sortMatrixCols(ArrayList<ArrayList<Integer>> cols)
	{
		boolean hasSwapped = true;
		int row = 0;
		while(hasSwapped)
		{
			hasSwapped = false;
			// go length of the array
			for(int col = 0; col < cols.size() - 1; col++)
			{
				// if comparisons are equal, move to next row until 
				// we have something to compare
				while((cols.get(col).get(row) == cols.get(col + 1).get(row)) &&
							row < cols.size() - 1)
				{
					row++;
				}
				if(cols.get(col).get(row) > cols.get(col + 1).get(row))
				{
					// swap spots if out of order & set swapped to true
					Collections.swap(cols, col, col + 1);
					hasSwapped = true;
				}
				row = 0;
			}		
		}
	}
	/**
	 * Converts a passed in 2d matrix (nested ArrayLists) into a String.
	 * 
	 * @param cols nested ArrayList to be converted into a string
	 * @return String representation of the nested ArrayLists
	 */
	public static String matrixToString(ArrayList<ArrayList<Integer>> cols)
	{
		String result = "";
		for(int col = 0; col < cols.size(); col++)
		{
			for(int row = 0; row < cols.size(); row++)
			{
				result += cols.get(row).get(col) + " ";
			}
			result += "| ";
		}			
		return result.substring(0, result.length() - 2);
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

