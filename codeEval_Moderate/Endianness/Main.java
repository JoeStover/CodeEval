package Endianness;

import java.nio.ByteOrder;

/**
 * Endianness / Challenge 15 / Moderate
 * 
 * https://www.codeeval.com/open_challenges/15/
 * 
 * @author Joe Stover
 * @version Dec 03, 2014
 */
public class Main 
{
	public static void main(String[] args)
	{
		System.out.println(ByteOrder.nativeOrder().
				equals(ByteOrder.BIG_ENDIAN) ? "BigEndian" : "LittleEndian");
	}
}
