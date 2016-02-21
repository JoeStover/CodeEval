package Football;

import java.io.*;
import java.util.*;

/**
 * Football / Challenge 230 / Easy
 * 
 * https://www.codeeval.com/open_challenges/230/
 * 
 * @author Joe Stover
 * @version Feb 1, 2016
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
				System.out.println(solve(line));
			}
		}
		finally
		{
			reader.close();
		}
	}
	/**
	 * Solves a single line based on input for this challenge.
	 * 
	 * @param line String input to be solved in this challenge
	 * @return solution based on given input
	 */
	public static String solve(String line)
	{
		String answer = "";
		// key is team, ArrayList contains all countries that root for the team (use TreeMap for sorted Keys)
		Map<Integer, ArrayList<Integer>> map = new TreeMap<Integer, ArrayList<Integer>>();
		String[] countries = line.split("\\ \\|\\ ");
		for(int i = 0; i < countries.length; i++)
		{
			String[] teams = countries[i].split(" ");
			for(String team : teams)
			{
				int teamNum = Integer.parseInt(team);
				if(map.containsKey(teamNum))
				{
					map.get(teamNum).add(i + 1);
				}
				else
				{
					map.put(teamNum, new ArrayList<Integer>());
					map.get(teamNum).add(i + 1);
				}
			}
		}
		for(Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet())
		{
			answer += entry.getKey() + ":";
			ArrayList<Integer> list = entry.getValue();
			Collections.sort(list);
			String temp = list.toString().replace(" ", "");
			answer += temp.substring(1, temp.length() -1) + "; ";
		}
		return answer.trim();
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

