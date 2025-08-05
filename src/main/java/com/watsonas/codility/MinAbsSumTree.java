package com.watsonas.codility;

import java.util.ArrayList;
import java.util.List;


public class MinAbsSumTree {
	
	public static int solution( int[] A ) {
		
		// 5,4,3,3,3	
		//           root
		//       -5        5
		//    -4     4   4    4
		// when adding, find each leaf, create 2 new leaves, left and right

		CountingNode root = new CountingNode( 0,0, null,null,true);
		List<CountingNode> finalLeaves = new ArrayList<CountingNode>();
		
		for ( int i = 0; i < A.length; i++ ) {
			addValue( root, A[i], ( i ==  A.length - 1 ) ? finalLeaves : null );
		}
		
		//System.out.println("Build tree");
		
		// search tree for values
		// AtomicInteger minValue = getMinValue( root, -1, new AtomicInteger ( Integer.MAX_VALUE ) );
		
		// search list for values
		int minValue = Integer.MAX_VALUE;
		
		for( CountingNode node : finalLeaves ) {
			minValue = ( Math.min( Math.abs( node.count ), minValue ) );
			
		}
		
		//System.out.println("Found min value tree");
		return minValue;
	}

	// can we store list of final nodes?
	private static void addValue( CountingNode node, int value, List<CountingNode> finalLeaves ) {
		if ( node.isLeaf() ) {
			// adding 
			CountingNode plus = new CountingNode( value, node.count + value, null, null,false );
			// System.out.println("Added plus side " + plus );
			if ( finalLeaves != null ) {
				finalLeaves.add(plus);
			}

			// subtracting
			CountingNode minus = new CountingNode( value, node.count - value, null, null, false );
			// System.out.println("Added minus side " + plus );
			if ( finalLeaves != null ) {
				finalLeaves.add(minus);
			}

			node.plus = plus;
			node.minus = minus;
		} else {
			// recursive add of leaves
			addValue( node.plus, value, finalLeaves );
			addValue( node.minus, value, finalLeaves );
		}
	}
	
	static class CountingNode {

		int value;
		int count;
		boolean root;
		CountingNode plus;
		CountingNode minus;

		public CountingNode(int value, int count, CountingNode plus, CountingNode minus, boolean root ) {
			this.value = value;
			this.count = count;
			this.plus = plus;
			this.minus = minus;
			this.root = root;
		}

		boolean isRoot( ) {
			return root;
		}

		boolean isLeaf( ) {
			return plus == null && minus == null;
		}
		
		CountingNode getPlus() {
			return plus;
		}
		
		CountingNode getMinus() {
			return minus;
		}
		
		@Override
		public String toString() {
			return String.format("CountingNode [value=%s, count=%s, plus=%s, minus=%s]", value, count, plus, minus);
		}

	}

}
