package AsQuickAsAFlash;

import java.io.*;
import java.util.Arrays;
/**
 * As Quick as a Flash / Challenge 239 / Hard
 * 
 * https://www.codeeval.com/open_challenges/239/
 * 
 * @Todo: Challenge is unclear on pivot choice / partition scheme
 *        being used, which greatly affects number of pivots per
 *        quicksort. Need to keep tweaking until I find their 
 *        implementation choice, as I only have 70% completion at the
 *        moment; however, I do pass all of their initial test input.
 * 
 * @author Joe Stover
 * @version May 16, 2016
 */
public class Main 
{
	static int pivotCount;
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = null;
		String line = null;
		try
		{
			reader = generateInputReader(args);
			while((line = reader.readLine()) != null)
			{
				pivotCount = 0;
				String[] temp = line.split(" ");
				int[] array = new int[temp.length];
				for(int i = 0; i < temp.length; i++)
				{
					array[i] = Integer.parseInt(temp[i]);
				}
				quickSort(array, 0, array.length - 1);
				System.out.println(Arrays.toString(array));
			}
		}
		finally
		{
			reader.close();
		}
	}
	/**
	 * Sorts an array in place with result in ascending order using the 
	 * quicksort algorithm. Array is partitioned based on a pivot, with
	 * each partition recursively quicksorted until sub-array is a single
	 * index (and hence, automatically sorted).
	 * 
	 * @param array of ints to be sorted
	 * @param start beginning index of the array/sub-array
	 * @param end last index of the array/sub-array
	 */
	public static void quickSort(int[] array, int start, int end)
	{
		// base case = single index is already sorted
		if(start >= end)
		{	
			return;
		}
        int pivotIndex = partition(array, start, end); // get last pivot
        quickSort(array, start, pivotIndex); // sort left of pivot
        quickSort(array, pivotIndex + 1, end); // sort right of pivot
	}
	/**
	 * Partitions an array into a "low side" and "high side" around
	 * a pivot value. Low and high are, themselves, unsorted. Pivot
	 * index is always first in the array.
	 * 
	 * @param array of ints to be partitioned
	 * @param start index for this section of the array
	 * @param end index for this section of the array
	 * @return index of the pivot value
	 */
	public static int partition(int[] array, int start, int end)
	{
		// only increment pivot if there is more than one index
		// to "partition" (single index IS NOT a pivot)
		if(end - start >= 1)
		{
			pivotCount++;
		}
		int pivot = array[start]; // choose first index as pivot
		// only go until start and end indices meet
		while(start < end)
		{
			// increment our start line if value at index is already less than pivot
			while(array[start] < pivot)
			{
				start++; 
			}
			// decrement our finish line if value at index is already greater than pivot
			while(array[end] > pivot)
			{
				end--;
			}
			// make a swap when you meet a value outside the conditions 
			// (lower val to right, higher to left of pivot)
			swap(array, start, end);
		}
		return start;
	}
	public static void swap(int[] array, int i, int j)
	{
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
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


