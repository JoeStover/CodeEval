package MersennePrime;

import java.io.*;

/**
 * Mersenne Prime / Challenge 240 / Easy
 * 
 * https://www.codeeval.com/open_challenges/240/
 * 
 * @author Joe Stover
 * @version Mar 19, 2016
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
				System.out.println(solution(line));
			}
		}
		finally
		{
			reader.close();
		}
	}
	/**
	 * Solves the challenge for a given line input.
	 * 
	 * @param line String input to be solved for
	 * @return String solution to this line
	 */
	public static String solution(String line)
	{
		int limit = Integer.parseInt(line);
		String allMersPrimes = "";
		int n = 2;
		int mers = mersOf(n);
		while(mers < limit)
		{
			if(isPrime(n))
			{
				allMersPrimes += mers + ", ";
			}			
			n++;
			mers = mersOf(n);
		}
		return (allMersPrimes.isEmpty()) ? allMersPrimes :
				allMersPrimes.substring(0, allMersPrimes.length() - 2);
	}
	/**
	 * Finds Mersenne number for a given n.
	 * 		Mn = 2^n - 1
	 * 
	 * Note: Most online information alludes to M(n) being the prime, but this breaks
	 * for 2047 which is composite. So I am going to assume they mean n has to be
	 * prime...
	 * 
	 * @param n to be passed into Mersenne function	
	 * @return Mersenne number for a given n
	 */
	public static int mersOf(int n)
	{
		return (int)Math.pow(2, n) - 1;
	}
	 /**
	 * Verify primality of a passed in integer.
	 * 
	 * @param num integer to be checked
	 * @return true if prime, false otherwise
	 */
	public static boolean isPrime(int num)
	    {
	        if(num == 2)
	        {
	            return true; // deal with 2 before we skip evens during iteration
	        }
	        else if(num % 2 == 0 || num < 2) // cover 1 and 0 not being prime
	        {
	            return false; // only even prime is 2
	        }
	        else
	        {
	            // start at 3 and increment odd (as evens can't be prime beyond 2)
	            // only need to go through up to a nums square root
	            for(int i = 3; i <= Math.sqrt(num); i += 2)
	            {
	                if(num % i == 0)
				    {
					    return false;
				    }
	            }
	        }    
	        return true; // made it through tests, must be prime
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
