package com.watsonas.codility;

public class IsPrime {

	public static boolean solution( int N ) {
		
		// number is prime if indivisible by any other number
		// only need to test up to sqrt(N)
		// even numbers are never prime
		
		if ( N < 2 ) return false;
		if ( N < 4 ) return true;
		int sqrtN = (int) Math.sqrt(N);
		for ( int divisor = 2; divisor <= sqrtN; divisor ++ ) {
			if ( N % divisor == 0 ) {
				//System.out.println("N can be divided by " + divisor + " and is therefore not prime");
				return false;
			}
		}

		return true;
	}
}
