package com.watsonas.codility;


public class MinAbsSumArrayEfficient {

	
	public static int solution( int[] A ) {
		
		// create all possibilites then iterate though them?
		// sort numbers, then apply + and - alternately?
		Double possibles = Math.pow(2, A.length);
		
		/* for length 2...4 poss... for length 3, 8 poss etc... 2 to the power of fun.
		 *  1, 1    1     0001
		 * -1, 1    2     0010
		 *  1,-1    3     0011
		 * -1,-1    4     0010
		 *          x
		 */
		int minSum = -1;

		for( int x = 0; x < possibles; x++ ) {
			
			int[] multipliers = new int[A.length ];
			int mask = x;
			// 1,1... -1, 1.. -1, -1..... N possible
			for( int i = 0; ( i < A.length &&  ( mask > 0 )); i++ ) {
				// if bit 0 of x is 0, set -1 else set 1
				multipliers[i] = ( mask & 0b0001 );
				mask = mask >> 1;
				
			}
		
			int sum = apply( A, multipliers );
				if ( minSum == -1 || sum < minSum ) {
					minSum = sum;
			}	
			
		}
		
		//  System.out.println("Minsum hit is " + hit + " of "  + minSum  );
		
		return minSum;
	}
	
	static int apply( int[] A, int[] multipliers ) {
		int sum = 0;
		for( int i = 0; i < A.length; i++ ) {
			int factor = ( multipliers[i] == 0 ? 1 : -1 );
			sum += A[i] * factor;
			// System.out.println("Adding " + A[i] * factor + " factor is " + factor ) ;
		}
		return Math.abs(sum);
	}
}
