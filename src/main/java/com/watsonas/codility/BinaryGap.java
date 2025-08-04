package com.watsonas.codility;

public class BinaryGap {

	public static int solution( int N ) {
		System.out.println(N);
		boolean foundAOne = false;
		boolean inGap = false;
		int gapSize = 0;
		int largestGapSize = 0;
		int sqrtN = Double.valueOf(Math.sqrt(N) ).intValue();
		int runningNumber = N;
		for ( int iteration = 0; iteration <= sqrtN; iteration ++ ) {
			if ( ( runningNumber & 0b01 ) == 1 ) {
				System.out.println("1");
				if ( inGap ) {
					if ( gapSize > largestGapSize ) {
						largestGapSize = gapSize;
					}
					inGap = false;
				}
				foundAOne = true;
			}
			else {  
				System.out.println("0");
				if ( foundAOne ) {
					inGap = true;
					gapSize = 0;
				}
				foundAOne = false;
				if ( inGap ) {
					gapSize++;  // found a 0.. add to gap size
				}
			}
			runningNumber = runningNumber >> 1;
		}
		
		return largestGapSize;
	}
}
