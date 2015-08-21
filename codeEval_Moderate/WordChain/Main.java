package WordChain;

import java.io.*;
import java.util.*;

/**
 * Word Chain / Challenge 135 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/135/
 * 
 * @author Joe Stover
 * @version Mar 05, 2015
 * 
 * TODO: Need to work on debugging this. Only getting 37.5% on CodeEval. Need to
 *       add additional tests and step through to check logic.
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
				// e.g. soup,sugar,peas,rice
				String[] words = line.split(",");
				// adjacency matrix that maps to array words
				// row = outgoing edges from a given vertex (last letter)
				// col = incoming edges from a given vertex (first letter)
				// 0 = no connection;  1 = connection
				int[][] wordGraph = new int[words.length][words.length];
				for(int row = 0; row < words.length; row++)
				{
					for(int col = 0; col < words.length; col++)
					{
						if(row == col)
						{
							// not interested in self pointing cycle, set to 0
							wordGraph[row][col] = 0;
						}
						else
						{
							char fromLast = words[row].charAt(words[row].length() - 1);
							char toFirst = words[col].charAt(0);
							if(fromLast == toFirst)
							{
								wordGraph[row][col] = 1;
							}
							else
							{
								wordGraph[row][col] = 0;
							}
						}
					}
				}
				System.out.println(getLongestChain(wordGraph));
			}
		}
		finally
		{
			reader.close();
		}
	}
	/**
	 * Finds the longest possible word chain in a graph (adj. matrix).
	 * 
	 * @param graph the adjacency matrix to check
	 * @return the count for the longest word chain in the adj matrix
	 */
	public static String getLongestChain(int[][] graph)
	{
		int longestChain = 0;
		for(int i = 0; i < graph.length; i++)
		{
			longestChain = Math.max(longestChain, 
					getChainLengthFromNode(graph, i));
		}
		if(longestChain < 2)
		{
			return "None";
		}
		else
		{
			return longestChain + "";
		}
	}
	
	/**
	 * Gets chain length from a specific node in adjacency matrix using DFS.
	 * 
	 * @param matrix adjacency matrix to check
	 * @param node in matrix
	 * @return total nodes chained to the passed in node
	 */
	public static int getChainLengthFromNode(int[][] matrix, int node)
    {    
	    Stack<Integer> stack = new Stack<Integer>();
	    boolean[] isVisited = new boolean[matrix.length];
	    int totalNodes = 1;
	    
	    stack.push(node);
	
	    while(!stack.isEmpty())
	    {
	        int vertex = stack.pop();
	        if(!isVisited[vertex])
	        {
	            isVisited[vertex] = true;
	        }
	        for (int i=0;i<matrix.length;i++)
	        {
	            if((matrix[vertex][i] == 1) && (!isVisited[i]))
	            {
	                stack.push(vertex);
	                isVisited[i] = true;
	                totalNodes++;
	                vertex = i;
	            }
	        }
	    }
	    return totalNodes;
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

