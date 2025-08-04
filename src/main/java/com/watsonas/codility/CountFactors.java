package com.watsonas.codility;

public class CountFactors {

	public static int solution( int N ) {
		if ( N < 0 ) throw new RuntimeException("Expected positive integers");
		int factors = 0;
		int sqrtN = (int) Math.sqrt(N);
		System.out.println("Sqrt " + N + " is " + sqrtN );
		for ( int divisor = 1; divisor <= sqrtN; divisor ++ ) {
			if ( N % divisor == 0 ) {
				System.out.println("Factor is " + divisor );
				factors += 1;
			}
		}
		factors *= 2;
		
        if( sqrtN * sqrtN == N){   
        	factors -= 1; 
        }
		
		return factors;
	}
}
