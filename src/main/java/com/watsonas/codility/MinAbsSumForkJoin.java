package com.watsonas.codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;


public class MinAbsSumForkJoin {
	ForkJoinPool commonPool = ForkJoinPool.commonPool();
	
	public static int solution( int[] A ) {
		
		// create all possibilites then iterate though them?
		// sort numbers, then apply + and - alternately?
		double possibilities = Math.pow(2, A.length);
		Integer possibles = Double.valueOf(possibilities).intValue();
		int[] multiplierNumbers = new int[possibles];
		
		/* for length 2...4 poss... for length 3, 8 poss etc... 2 to the power of fun.
		 *  1, 1    1     0001
		 * -1, 1    2     0010
		 *  1,-1    3     0011
		 * -1,-1    4     0010
		 *          x
		 */
		for( int x = 0; x < possibles; x++ ) {
			multiplierNumbers[x] = x;
		}

		CustomRecursiveTask crt = new CustomRecursiveTask( A, multiplierNumbers );
		Integer minSum = crt.compute();
		
		// System.out.println("Minsum " + minSum );
		
		return minSum;
	}
	
	static int apply( int[] A, int multiplierNumber ) {
		
		int[] multipliers = new int[A.length ];
		int mask = multiplierNumber;
		// 1,1... -1, 1.. -1, -1..... N possible
		for( int i = 0; ( i < A.length &&  ( mask > 0 )); i++ ) {
			// if bit 0 of x is 0, set -1 else set 1
			multipliers[i] = ( mask & 0b0001 );
			//System.out.println("Multiplier " + i + " is " + multipliers[i] + " x is "  + x + " mask is " + mask );
			mask = mask >> 1;
		}
		
		int sum = 0;
		for( int i = 0; i < A.length; i++ ) {
			int factor = ( multipliers[i] == 0 ? 1 : -1 );
			sum += A[i] * factor;
		//	System.out.println("Adding " + A[i] * factor + " factor is " + factor ) ;
		}
		return Math.abs(sum);
	}

	@SuppressWarnings("serial")
	public static class CustomRecursiveTask extends RecursiveTask<Integer> {
		int[] data;
	    private int[]multiplierNumbers;

	    private static final int THRESHOLD = 512;

	    public CustomRecursiveTask(int[]data, int[] multiplierNumbers) {
	    	this.data = data;
	        this.multiplierNumbers = multiplierNumbers;
	    }

	    @Override
	    protected Integer compute() {
	        if (multiplierNumbers.length > THRESHOLD) {
	            int minSum = ForkJoinTask.invokeAll(createSubtasks())
	              .stream()
	              .mapToInt(ForkJoinTask::join).min().getAsInt();
	            
	    		return minSum;


	        } else {
	            return processing(data, multiplierNumbers);
	        }
	    }

	    private Collection<CustomRecursiveTask> createSubtasks() {
	        List<CustomRecursiveTask> dividedTasks = new ArrayList<>();
	        dividedTasks.add(new CustomRecursiveTask(data,
	          Arrays.copyOfRange(multiplierNumbers, 0, multiplierNumbers.length / 2)));
	        dividedTasks.add(new CustomRecursiveTask(data,
	          Arrays.copyOfRange(multiplierNumbers, multiplierNumbers.length / 2, multiplierNumbers.length)));
	        return dividedTasks;
	    }

	    private Integer processing(int[] data, int[] multiplierNumbers ) {
			int minSum = -1;
			for( int y = 0; y < multiplierNumbers.length; y++ ) {
				int sum = apply( data, multiplierNumbers[y]);
				if ( minSum == -1 || sum < minSum ) {
					minSum = sum;
				}
			}
			return minSum;
	    }
	}
	
}
