package com.watsonas.codility;

public class Fibonnaci {

	public static int solution( int n ) {

		// 0,1,1,2,3,5,8,13,21
		int[] fib = new int[n + 2];
		fib[1] = 1;
		for ( int i = 2; i < n + 1; i++ ) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}
		return fib[n];
	}	
}
