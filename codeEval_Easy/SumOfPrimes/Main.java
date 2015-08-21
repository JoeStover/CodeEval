package SumOfPrimes;

/**
 * Sum of Primes / Challenge 4 / Easy
 * 
 * https://www.codeeval.com/open_challenges/4/
 * 
 * "Write a program which determines the sum of the first 1000 prime numbers."
 * 
 * @author Joe Stover
 * @version Nov 06, 2014
 */
public class Main 
{
	public static void main(String[] args) 
	{
		Main object = new Main();	
		int num = 2;
        int count = 0;
        int sumTotal = 0;
        while(count < 1000)
        {
            if(object.isPrime(num))
            {
            	sumTotal += num;
                count++;
            }
            num++;
        }
        System.out.println(sumTotal);
	}
	/**
	 * Verify if a number is prime.
	 * 
	 * @param num to be checked for "prime"-ness
	 * @return true if the num is prime, false otherwise
	 */
	public boolean isPrime(int num)
	{
		for(int i = 2; i <= num/2; i++)
		{
			if(num % i == 0)
			{
				return false;
			}
		}
		return true;
	}
}
