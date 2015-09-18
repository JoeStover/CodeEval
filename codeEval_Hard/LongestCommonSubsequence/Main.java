package LongestCommonSubsequence;

import java.io.*;

/**
 * Longest Common Subsequence / Challenge 6 / Hard
 * 
 * https://www.codeeval.com/open_challenges/6/
 * 
 * @author Joe Stover
 * @version Sept. 15, 2015
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
				if(!line.isEmpty())
				{
					String[] parts = line.split(";");
					System.out.println(longestCommonSub(parts[0], parts[1]));
				}
			}
		}
		finally
		{
			reader.close();
		}
	}
	/**
	 * Finds the longest subsequence shared by 2 strings utilizing DP.
	 * Sequence does not need to be contiguous chars, but does need to follow
	 * the same ordering.
	 * 
	 * @param s1  1st string to be compared for LCS
	 * @param s2  2nd string to be compared for LCS
	 * @return string of the longest subsequence shared by s1 and s2
	 */
	public static String longestCommonSub(String s1, String s2)
	{
		// cache our lengths to find answer
		int[][] strSize = new int[s1.length() + 1][s2.length() + 1];
		for(int row = 0; row < s1.length(); row++)
		{
			for(int col = 0; col < s2.length(); col++)
			{
				// if the chars match, then increment current cached size by 1
				// else this index holds the greater of the prev cached lengths
				strSize[row + 1][col + 1] =
						(s1.charAt(row) == s2.charAt(col)) ?
							strSize[row][col] + 1 :
								Math.max(strSize[row + 1][col], 
										strSize[row][col + 1]);
			}
		}
		// work backwards through matrix to build the lcs based on saved string
		// lengths
		StringBuffer lcs = new StringBuffer();
		int row = s1.length();
		int col = s2.length();
		// traverse the matrix until we get to origin index and rebuild the
		// lcs using stored lengths to build it in reverse by char position in
		// original strings
		while(row != 0 && col != 0)
		{
			if(strSize[row][col] == strSize[row - 1][col])
			{
				row--;
			}
			else if(strSize[row][col] == strSize[row][col - 1])
			{
				col--;
			}
			else
			{
				lcs.append(s1.charAt(row - 1));
				row--;
				col--;
			}
		}
		return lcs.reverse().toString();
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

