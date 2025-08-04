package com.watsonas.codility;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FrogJmp {

	public static int solution( int X, int Y, int D ) {
		if ( Y <= X ) return 0;
		if ( D == 0 ) return 0;
		BigDecimal distance = BigDecimal.valueOf( Y - X );
		return distance.divide( BigDecimal.valueOf(D), RoundingMode.UP ).intValue();
	}



		
}
