package StackImplementation;

import java.io.*;
import java.util.ArrayList;

/**
 * Stack Implementation / Challenge 9 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/9/
 * 
 * @author Joe Stover
 * @version Nov 07, 2014
 */
public class Main 
{
	// instance vars
	ArrayList<Integer> stack;
	
	/**
	 * Default "Stack" constructor.
	 */
	public Main()
	{
		this.stack = new ArrayList<Integer>();
	}
	/**
	 * Pushes an int onto the Stack.
	 * 
	 * @param number the integer to be placed on the Stack
	 */
	public void push(int number)
	{
		this.stack.add(number);
	}
	/**
	 * Pops an int off the Stack. Simulated by removing 
	 * from the end of the ArrayList.
	 * 
	 * @return the int on the top of the Stack (LIFO)
	 */
	public int pop()
	{
		return this.stack.remove(stack.size() - 1);
	}

	public static void main(String[] args) throws IOException 
	{
		Main stack = new Main();
		BufferedReader reader = null;
		String line = null;
		try
		{
			reader = generateInputReader(args);
			while((line = reader.readLine()) != null)
			{
				String[] array = line.split(" ");
				for(int i = 0; i < array.length; i++)
				{
					stack.push(Integer.parseInt(array[i]));
				}
				for(int i = 2; i < array.length + 2; i++)
				{
					int temp = stack.pop();
					// check even index to print every other pop
					if(i % 2 == 0)
					{
						System.out.print(temp + " ");
					}
				}
				System.out.println("");
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
