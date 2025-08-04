package com.watsonas.codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;


public class MinAbsSumFork {
	ForkJoinPool commonPool = ForkJoinPool.commonPool();
	
	public static int solution( int[] A ) {
		
		// create all possibilites then iterate though them?
		// sort numbers, then apply + and - alternately?
		Double possibles = Math.pow(2, A.length);
		int[][] allPossibilities = new int[possibles.intValue()][];
		
		/* for length 2...4 poss... for length 3, 8 poss etc... 2 to the power of fun.
		 *  1, 1    1     0001
		 * -1, 1    2     0010
		 *  1,-1    3     0011
		 * -1,-1    4     0010
		 *          x
		 */
		for( int x = 0; x < allPossibilities.length; x++ ) {
			
			int[] multipliers = new int[A.length ];
			int mask = x;
			// 1,1... -1, 1.. -1, -1..... N possible
			for( int i = 0; ( i < A.length &&  ( mask > 0 )); i++ ) {
				// if bit 0 of x is 0, set -1 else set 1
				multipliers[i] = ( mask & 0b0001 );
				//System.out.println("Multiplier " + i + " is " + multipliers[i] + " x is "  + x + " mask is " + mask );
				mask = mask >> 1;
				
			}
			allPossibilities[x] = multipliers;
			//System.out.println("Possibilities " + x + " is " + Arrays.asList(allPossibilities[x] ));
		}

		CustomRecursiveTask crt = new CustomRecursiveTask( A, allPossibilities );
		Integer minSum = crt.compute();
		
		System.out.println("Minsum " + minSum );
		
		return minSum;
	}
	
	static int apply( int[] A, int[] multipliers ) {
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
	    private int[][] possibilities;

	    private static final int THRESHOLD = 512;

	    public CustomRecursiveTask(int[]data, int[][] possibilities) {
	    	this.data = data;
	        this.possibilities = possibilities;
	    }

	    @Override
	    protected Integer compute() {
	        if (possibilities.length > THRESHOLD) {
	            int minSum = ForkJoinTask.invokeAll(createSubtasks())
	              .stream()
	              .mapToInt(ForkJoinTask::join).min().getAsInt();
	            
	    		// System.out.println("Minsum " + minSum + " from " + possibilities.length + " possibilities");
	    		
	    		return minSum;


	        } else {
	            return processing(data, possibilities);
	        }
	    }

	    private Collection<CustomRecursiveTask> createSubtasks() {
	        List<CustomRecursiveTask> dividedTasks = new ArrayList<>();
	        dividedTasks.add(new CustomRecursiveTask(data,
	          Arrays.copyOfRange(possibilities, 0, possibilities.length / 2)));
	        dividedTasks.add(new CustomRecursiveTask(data,
	          Arrays.copyOfRange(possibilities, possibilities.length / 2, possibilities.length)));
	        return dividedTasks;
	    }

	    private Integer processing(int[] data, int[][] allPossibilities) {
			int minSum = -1;
			for( int y = 0; y < allPossibilities.length; y++ ) {
				int sum = apply( data, allPossibilities[y]);
				if ( minSum == -1 || sum < minSum ) {
					minSum = sum;
				}
			}
			return minSum;
	    }
	}
	
}
