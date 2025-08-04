package com.watsonas.codility;

import java.util.HashMap;
import java.util.Map;

public class Dominator {

	public static int solution( int[] A ) {
		if ( A.length == 0 ) return -1;
		int halfLength = A.length / 2;

		Map<Integer,IndexData> mapOfValues = new HashMap<>();
		
		for( int i = 0; i < A.length; i++ ) {
			IndexData id = new IndexData( i, 1 );
			IndexData existing = mapOfValues.putIfAbsent( A[i], id );
			if ( existing != null ) {
				existing.count = existing.count + 1;
			}
		}

		for( Integer value : mapOfValues.keySet() ) {
			if ( mapOfValues.get(value).count > halfLength ) {
				return mapOfValues.get(value).index;
			}
		}
		return -1;
	}
	
	private static class IndexData {
		final int index;
		int count;

		public IndexData(int index, int count) {
			this.index = index;
			this.count = count;
		}
		
	}


}
