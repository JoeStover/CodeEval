package PackageProblem;

import java.io.*;
import java.util.*;

/**
 * Package Problem / Challenge 114 / Hard
 * 
 * https://www.codeeval.com/open_challenges/114/
 * 
 * Note: This problem is a riff on the NP-Complete "Package Problem" used to 
 * study and understand Dynamic Programming in CS. I've used "knapsack" 
 * interchangeably with "package" throughout the comments.
 * 
 * @author Joe Stover
 * @version Mar 06, 2015
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
				// process line
				String[] parts = line.split(" : "); // sack size and item list
				String[] items = parts[1].split(" "); // individual items
				// our usable variables 
				// weights * 100 to prevent fractional(double) lbs
				int[] values = new int[items.length + 1];
				int[] weights = new int[items.length + 1];
				for(int i = 0; i < items.length; i++)
				{
					String[] temp = items[i].substring(
							1, items[i].length() - 1).split(",");
					weights[i + 1] = (int)(Double.parseDouble(temp[1])  * 100);
					values[i + 1] = Integer.parseInt(temp[2].substring(1));
				}			
				// total knapsack weight
				int packSize = (int)(Double.parseDouble(parts[0]) * 100);
				int[][] solution = knapsackSolution(packSize, values, weights);
				ArrayList<Integer> list = getBestItems(solution, weights);
				System.out.println(optimizeBestItems(list, weights, values));
			}
		}
		finally
		{
			reader.close();
		}
	}
	/**
	 * Creates a matrix to store solutions for the knapsack based on maximum weight
	 * of the knapsack, and the weight/value of each item to be considered. 
	 * 
	 * @param packSize total weight of knapsack as integer
	 * @param values   array of item values to match weights array by index
	 * @param weights  array of item weights to match values array by index
	 * @return         matrix of cached results (for DP solution) where
	 *                 col indexes represent weight in lbs and the row index
	 *                 represents total number of items to be taken
	 */
	public static int[][] knapsackSolution(
			int packSize, int[] values, int[] weights)
	{
		// cache results using DP
		// rows = number of total items to take
		// cols = packs size in gradations of 1 lb.
		int[][] matrix = new int[weights.length][packSize + 1];
		for(int item = 1; item < matrix.length; item++)
		{
			for(int wt = 1; wt < matrix[item].length; wt++)
			{
				// check if the weight of current item is greater
				// than current sack limit (col header in matrix)
				if(weights[item] > wt)
				{
					// if it is greater, then set it to prev row "value"
					matrix[item][wt] = matrix[item - 1][wt];
				}
				else
				{
					// set max value between previous and new item
					matrix[item][wt] = Math.max(matrix[item - 1][wt], 
							(values[item] + matrix[item - 1][wt - weights[item]]));
				}
			}
		}
		return matrix;
	}
	/**
	 * Gets a list of the best items to fill the knapsack based on knapsack capacity
	 * and the specific items that maximize value without going over that capacity.
	 * 
	 * @param matrix   containing a cache of knapsack solutions using a bottom up 
	 *                 approach
	 * @param weights  array of weights for each item (labeled by the index)
	 * @return         ArrayList of best items to place into the knapsack based
	 *                 on each item value and the max weight the knapsack can hold
	 */
	public static ArrayList<Integer> getBestItems(int[][] matrix, int[] weights)
	{
		ArrayList<Integer> items = new ArrayList<Integer>();
		int i = matrix.length - 1;
		// iterate backwards through our weight columns
		for(int j = matrix[0].length - 1; j >= 0 && i > 0; i--)
		{
			// if there is a change in value from this item to prior item
			if(matrix[i][j] != matrix[i-1][j])
			{
				// item is part of solution so append it
				items.add(0, i);
				// drop back by the weight of item in solution and continue
				j -= weights[i];
			}
		}
		return items;
	}
	/**
	 * Finds the optimal items to place in the package/knapsack, as the challenge
	 * rules state: "You would prefer to send a package which weights less in case 
	 * there is more than one package with the same price." 
	 * 
	 * @param list     the list of best items to be taken
	 * @param weights  array of weights for each item (labeled by the index)
	 * @param values   array of values for each item (labeled by the index)
	 * @return         a string listing the optimized items to place in the package,
	 *                 or "-" if nothing will fit in the package/knapsack
	 */
	public static String optimizeBestItems(ArrayList<Integer> list,
			int[] weights, int[] values)
	{
		String bestItems = "";
		if(list.isEmpty())
		{
			bestItems = "-";
		}
		else
		{
			// for the best items, see if there is one of same value but lighter
			for(int i = 0; i < list.size(); i++)
			{
				int itemWeight = weights[list.get(i)];
				int itemValue = values[list.get(i)];
				for(int j = 0; j < values.length; j++)
				{	
					if(itemValue == values[j] && weights[j] < itemWeight
							&& !list.contains(j)) // make sure no duplicate items
					{
						list.set(i, j);
					}
				}
			}
			// create and clean up string
			Collections.sort(list);
			String temp = list.toString();
			bestItems = temp.substring(1, list.toString().length() - 1).replace(" ", "");
		}		
		return bestItems;
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
