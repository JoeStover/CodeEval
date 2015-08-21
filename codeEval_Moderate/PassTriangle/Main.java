package PassTriangle;

import java.io.*;
import java.util.*;

/**
 * Pass Triangle / Challenge 89 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/89/
 * 
 * @author Joe Stover
 * @version Apr 01, 2015
 */
public class Main 
{
    public static void main(String[] args) throws IOException
    {
    	// nested arraylists to hold our tree structure
        ArrayList<ArrayList<Integer>> triangle = 
        		new ArrayList<ArrayList<Integer>>();
        BufferedReader reader = null;
		String line = null;
		try
		{
			reader = generateInputReader(args);
			while((line = reader.readLine()) != null)
			{
        		String[] digits = line.split(" ");
        		// load up sections of the tree
        		ArrayList<Integer> tempList = new ArrayList<Integer>();
        		for(String digit : digits)
        		{
        			tempList.add(Integer.parseInt(digit));
        		}
        		triangle.add(tempList);
        	}
        	System.out.println(getMaxSum(triangle));
        }
        finally
        {
        	reader.close();
        }       
    }
    /**
     * Gets the maximum sum for the passed in triangle. Path for this sum starts
     * at the top of the triangle and moves to adjacent numbers on the row below
     * until reaching the base.
     * 
     * Algorithm follows a bottom up approach, with the sum "bubbling" up to
     * the top of the passed in triangle.
     * 
     * @param  triangle to be solved
     * @return maximum sum for the passed in triangle
     */
    public static int getMaxSum(ArrayList<ArrayList<Integer>> triangle) 
    {
    	// work from the bottom of the triangle and move up to get sums
        for (int row = triangle.size() - 2; row >= 0; row--) 
        {
        	// move left to right along bottom of triangle
            for (int col = 0; col <= row; col++)
            {
            	// set values as you move up
                if(triangle.get(row + 1).get(col) > 
                	triangle.get(row + 1).get(col + 1)) 
                {
                    triangle.get(row).set(col, 
                    		triangle.get(row + 1).get(col) + 
                    			triangle.get(row).get(col));
                }
                else
                {
                	triangle.get(row).set(col, 
                			triangle.get(row + 1).get(col + 1) + 
                				triangle.get(row).get(col));
                }              
            }
        }
        // sum bubbled up to top
        return triangle.get(0).get(0);
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
